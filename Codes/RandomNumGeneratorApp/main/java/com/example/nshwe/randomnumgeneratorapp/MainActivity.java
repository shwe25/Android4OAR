package com.example.nshwe.randomnumgeneratorapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean bound;
    private MyNumberService myNumberService;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyNumberService.NumberBinder binder = (MyNumberService.NumberBinder) service;
            myNumberService = binder.getMyNumberService();
            bound = true;
            displayNumber();
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            bound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,MyNumberService.class);
        bindService(intent,connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
        bound = false;
    }

    private void displayNumber(){
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(bound){
                    textView.setText(myNumberService.generateNumbers().toString());
                    handler.postDelayed(this,1000);
                }
            }
        });
    }
}
