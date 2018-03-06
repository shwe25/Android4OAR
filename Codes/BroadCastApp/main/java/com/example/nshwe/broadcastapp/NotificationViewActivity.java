package com.example.nshwe.broadcastapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationViewActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_view);

        textView = (TextView) findViewById(R.id.text);

        textView.setText(getIntent().getCharSequenceExtra("msg"));
    }
}
