package com.potato.ntumaps.ntubusmap;

/**
 * Created by Administrator on 2016/9/4.
 */
public class Vehicle {
    double lat=0,lon=0;
    int type;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getType() {

        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getLat() {

        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
