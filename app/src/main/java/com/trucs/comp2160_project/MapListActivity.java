package com.trucs.comp2160_project;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;

public class MapListActivity extends AppCompatActivity{

    ArrayList<Map> maps;
    ListView listView;
    private MapAdapter adapter;
    final MapDao mapDao = App.get().getDB().mapDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_list);


        listView = (ListView)findViewById(R.id.list);

        maps = new ArrayList<>(mapDao.getAll());
        // Delete all maps
//        for(Map map : maps) {
//            mapDao.delete(map);
//        }

        adapter = new MapAdapter(maps, getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Map map = maps.get(position);

                Intent myIntent = new Intent(MapListActivity.this, ViewMapActivity.class);
                myIntent.putExtra("map_id", map.getID());
                startActivity(myIntent);
            }
        });
    }

    public void addMap(View v) {
        Intent myIntent = new Intent(MapListActivity.this, AddMapActivity.class);
        startActivity(myIntent);
    }
}
