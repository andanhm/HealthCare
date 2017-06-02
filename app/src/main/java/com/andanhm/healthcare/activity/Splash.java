package com.andanhm.healthcare.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.andanhm.healthcare.R;

public class Splash extends AppCompatActivity {
    Activity mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mActivity=Splash.this;

        new Handler().postDelayed(new Runnable() {
            public void run() {
               startActivity(new Intent(mActivity,Main.class));
            }
        },1000);
    }

}
