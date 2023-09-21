package com.suhun.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MyStartService extends Service {
    private String tag = MyStartService.class.getSimpleName();
    private Timer timer;
    private int counter, maxCounter;

    private class MyTask extends TimerTask{
        @Override
        public void run() {
            if(counter < maxCounter){
                counter++;
                Log.d(tag, "-----+"+counter+"-----");
                Intent intent = new Intent("suhun");
                intent.putExtra("counterValue", counter);
                sendBroadcast(intent);
            }
        }
    }
    public MyStartService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}