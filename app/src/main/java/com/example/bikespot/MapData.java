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
import java.util.Random;
import java.util.concurrent.Callable;

public class MapData {

    private ArrayList<BikePlace> bikePlaces = new ArrayList();

    public MapData() {
        bikePlaces = new ArrayList();
    }

    public MapData(ArrayList<BikePlace> bikePlaces) {
        this.bikePlaces = bikePlaces;
    }

    public ArrayList<BikePlace> getBikePlaces() throws IOException, JSONException {


        // Loops through JSONArray of each Bike Place from CStat Data
        // and assigns attributes dissected from data to new BikePlace objects
        // to be put in ArrayList of BikePlaces


        JSONArray bikePlaceDataArray = getBikeRackJSONArray();

        for (int i = 0; i < bikePlaceDataArray.length(); i++) {
            JSONArray tempBikePlace = (JSONArray) bikePlaceDataArray.get(i);

            int objectID = (int) tempBikePlace.get(0);
            String address = (String) tempBikePlace.get(9);
            String business = (String) tempBikePlace.get(10);
            String parkingModules;
            String totalSpotsString;
            int totalSpots;

            // issues with data holes for racks and spaces solved by if
            // TODO: change so that both aren't affected for single info hole
            if (!tempBikePlace.get(11).toString().equals("null") && !tempBikePlace.get(12).toString().equals("null")) {
                parkingModules = (String) tempBikePlace.get(11);
                totalSpotsString = (String) tempBikePlace.get(12);
                totalSpots = Integer.parseInt(totalSpotsString);
            } else {
                parkingModules = "DATA NOT AVAILABLE";
                totalSpotsString = "-1";
                totalSpots = Integer.parseInt(totalSpotsString);
            }

            Random random = new Random();

            int openSpots;
            if(totalSpots != -1) {
                openSpots = random.nextInt(totalSpots - 2 + 1) + 2;
            } else {
                openSpots = -1;
            }

            JSONArray coordPackage = tempBikePlace.getJSONArray(14);
            double latitude = Double.parseDouble((String) coordPackage.get(1));
            double longitude = Double.parseDouble((String) coordPackage.get(2));

            //            System.out.println("Object ID: " + objectID);
            //            System.out.println("Address: " + address);
            //            System.out.println("Business: " + business);
            //            System.out.println("Parking Modules: " + parkingModules);
            //            System.out.println("Total Spots: " + totalSpots);
            //            System.out.println("Latitude: " + latitude);
            //            System.out.println("Longitude: " + longitude;
            //            System.out.println("----------------------------- \n\n");

            BikePlace bikePlace = new BikePlace(objectID, address, business, parkingModules, totalSpots, openSpots, latitude, longitude);
            System.out.println(bikePlace.toString());
            System.out.println("----------------------------- \n\n");
            bikePlaces.add(bikePlace);

        }
            return bikePlaces;
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
