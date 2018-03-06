package com.example.nshwe.uicomponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button,date,spinner,radio,browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.buttonactivity);
        date = findViewById(R.id.dateNtime);
        spinner = findViewById(R.id.spinnerAuto);
        radio = findViewById(R.id.radio);
        browser = findViewById(R.id.browser);

        setEvent();
    }

    private void setEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ButtonActivity.class);
                startActivity(intent);
            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DateNTimeActivity.class);
                startActivity(intent);
            }
        });
        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Spinner_AutoCompleteActivity.class);
                startActivity(intent);
            }
        });
        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RadioNCheckBoxActivity.class);
                startActivity(intent);
            }
        });
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BrowserActivity.class);
                startActivity(intent);
            }
        });

    }

}
