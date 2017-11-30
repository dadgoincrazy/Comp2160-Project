package com.trucs.comp2160_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ViewMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_map);

        final MapDao mapDao = App.get().getDB().mapDao();

        Intent intent = getIntent();
        Integer map_id = intent.getIntExtra("map_id", 0);

        if(map_id > 0)
        {
            Map map = mapDao.get(map_id);
            Toast.makeText(getApplicationContext(), map.getName(), Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "Improper Map ID", Toast.LENGTH_LONG).show();
        }
    }
}
