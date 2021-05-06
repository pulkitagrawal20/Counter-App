package com.example.android.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.counterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private int qty=0;
    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setupEventHandlers();
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
}
