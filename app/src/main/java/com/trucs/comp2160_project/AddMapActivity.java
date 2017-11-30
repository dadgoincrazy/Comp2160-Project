package com.trucs.comp2160_project;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddMapActivity extends AppCompatActivity {

    final MapDao mapDao = App.get().getDB().mapDao();
    EditText mapName;
    TextView fileLocation;
    Map map;
    public static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_map);

        mapName = (EditText) findViewById(R.id.edit_map_name);
        fileLocation = (TextView) findViewById(R.id.file_location);
    }

    public void goBack(View v) {
        Intent myIntent = new Intent(AddMapActivity.this, MapListActivity.class);
        startActivity(myIntent);
    }

    public void addMapToDatabase(View v) {
        if(!mapName.getText().toString().equals("")) {
            if(!fileLocation.getText().toString().equals(""))
            {
                map = new Map(mapName.getText().toString(), fileLocation.getText().toString());
                mapDao.insert(map);
                goBack(v);
            } else {
                Toast.makeText(getApplicationContext(), "No File Chosen", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "No Name Entered", Toast.LENGTH_SHORT).show();
        }
    }

    public void pickImage(View v) {
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

        startActivityForResult(chooserIntent, PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if(data == null) {
                Toast.makeText(getApplicationContext(), "Something went wrong getting picture", Toast.LENGTH_SHORT).show();
            } else {
                String filepath = data.getData().getPath();
                fileLocation.setText(filepath);
                Toast.makeText(getApplicationContext(), filepath, Toast.LENGTH_SHORT).show();
            }
        }
    }

}
