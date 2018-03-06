package com.example.nshwe.uicomponents;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioNCheckBoxActivity extends AppCompatActivity {

    RadioGroup group;
    RadioButton radioButton;
    CheckBox java,j2ee,andorid,web,sql;
    Button imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_checkbox);

        java = findViewById(R.id.java);
        j2ee = findViewById(R.id.j2ee);
        andorid = findViewById(R.id.andorid);
        web = findViewById(R.id.web);
        sql = findViewById(R.id.sql);
        imageButton = findViewById(R.id.imageBtn);
        group = findViewById(R.id.group);

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
        radioButton = findViewById(group.getCheckedRadioButtonId());
        if(radioButton != null) {
            if (radioButton.getText().equals(getResources().getString(R.string.toast)))
                disp_Toast("Fee Details\n" + builder.toString() + "\nTotal = " + total_fee);
            else
                disp_Alert(builder.toString() + "\nTotal = " + total_fee);
        }else
            disp_Toast("Choose Something to display");
    }

    private void disp_Toast(String details){
        Toast.makeText(this,details,Toast.LENGTH_LONG).show();
    }

    private void disp_Alert(String details){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Fee Structure")
                .setMessage(details)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                RadioNCheckBoxActivity.this.finish();
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
