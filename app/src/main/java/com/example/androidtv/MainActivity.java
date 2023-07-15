package com.example.androidtv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.material.navigation.NavigationView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private  TextView textClock;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textClock = findViewById(R.id.clock);

        Handler handler= new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Date date= new Date();
                @SuppressLint("SimpleDateFormat")
                DateFormat clockFormat = new SimpleDateFormat("HH:mm");

                textClock.setText(clockFormat.format(date));
                handler.postDelayed(this, 1000);
            }
        });

        VideoView videoView = findViewById(R.id.video);
        String videoPath = "android.resource://"+getPackageName()+"/"+R.raw.videoupb;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();


        ImageView btnfai = findViewById(R.id.btn_fai);
        btnfai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FaiActivity.class);
                startActivity(intent);
            }
        });

        ImageView btnfeb = findViewById(R.id.btn_feb);
        btnfeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FebActivity.class);
                startActivity(intent);
            }
        });

        ImageView btnfiphum = findViewById(R.id.btn_fiphum);
        btnfiphum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FiphumActivity.class);
                startActivity(intent);
            }
        });

        ImageView btnfatek = findViewById(R.id.btn_fatek);
        btnfatek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FatekActivity.class);
                startActivity(intent);
            }
        });

    }
}