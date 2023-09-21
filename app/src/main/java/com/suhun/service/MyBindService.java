package com.suhun.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBindService extends Service {//2.只要MyBindService被繫結上被實體化
    private String tag = MyBindService.class.getSimpleName();
    public Binder mBinder = new LocalBinder();//3.mBinder就會被實體化，之後就可以透過mBinder裡面的內部方法getService()來取得外部類別的實體
    public boolean isBind;

    public class LocalBinder extends Binder{ //1.定義這個內部類別的作用在於回傳外部類別實體物件
        MyBindService getService(){
            return MyBindService.this;
        }
    }
    public MyBindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        isBind = true;
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        isBind = false;
        return super.onUnbind(intent);
    }

    public void getName(){
        Log.d(tag, "-----*****"+tag+"*****-----");
    }
}