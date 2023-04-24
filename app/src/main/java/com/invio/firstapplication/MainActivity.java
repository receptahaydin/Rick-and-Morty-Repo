package com.invio.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Handler h = new Handler();
    private TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMessage = (TextView) findViewById(R.id.textMessage);
        checkEntrance(txtMessage);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, NextActivity.class);
                startActivity(i);
                finish();
            }
        }, 5000);
    }

    public void checkEntrance(TextView txt) {
        SharedPreferences prefs = getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
        int count = prefs.getInt("count", 0);
        if (count == 0){
            txt.setText("Welcome!");
        } else {
            txt.setText("Hello!");
        }
        count++;
        prefs.edit().putInt("count", count).apply();
    }
}