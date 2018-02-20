package com.example.nshwe.uicomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    CheckBox java,j2ee,andorid,web,sql;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        java = findViewById(R.id.java);
        j2ee = findViewById(R.id.j2ee);
        andorid = findViewById(R.id.andorid);
        web = findViewById(R.id.web);
        sql = findViewById(R.id.sql);
        imageButton = findViewById(R.id.imageBtn);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("My_Debug","OnClick()");
                click();
            }
        });
    }
    private void click(){
        Log.d("My_Debug","Click()");
        double total_fee = 0;
        StringBuilder builder = new StringBuilder("");
        if(java.isChecked()){
            builder.append("\nJava - "+getResources().getInteger(R.integer.javaf));
            total_fee += getResources().getInteger(R.integer.javaf);
        }if(j2ee.isChecked()){
            builder.append("\nJ2ee - "+getResources().getInteger(R.integer.j2eef));
            total_fee += getResources().getInteger(R.integer.j2eef);
        }if(andorid.isChecked()){
            builder.append("\nAndorid - "+getResources().getInteger(R.integer.androidf));
            total_fee += getResources().getInteger(R.integer.androidf);
        }if(web.isChecked()){
            builder.append("\nWeb - "+getResources().getInteger(R.integer.webf));
            total_fee += getResources().getInteger(R.integer.webf);
        }if(sql.isChecked()){
            builder.append("\nSQL - "+getResources().getInteger(R.integer.sqlf));
            total_fee += getResources().getInteger(R.integer.sqlf);
        }if(total_fee == 0){
            builder.append("Please choose any of the courses");
        }
        Toast.makeText(this,"Fee Details\n"+builder.toString()+"\nTotal = "+total_fee,Toast.LENGTH_LONG).show();
    }
}
