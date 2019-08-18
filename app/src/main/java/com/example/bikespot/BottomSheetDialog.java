package com.example.bikespot;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bikespot.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialog extends BottomSheetDialogFragment {
        private BikePlace bikePlace;
        private TextView bottomSheetText;


        public BottomSheetDialog(BikePlace bikePlace) {
            super();
            this.bikePlace = bikePlace;
            bottomSheetText = getActivity().findViewById(R.id.textView_bottomSheet);
            formatText();
        }

        private void formatText() {
            if (bottomSheetText != null) {
                String text = "\t" + bikePlace.getBusinessName()
                        + "\nAddress: " + bikePlace.getAddress()
                        + "\n\nOpen Spaces: " + bikePlace.getOpenSpaces()
                        + "\nTotal Spaces:" + bikePlace.getTotalSpaces();
                bottomSheetText.setText(text);
            } else {
                Log.e("NULL POINTER", "Cannot find id textView_bottomSheet in BottomSheetDialog class");
            }
        }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);
        return v;
    }
}
