package com.knifeapps.ripper.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public final static int VERSIUNE_BAZA_DE_DATE = 3;

    public DatabaseHelper(@Nullable Context context) {
        super(context, Constructor.DATABASE_NAME, null, VERSIUNE_BAZA_DE_DATE);
        Log.e("Baza de date", "Baza de date " + getDatabaseName() + " a fost creata");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constructor.SQL_CREAZA_TABEL_ITEME);

        Log.e("Baza de date", "Tabela " + Constructor.Iteme.NUME_TABEL + " a fost creata");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + Constructor.Iteme.NUME_TABEL);


        onCreate(db);

    }

    }



