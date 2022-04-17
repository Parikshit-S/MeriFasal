package com.example.android.merifasal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginSellerActivity extends AppCompatActivity {

    TextView newSeller;
    Button login;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_seller);

        newSeller = findViewById(R.id.alreadyacc);
        login = findViewById(R.id.btn_login);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setCanceledOnTouchOutside(false);

        newSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginSellerActivity.this, RegisterSellerActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Please Wait");
                progressDialog.setTitle("Login Started");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                startActivity(new Intent(LoginSellerActivity.this, MainSellerActivity.class));
            }
        });
    }
}