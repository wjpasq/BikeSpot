package com.example.bikespot;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Geocoder {

    private String address;
    private int latitude;
    private int longitude;

    public Geocoder() {

        address = "";
        latitude = 0;
        longitude = 0;
    }


    public String getAddress(int lat, int lon) {

        String addy = "";
        return addy;
    }
}
