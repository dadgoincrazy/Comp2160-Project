package com.trucs.comp2160_project;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * Created by Cody on 11/9/2017.
 */
@Entity(tableName = "map")
public class Map {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "map_name")
    private String name;

    @ColumnInfo(name = "file_name")
    private Uri filename;

    public Map(String name, Uri filename) {
        this.name = name;
        this.filename = filename;
    }

    public Uri getFilename() {
        return filename;
    }

    public void setFilename(Uri filename) {
        this.filename = filename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getPictureFromUri(Context context) throws Exception {
        Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), getFilename());
        return bitmap;
    }


}
