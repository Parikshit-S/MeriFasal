package com.example.android.merifasal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainSellerActivity extends AppCompatActivity {
    
    private TextView nameTv, shopNameTv, emailTv, tabProductsTv, tabOrdersTv;
    private ImageButton logoutBtn, editProfileBtn, addProductBtn;
    private ImageView profileIv;
    
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    private RelativeLayout productRl, orderRl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_seller);
        
        nameTv = findViewById(R.id.nameTv);
        shopNameTv = findViewById(R.id.shopNameTv);
        emailTv = findViewById(R.id.emailTv);
        tabProductsTv = findViewById(R.id.tabProductsTv);
        tabOrdersTv = findViewById(R.id.tabOrdersTv);
        logoutBtn = findViewById(R.id.logoutBtn);
        editProfileBtn = findViewById(R.id.editProfileBtn);
        addProductBtn = findViewById(R.id.addProductBtn);
        profileIv = findViewById(R.id.profileIv);
        productRl = findViewById(R.id.productRl);
        orderRl = findViewById(R.id.orderRl);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();

        showProductUI();

        addProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open edit add product activity
                startActivity(new Intent(MainSellerActivity.this, AddProductActivity.class));
            }
        });
        tabProductsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductUI();
            }
        });
        tabOrdersTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOrderUI();
            }
        });
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainSellerActivity.this, LoginActivity.class));
            }
        });
    }

    private void showProductUI() {
        productRl.setVisibility(View.VISIBLE);
        orderRl.setVisibility(View.GONE);

        tabProductsTv.setTextColor(getResources().getColor(R.color.black));
        tabProductsTv.setBackgroundResource(R.drawable.shape_rect04);

        tabOrdersTv.setTextColor(getResources().getColor(R.color.white));
        tabOrdersTv.setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }

    private void showOrderUI() {
        productRl.setVisibility(View.GONE);
        orderRl.setVisibility(View.VISIBLE);

        tabProductsTv.setTextColor(getResources().getColor(R.color.white));
        tabProductsTv.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        tabOrdersTv.setTextColor(getResources().getColor(R.color.black));
        tabOrdersTv.setBackgroundColor(R.drawable.shape_rect04);
    }


    private void checkUser() {
    }
}