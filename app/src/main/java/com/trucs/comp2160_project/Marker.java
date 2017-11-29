package com.trucs.comp2160_project;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Cody on 11/16/2017.
 */

@Entity(tableName = "marker",
        foreignKeys = @ForeignKey(
                entity=Map.class,
                parentColumns = "id",
                childColumns = "map_id"
        ))
public class Marker {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "pos_x")
    private Integer x;

    @ColumnInfo(name = "pos_y")
    private Integer y;

    @ColumnInfo(name = "desc")
    private String desc;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "map_id")
    public Integer map_id;

    public Marker(Integer map_id, Integer x, Integer y, String desc, String type) {
        this.map_id = map_id;
        this.x = x;
        this.y = y;
        this.desc = desc;
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
