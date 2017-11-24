package com.trucs.comp2160_project;

/**
 * Created by Cody on 11/16/2017.
 */

public class Marker {

    Integer x;
    Integer y;
    String desc;
    String type;

    public Marker(Integer x, Integer y, String desc, String type) {
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
