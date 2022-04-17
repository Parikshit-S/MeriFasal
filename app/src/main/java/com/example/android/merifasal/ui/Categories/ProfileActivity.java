package com.example.android.merifasal.ui.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.merifasal.LoginActivity;
import com.example.android.merifasal.R;
import com.example.android.merifasal.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();

        String email = user.getEmail();
        String username = user.getDisplayName();
        String number = user.getPhoneNumber();

        TextView welcomeText =  findViewById(R.id.welcomeText);
        welcomeText.setText("Email : " + email);

        TextView UserName = findViewById(R.id.userName);
        UserName.setText("UserName : " + username);

        TextView Phone = findViewById(R.id.pNumber);
        Phone.setText("Number : " + number);



        Button logoutButton =  findViewById(R.id.buttonLogout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}