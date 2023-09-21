package com.suhun.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class StartStyleServiceActivity extends AppCompatActivity {
    private String tag = StartStyleServiceActivity.class.getSimpleName();
    private TextView resultCounter;
    private SeekBar counterSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_style_service);
        initView();
    }

    private void initView(){
        resultCounter = findViewById(R.id.lid_counterResult);
        counterSeekBar = findViewById(R.id.lid_counterSeekBar);
    }

    public void startStartStyleServiceFun(View view){
    }

    public void stopStartStyleServiceFun(View view){
    }

    public void finishStartStyleServiceFun(View view){
        finish();
    }
}