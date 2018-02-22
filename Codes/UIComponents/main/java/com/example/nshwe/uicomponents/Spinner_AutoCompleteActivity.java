package com.example.nshwe.uicomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class Spinner_AutoCompleteActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    String[] country,stream,common;
    private Spinner spinner;
    private AutoCompleteTextView completeTextView;
    private MultiAutoCompleteTextView multiAutoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_autocomplete);
        spinner = findViewById(R.id.spinner);
        country = getResources().getStringArray(R.array.country);
        stream = getResources().getStringArray(R.array.stream);
        common = getResources().getStringArray(R.array.common);
        completeTextView = findViewById(R.id.autoComplete);
        multiAutoCompleteTextView = findViewById(R.id.multiautoComplete);
        setEvent();
        setAutoCompleteEvent();
        setMultiAutoCompleteEvent();
    }

    private void setMultiAutoCompleteEvent() {
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,common);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setThreshold(1);
        multiAutoCompleteTextView.setTokenizer(new SpaceTokenizer());
    }

    private void setAutoCompleteEvent() {
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,stream);
        completeTextView.setAdapter(adapter);
        completeTextView.setThreshold(1);
    }
    private void setEvent() {
        adapter = new ArrayAdapter<String>
                (this,
                        android.R.layout.simple_spinner_dropdown_item,
                        country);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0)
                    onNothingSelected(parent);
                else
                    Toast.makeText(Spinner_AutoCompleteActivity.this,country[position],
                            Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Spinner_AutoCompleteActivity.this,"Select your Country",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
