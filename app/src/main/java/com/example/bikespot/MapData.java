package com.example.bikespot;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MapData {

    private ArrayList<BikePlace> bikePlaces = new ArrayList();

    public MapData() {
        bikePlaces = new ArrayList();
    }

    public MapData(ArrayList<BikePlace> bikePlaces) {
        this.bikePlaces = bikePlaces;
    }

    public ArrayList<BikePlace> getBikePlaces() throws IOException, JSONException {


        JSONArray bikePlaceDataArray = getBikeRackJSONArray();
        return new ArrayList<BikePlace>();

    }

    public JSONArray getBikeRackJSONArray() throws IOException, JSONException {

        String url = "https://data.cstx.gov/api/views/uxpu-xbne/rows.json?accessType=DOWNLOAD";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        // add request headers (authorization, user agent)
        //con.setRequestProperty("Authorization", "Token "+ token);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Create JSON object for dissection by property
        System.out.println("\nFull JSON Response");
        System.out.println(response.toString() + "\n");
        JSONObject fullResponse = new JSONObject(response.toString());

        JSONArray bikeDataArray = fullResponse.getJSONArray("data");

        return bikeDataArray;
    }
}
