package com.example.android.merifasal.ui.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android.merifasal.MainActivity;
import com.example.android.merifasal.R;
import com.example.android.merifasal.teamprofile.NameActivity1;
import com.example.android.merifasal.teamprofile.NameActivity2;
import com.example.android.merifasal.teamprofile.NameActivity3;
import com.example.android.merifasal.teamprofile.NameActivity4;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Button ProfileExpand = findViewById(R.id.btn_name1);
        Button Profile2 = findViewById(R.id.btn_name2);
        Button Profile3 = findViewById(R.id.btn_name3);
        Button Profile4 = findViewById(R.id.btn_name4);
        final ImageView btnBack = findViewById(R.id.back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutUsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ProfileExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutUsActivity.this, NameActivity1.class);
                startActivity(intent);
            }
        });

        Profile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutUsActivity.this, NameActivity2.class);
                startActivity(intent);
            }
        });

        Profile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutUsActivity.this, NameActivity3.class);
                startActivity(intent);
            }
        });

        Profile4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutUsActivity.this, NameActivity4.class);
                startActivity(intent);
            }
        });

    }
}