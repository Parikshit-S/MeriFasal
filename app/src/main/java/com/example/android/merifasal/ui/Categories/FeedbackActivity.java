package com.example.android.merifasal.ui.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.merifasal.MainActivity;
import com.example.android.merifasal.R;

public class FeedbackActivity extends AppCompatActivity {

    TextView tvFeedback;
    RatingBar tbStars;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        final ImageView goBack = findViewById(R.id.back);

        btnSend = findViewById(R.id.btn_send);
        tvFeedback = findViewById(R.id.tvFeedback);
        tbStars = findViewById(R.id.ratingBar);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FeedbackActivity.this,"Your Feedback Recieved Successfully",Toast.LENGTH_SHORT).show();
            }
        });

        tbStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating==0){
                    tvFeedback.setText("Very Poor");
                }
                else if (rating==1){
                    tvFeedback.setText("Poor");
                }
                else if(rating==2 || rating==3){
                    tvFeedback.setText("OK");
                }
                else if(rating==4){
                    tvFeedback.setText("Good");
                }
                else if(rating==5){
                    tvFeedback.setText("Excellent");
                }
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FeedbackActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}