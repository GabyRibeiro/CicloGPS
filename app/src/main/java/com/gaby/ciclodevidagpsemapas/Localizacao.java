package com.gaby.ciclodevidagpsemapas;

public class Localizacao {

    double lat;
    double lon;

    public Localizacao (double lat, double lon)  {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLatitude() {
        return lat;
    }

    public void setLatitude(double latitude) {
        this.lat = latitude;
    }

    public double getLongitude() {
        return lon;
    }

    public void setLongitude(double longitude) {
        this.lon = longitude;
    }

}
