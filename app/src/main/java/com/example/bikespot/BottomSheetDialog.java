package com.example.bikespot;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    private BikePlace bikePlace;
    private TextView businessName;
    private TextView address;
    private TextView openSpots;
    private TextView totalSpots;
    private TextView parkingType;


    public BottomSheetDialog(BikePlace bikePlace, AppCompatActivity activity) {
        super();
        this.bikePlace = bikePlace;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);
        businessName = v.findViewById(R.id.textView_businessName);
        address = v.findViewById(R.id.textView_address);
        totalSpots = v.findViewById(R.id.textView_totalSpaces);
        openSpots = v.findViewById(R.id.textView_openSpaces);
        parkingType = v.findViewById(R.id.textView_parkingType);
        formatText();
        return v;
    }

    private void formatText() {

        businessName.setText(bikePlace.getBusinessName());
        address.setText(bikePlace.getAddress());
        totalSpots.setText("Total Spaces: " + bikePlace.getTotalSpaces());
        openSpots.setText("Open Spaces: " + bikePlace.getOpenSpaces());
        parkingType.setText("Parking Type: " + bikePlace.getParkingModules());

    }
}
