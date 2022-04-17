package com.example.android.merifasal.content;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.android.merifasal.FilterActivity;
import com.example.android.merifasal.MainActivity;
import com.example.android.merifasal.R;

import java.util.ArrayList;
import java.util.List;

public class ContentActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    private static String JSON_URL = "https://parikshit-s.github.io/jsonapi/xmltojson.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);


        final ImageView gpsButton = findViewById(R.id.gpsBtn);
        final ImageView backButton = findViewById(R.id.backBtn);

        gpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ContentActivity.this, "Finding Best Rates Near Your City... ", Toast.LENGTH_LONG).show();
                startActivity(new Intent(ContentActivity.this, FilterActivity.class));
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContentActivity.this, MainActivity.class));
            }
        });
    }
    }