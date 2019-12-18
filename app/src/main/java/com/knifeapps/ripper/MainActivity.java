package com.knifeapps.ripper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.knifeapps.ripper.Database.Constructor;
import com.knifeapps.ripper.Database.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    EditText Denumire;
    TextView DataSelectata;
    CalendarView Calendar;
    Button BTNSave, BTNNext;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        Denumire = findViewById(R.id.spinner_denumire);
        Calendar = findViewById(R.id.calendar_id);
        DataSelectata = findViewById(R.id.data_id);
        BTNSave = findViewById(R.id.btnsave);
        BTNNext = findViewById(R.id.btnnext);
        long dataora = Calendar.getDate();
        BTNNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activitate2.class);
                startActivity(intent);
            }
        });




        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        final String selectedDate = sdf.format(new Date(Calendar.getDate()));

        Calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                String d = dayOfMonth+"/"+month+"/"+year;
              DataSelectata.setText(d);
            }
        });



        BTNSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues cval = new ContentValues();
                SQLiteDatabase db = myDb.getWritableDatabase();
                db.beginTransaction();
                if(Denumire.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Esti bou, scrie itemu", Toast.LENGTH_SHORT).show();
                }else
                cval.put(Constructor.Iteme.COL_DENUMIRE, Denumire.getText().toString());
                if(DataSelectata.getText().toString().contains("DATA")){
                    Toast.makeText(MainActivity.this, "Esti bou, alege data", Toast.LENGTH_SHORT).show();
                }else
                cval.put(Constructor.Iteme.COL_DATA,DataSelectata.getText().toString());
                db.insert(Constructor.Iteme.NUME_TABEL, null, cval);
                Denumire.getText().clear();
                db.setTransactionSuccessful();
                db.endTransaction();
            }
        });
    }

}

