package com.example.nshwe.uicomponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

       /* button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),editText.getText(),Toast.LENGTH_SHORT).show();
            }
        });*/
    }
    public void click(View view){

        editText.setText(getIntent().getCharSequenceExtra("country"));
        Toast.makeText(getBaseContext(),editText.getText(),Toast.LENGTH_SHORT).show();
    }
}
