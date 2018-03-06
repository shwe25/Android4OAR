package com.example.nshwe.msgserviceapp;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import android.os.Handler;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;


public class MyMsgService extends IntentService {
    Handler handler;
    public static final String MSG = "Message";
    public MyMsgService() {
        super("MyMsgService");
    }
    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        handler = new Handler();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        synchronized (this){
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String text = intent.getStringExtra(MSG);
        showText(text);
        generateNotification(text);
    }

    private void generateNotification(String text) {
        Intent intent = new Intent(this,NotificationActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent
                (0,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification builder = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(text)
                .setContentText("My Msg Generator")
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(5453,builder);
    }

    private void showText(final String text) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.d("My_Msg","Displayed time");
                Toast.makeText(MyMsgService.this,text,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MsgService","Destroyed");
    }
}
