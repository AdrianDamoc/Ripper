package com.knifeapps.ripper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;

import com.knifeapps.ripper.Database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView Denumire;
    CalendarView Calendar;
    Button BTNSave,BTNNext;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        Denumire = findViewById(R.id.spinner_denumire);
        Calendar = findViewById(R.id.calendar_id);
        BTNSave = findViewById(R.id.btnsave);
        BTNNext = findViewById(R.id.btnnext);

        BTNNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Activitate2.class);
                startActivity(intent);
            }
        });

    }
}
