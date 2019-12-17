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

    public final static int VERSIUNE_BAZA_DE_DATE =1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, Constructor.DATABASE_NAME, null, VERSIUNE_BAZA_DE_DATE);
        Log.e("Baza de date", "Baza de date " + getDatabaseName() + " a fost creata");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constructor.SQL_CREAZA_TABEL_ITEME);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + Constructor.Iteme.NUME_TABEL);


        onCreate(db);

    }





    // pentru insert o sa folosesc insertWithOnConflict care face insert numai daca valoarea pentru cheia unica
    // data in contentvalue nu mai exista. De ex daca am campul _id in tabela si este cheie unica iar in tabela
    // exista inreg care are _id=6 atunci o incercare de a face insert  cu content in care am pus
    // cVal.put("_id",6 ) cVal.put ( .... alte campuri cu valori ....) va da eroare daca folosesc insert simplu.
    // Daca folosesc insertWithOnConflict atunci , prin ultimul parametru din lista de parametri de apel, pot
    // controla ce sa se intample. Eu am folosit CONFLICT_IGNORE astfel incat daca nu exita inreg cu aceeasi cheie
    // sa se faca insert , daca nu sa se ignore si sa nu dea eroare. Mai exista si alte posibilitati pe care
    // le puteti gasi in documentatie
    // pentru a apela mai eficient inserWithOnConflict ( ma scuteste de a mai pune de fiecare data null si CONFLICT_IGNORE
    // intoarce si o valoare contentvalue goala ca sa nu mai scriu cVal.clear dupa fiecare insert
    public ContentValues insertOnConflictIgnore (SQLiteDatabase db, String sTabela,ContentValues cVal) {
        db.insertWithOnConflict(sTabela,null,cVal,SQLiteDatabase.CONFLICT_IGNORE);
        cVal.clear();
        return cVal;
    }

    // extrage o valoare din tabela de la o coloana pe baza unui filtru ( se creeaza un sir sql si se apeleaza
    // varianta cu instr sql de mai jos)
    public String detValoareDinQuery(SQLiteDatabase db,String sColoana,String sTabela,String sWhere) {
        return detValoareDinQuery(db,sColoana,"SELECT "+sColoana+" FROM "+sTabela+" WHERE "+sWhere);
    }
    // extrage o valoare din tabela de la o coloana pe baza unei instr sql
    public String detValoareDinQuery(SQLiteDatabase db,String sColoana,String sCmd) {
        String sRez;
        try {
            Cursor crs = db.rawQuery(sCmd, null);
            crs.moveToFirst();
            sRez = crs.getString(crs.getColumnIndexOrThrow((sColoana)));
            crs.close();
        } catch (Exception e) {
            sRez = "";
        }
        return sRez;
    }

    }



