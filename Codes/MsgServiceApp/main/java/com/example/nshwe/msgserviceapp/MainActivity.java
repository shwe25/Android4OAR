package com.example.nshwe.msgserviceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = (Button) findViewById(R.id.msg);

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button","Clicked");
                Intent intent = new Intent
                        (MainActivity.this,MyMsgService.class);
                intent.putExtra(MyMsgService.MSG,"My Message");
                startService(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","Destroyed");
    }
}
