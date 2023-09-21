package com.suhun.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class BindStyleServiceActivity extends AppCompatActivity {
    private String tag = BindStyleServiceActivity.class.getSimpleName();
    private MyBindService mService;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBindService.LocalBinder binder = (MyBindService.LocalBinder)service;
            mService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_style_service);
    }

    public void startBindServiceFun(View view){
        Intent intent = new Intent(this, MyBindService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void stopBindServiceFun(View view){
        unbindService(serviceConnection);
    }

    public void getNameFun(View view){
        mService.getName();
    }

    public void finishBindFun(View view){
        finish();
    }
}