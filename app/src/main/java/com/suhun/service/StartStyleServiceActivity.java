package com.suhun.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class StartStyleServiceActivity extends AppCompatActivity {
    private String tag = StartStyleServiceActivity.class.getSimpleName();
    private TextView resultCounter;
    private SeekBar counterSeekBar;
    private MyReceiver myReceiver;

    private class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int counterValue = intent.getIntExtra("counterValue", -1);
            if(counterValue > -1){
                resultCounter.setText(""+counterValue);
            }
        }
    }

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

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("suhun");
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
    }

    public void startStartStyleServiceFun(View view){
        Intent intent = new Intent(this, MyStartService.class);
        startService(intent);
    }

    public void stopStartStyleServiceFun(View view){
        Intent intent = new Intent(this, MyStartService.class);
        stopService(intent);
    }

    public void finishStartStyleServiceFun(View view){
        finish();
    }
}