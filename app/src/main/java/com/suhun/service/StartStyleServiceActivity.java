package com.suhun.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartStyleServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_style_service);
    }

    public void startStartStyleServiceFun(View view){
    }

    public void stopStartStyleServiceFun(View view){
    }

    public void finishStartStyleServiceFun(View view){
        finish();
    }
}