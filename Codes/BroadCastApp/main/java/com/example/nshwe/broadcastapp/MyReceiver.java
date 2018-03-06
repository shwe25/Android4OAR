package com.example.nshwe.broadcastapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,intent.getAction(),Toast.LENGTH_LONG).show();
        Log.d("Recieved",intent.getAction());
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("My Notification")
                .setAutoCancel(true)
                .setContentText("Mode Changed");

        Intent nIntent = new Intent(context,NotificationViewActivity.class);
        nIntent.putExtra("msg","My Notification");
        PendingIntent pendingIntent = PendingIntent.getActivity
                (context,0,nIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService
                (Context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());

    }
}
