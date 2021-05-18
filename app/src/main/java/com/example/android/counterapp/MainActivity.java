package com.example.android.counterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.counterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String COUNT_VALUE = "countValue";
    private int qty=0;
    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setupEventHandlers();

        if (savedInstanceState != null) {
            qty = savedInstanceState.getInt(COUNT_VALUE);
        } else {
            //Get data from sharedPreference
            qty = getPreferences(MODE_PRIVATE)
                    .getInt(COUNT_VALUE, 0);

        }
        b.qty.setText(qty + "");
    }



    private void setupEventHandlers() {
        b.incButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               incQty();
            }
        });
        b.decButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decQty();
            }
        });
    }


    public void decQty() {
        b.qty.setText(""+ --qty);
}

    public void incQty() {
        b.qty.setText(""+ ++qty);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT_VALUE, qty);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferences(MODE_PRIVATE).edit().putInt(COUNT_VALUE, qty).apply();
    }
}


