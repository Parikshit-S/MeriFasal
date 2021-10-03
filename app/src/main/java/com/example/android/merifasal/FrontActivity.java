package com.example.android.merifasal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FrontActivity extends AppCompatActivity {

    TextView txtHead,txtSub;
    RelativeLayout relativeLayout;
    Animation txtAnimation,layoutAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        txtAnimation = AnimationUtils.loadAnimation(FrontActivity.this,R.anim.fall_down);
        layoutAnimation = AnimationUtils.loadAnimation(FrontActivity.this,R.anim.bottom_to_top);

        txtHead = findViewById(R.id.txtHead);
        txtSub =  findViewById(R.id.txtSub);
        relativeLayout = findViewById(R.id.frontAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               relativeLayout.setVisibility(View.VISIBLE);
               relativeLayout.setAnimation(layoutAnimation);

               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       txtHead.setVisibility(View.VISIBLE);
                       txtSub.setVisibility(View.VISIBLE);

                       txtHead.setAnimation(txtAnimation);
                       txtSub.setAnimation(txtAnimation);
                   }
               },900);

            }
        },500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(FrontActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        },6000);
    }
}