package com.example.nshwe.randomnumgeneratorapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyNumberService extends Service {

    private Random random = new Random();
    private NumberBinder binder = new NumberBinder();

    public class NumberBinder extends Binder{
        MyNumberService getMyNumberService(){
            return MyNumberService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
    public Integer generateNumbers(){
        return random.nextInt(1000);
    }
}
