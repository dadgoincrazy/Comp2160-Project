package com.trucs.comp2160_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by owner on 29/11/2017.
 */

public class MapAdapter extends ArrayAdapter<Map> implements View.OnClickListener {

    private ArrayList<Map> maps;
    Context context;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
    }

    public MapAdapter(ArrayList<Map> maps, Context context){
        super(context, R.layout.row_item, maps);
        this.maps = maps;
        this.context = context;
    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Map map = (Map) object;

        Toast.makeText(getContext(), String.valueOf(map.getID()), Toast.LENGTH_SHORT).show();
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Get the data item for this position
        Map map = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;

        final View result;

        if(convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtName.setText(map.getName());
        viewHolder.txtName.setOnClickListener(this);
        viewHolder.txtName.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }

}
