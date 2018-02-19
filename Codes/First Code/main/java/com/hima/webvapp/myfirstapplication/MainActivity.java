package com.hima.webvapp.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //display("Activity Created");

        button = findViewById(R.id.button);
        editText = findViewById(R.id.edit);

        button.setOnClickListener(this);
    }


//    private void display(String msg) {
//        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,editText.getText(),Toast.LENGTH_SHORT).show();
    }
}
