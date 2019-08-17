package com.example.bikespot;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BikePlace {

    private int objectID;
    private String address;
    private String businessName;
    private String parkingModules;
    private int totalSpaces;
    private int longitude;
    private int latitude;

    public BikePlace() {
        objectID = 0;
        address = "";
        businessName = "";
        parkingModules = "";
        totalSpaces = 0;
    }

    public BikePlace(int objectID, String address, String businessName, String parkingModules, int totalSpaces) {
        this.objectID = objectID;
        this.address = address;
        this.businessName = businessName;
        this.parkingModules = parkingModules;
        this.totalSpaces = totalSpaces;
    }

    public int getObjectID() {
        return objectID;
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getParkingModules() {
        return parkingModules;
    }

    public void setParkingModules(String parkingModules) {
        this.parkingModules = parkingModules;
    }

    public int getTotalSpaces() {
        return totalSpaces;
    }

    public void setTotalSpaces(int totalSpaces) {
        this.totalSpaces = totalSpaces;
    }

    @Override
    public String toString() {
        return "BikePlace{" +
                "objectID=" + objectID +
                ", address='" + address + '\'' +
                ", businessName='" + businessName + '\'' +
                ", parkingModules=" + parkingModules +
                ", totalSpaces=" + totalSpaces +
                '}';
    }
}
