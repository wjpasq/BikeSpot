package com.example.bikespot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_findBikeRack;
    private TextView text_welcome;
    private TextView text_testingGround;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_findBikeRack = (Button) findViewById(R.id.button_findBikeRack);
        text_welcome = (TextView) findViewById(R.id.textView_welcome);
        text_testingGround = (TextView) findViewById(R.id.textView_testingGround);

        button_findBikeRack.setOnClickListener(this);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // testing
                MapData m = new MapData();
                try {
                    text_testingGround.setText(m.getBikeRackJSONArray().toString());
                    ArrayList<BikePlace> poop = m.getBikePlaces();
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }


    @Override
    public void onClick(View view) {
        Intent mapIntent = new Intent(this, MapsActivity.class);
        startActivity(mapIntent);
    }


}
