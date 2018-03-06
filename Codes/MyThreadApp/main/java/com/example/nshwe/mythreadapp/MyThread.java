package com.example.nshwe.mythreadapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nshwe on 01-03-2018.
 */

public class MyThread extends AsyncTask {

    Context context;
    TextView textView;
    public MyThread(Context context, TextView textView) {
        this.context = context;
        this.textView = textView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textView.setText("Before doInBackGround...");
        Toast.makeText(context,"Before doInBackGround...",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        textView.setText("After doInBackGround...");
        Toast.makeText(context,"After doInBackGround...",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        textView.setText(values[0]+"");
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        Log.d("MyThread",Thread.currentThread().getName());
        for(int i = 1; i <=10; i++){
            try {
                Thread.sleep(1000);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
