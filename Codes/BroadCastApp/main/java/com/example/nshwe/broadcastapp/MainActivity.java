package com.example.nshwe.broadcastapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MyReceiver receiver;
    IntentFilter filter;
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (Button) findViewById(R.id.click);

        receiver = new MyReceiver();
        filter = new IntentFilter("com.example.nshwe.broadcastapp.SOME_ACTION");
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.nshwe.broadcastapp.SOME_ACTION");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}