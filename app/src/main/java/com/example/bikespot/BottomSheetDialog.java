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


        public BottomSheetDialog(BikePlace bikePlace, AppCompatActivity activity) {
            super();
            this.bikePlace = bikePlace;
        }

        private void formatText() {

            businessName.setText(bikePlace.getBusinessName());
            address.setText(bikePlace.getAddress());

        }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);
        businessName = v.findViewById(R.id.textView_businessName);
        address = v.findViewById(R.id.textView_address);
        formatText();
        return v;
    }
}
