package com.trucs.comp2160_project;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;

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

//        maps = new ArrayList<>();

//        Map map1 = new Map("test1", "test1filename");
//        mapDao.insert(map1);
//        maps.add(new Map("test2", "test2filename"));
//        maps.add(new Map("test3", "test3filename"));
//        maps.add(new Map("test4", "test4filename"));
//        maps.add(new Map("test5", "test5filename"));
//        maps.add(new Map("test6", "test6filename"));
//        maps.add(new Map("test7", "test7filename"));
//        maps.add(new Map("test8", "test8filename"));
//        maps.add(new Map("test9", "test9filename"));
//        maps.add(new Map("test10", "test10filename"));
//        maps.add(new Map("test11", "test11filename"));
//        maps.add(new Map("test12", "test12filename"));
//        maps.add(new Map("test13", "test13filename"));
//        maps.add(new Map("test14", "test14filename"));
//        maps.add(new Map("test15", "test15filename"));

        maps = new ArrayList<>(mapDao.getAll());
        // Delete all maps
//        for(Map map : maps) {
//            mapDao.delete(map);
//        }

        adapter = new MapAdapter(maps, getApplicationContext());

        listView.setAdapter(adapter);
    }

    public void addMap(View v) {
        Intent myIntent = new Intent(MapListActivity.this, AddMapActivity.class);
        startActivity(myIntent);
    }
}
