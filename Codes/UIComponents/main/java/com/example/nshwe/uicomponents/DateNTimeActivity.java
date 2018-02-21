package com.example.nshwe.uicomponents;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateNTimeActivity extends AppCompatActivity {

    private EditText timeEt,dateEt;
    private Button timeBtn,dateBtn;
    private GregorianCalendar calendar = new GregorianCalendar();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_ntime);

        timeBtn = findViewById(R.id.time);
        dateBtn = findViewById(R.id.date);
        timeEt = findViewById(R.id.time_Et);
        dateEt = findViewById(R.id.date_Et);
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate();
            }
        });
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime();
            }
        });
    }

    private void setTime() {
        int hr = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timeEt.setText(hourOfDay+":"+minute);
            }
        },hr,min,false);
        timePickerDialog.show();
    }

    private void setDate() {
        Log.d("MyDebug","Executing");
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        Log.d("MyDebug",date+"/"+month+"/"+year);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d("MyDebug","Executing");
                dateEt.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        },year,month,date);
        datePickerDialog.show();
    }


}
