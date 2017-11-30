package com.trucs.comp2160_project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;

public class ViewMapActivity extends AppCompatActivity {

    TextView title;
    ImageView myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_map);

        final MapDao mapDao = App.get().getDB().mapDao();
        myImage = (ImageView) findViewById(R.id.map_view);
        title = (TextView) findViewById(R.id.title);


        Intent intent = getIntent();
        long map_id = intent.getLongExtra("map_id", 0);

        if(map_id > 0)
        {
            Map map = mapDao.get(map_id);

            title.setText(map.getName().toUpperCase());

            try {
                Picasso.with(getApplicationContext()) // TODO :  DLC PICTURE CONTENT EXCLUSIVE $24.99
                        .load(map.getUri())
                        .resize(50, 50)
                        .centerCrop()
                        .into(myImage);
                myImage.setContentDescription(map.getFilename()); // Doesn't seemingly do anything
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Improper Map ID", Toast.LENGTH_LONG).show();
        }
    }

    public void goBack(View v) {
        Intent myIntent = new Intent(ViewMapActivity.this, MapListActivity.class);
        startActivity(myIntent);
    }

    public void addMarker(View v) {
        // TODO Make AddMarkerActivity
        // Intent myIntent = new Intent(ViewMapActivity.this, AddMarkerActivity.class);
        // startActivity(myIntent);
        Toast.makeText(getApplicationContext(), "Marker adding DLC hasn't been released yet", Toast.LENGTH_LONG).show();
    }
}
