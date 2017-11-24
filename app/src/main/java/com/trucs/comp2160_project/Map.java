package com.trucs.comp2160_project;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.List;

/**
 * Created by Cody on 11/9/2017.
 */

public class Map {

    String name;
    Uri filename;
    List<Marker> markerList;

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

    public List<Marker> getMarkerList() {
        return markerList;
    }

    public void setMarkerList(List<Marker> markerList) {
        this.markerList = markerList;
    }

    public Bitmap getPictureFromUri(Context context) throws Exception {
        Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), getFilename());
        return bitmap;
    }


}
