package com.example.nshwe.mythreadapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ThreadActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        textView = findViewById(R.id.text);

        MyThread myThread = new MyThread(this,textView);
        myThread.execute();

        Log.d("ThreadActivity",Thread.currentThread().getName());

        //createThread();
    }

    /*private void createThread() {

        Thread thread = new Thread(() -> {
            for(int i = 1; i <=10; i++){
                try {
                    Thread.sleep(1000);
                    Log.d("MyThread",i+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }*/
}
