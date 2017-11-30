package com.trucs.comp2160_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddMapActivity extends AppCompatActivity {

    final MapDao mapDao = App.get().getDB().mapDao();
    EditText mapName;
    Map map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_map);

        mapName = (EditText) findViewById(R.id.edit_map_name);
    }

    public void goBack(View v) {
        Intent myIntent = new Intent(AddMapActivity.this, MapListActivity.class);
        startActivity(myIntent);
    }

    public void addMapToDatabase(View v) {
        if(!mapName.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), mapName.getText().toString(), Toast.LENGTH_SHORT).show();
            map = new Map(mapName.getText().toString(), "testing");
            mapDao.insert(map);
            goBack(v);
        } else {
            Toast.makeText(getApplicationContext(), "No Name Entered", Toast.LENGTH_SHORT).show();
        }
    }
}
