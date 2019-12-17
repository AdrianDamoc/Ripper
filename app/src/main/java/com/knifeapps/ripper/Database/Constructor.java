package com.knifeapps.ripper.Database;

import android.provider.BaseColumns;

public class Constructor {

    public Constructor() {
    }

    //definitie baza de date
    public static final String DATABASE_NAME = "BazadedateRipper";

    public static abstract class Tip {
        public static final String INTREG = " integer not null default 0 ";
        public static final String DOUBLE = " double not null default 0 ";
        public static final String PRIMARY = " integer primary key ";
        public static final String PRIMARY_AUTO = " integer primary key autoincrement ";
        public static final String TEXT = " text not null default \'\' ";
        public static final String DATA = " date not null default current_date";
        public static final String VALOARE = " numeric not null default 0.000000 ";
        public static final String TIMESTAMP = " TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ";
        public static final String ACTIV = " integer not null default 1";// unde 1 este activ
        public static final String GPS = " [double latitude, double longitude] ";
        public static final String COD_BARE = "  text not null default \'\' ";
    }



    // TABELA iteme
    public static final class Iteme implements BaseColumns {
        public static final String NUME_TABEL = "ITEME";
        public static final String COL_ID_ITEM = "id_item";
        public static final String COL_DENUMIRE = "denumire";
        public static final String COL_DATA = "data";
    }

    //sql creare tabel
    public static final String SQL_CREAZA_TABEL_ITEME= (" create table if not exists " +
            Iteme.NUME_TABEL + " ( " +
            Iteme.COL_ID_ITEM + Tip.PRIMARY_AUTO + " , " +
            Iteme.COL_DENUMIRE+ Tip.TEXT + " , "+
            Iteme.COL_DATA + Tip.TEXT
            + ")");


// TABELA POZITII TRIMITERI

    public static final class Tabela_Pozitii_Trimiteri implements BaseColumns {
        public static final String NUME_TABEL = "tabela_pozitii_trimiteri";
        public static final String COL_ID_ANTET_TRIMITERI = "id_antet_trimiteri";
        public static final String COL_ID_TIP = "id_tip";
        public static final String COL_ID_P_LUCRU = "id_p_lucru";
    }

    //sql creare tabel
    public static final String SQL_CREAZA_TABEL_POZITII_TRIMITERI = (" create table if not exists " +
            Tabela_Pozitii_Trimiteri.NUME_TABEL + " ( " +
            Tabela_Pozitii_Trimiteri.COL_ID_ANTET_TRIMITERI + Tip.INTREG + " , " +
            Tabela_Pozitii_Trimiteri.COL_ID_TIP + Tip.INTREG + " , " +
            Tabela_Pozitii_Trimiteri.COL_ID_P_LUCRU + Tip.INTREG
            + ")");


    // TABELA INCARCARI-DESCARCARI
    public static final class Tabela_Incarc_Descarc implements BaseColumns {
        public static final String NUME_TABEL = "tabela_incarc_descarc";
        public static final String COL_ID_INCARC_DESCARC = "id_incarc_descarc";
        public static final String COL_ID_ANTET_TRIMITERI = "id_antet_trimiteri";
        public static final String COL_ID_UTILIZATOR = "id_utilizator";
        public static final String COL_ID_TIP = "id_tip";// (3 incarcare, 4 descarcare)
        public static final String COL_ID_P_LUCRU = "id_p_lucru";
        public static final String COL_DATA = "data";
    }

    //sql creare tabel
    public static final String SQL_CREAZA_TABEL_INCARC_DESCARC = (" create table if not exists " +
            Tabela_Incarc_Descarc.NUME_TABEL + " ( " +
            Tabela_Incarc_Descarc.COL_ID_INCARC_DESCARC + Tip.PRIMARY_AUTO + " , " +
            Tabela_Incarc_Descarc.COL_ID_ANTET_TRIMITERI + Tip.INTREG + " , " +
            Tabela_Incarc_Descarc.COL_ID_UTILIZATOR + Tip.INTREG + " , " +
            Tabela_Incarc_Descarc.COL_ID_TIP + Tip.INTREG + " , " +
            Tabela_Incarc_Descarc.COL_ID_P_LUCRU + Tip.INTREG + " , " +
            Tabela_Incarc_Descarc.COL_DATA + Tip.TEXT
            + ")");


    // TABELA PACHETE
    public static final class Tabela_Pachete implements BaseColumns {
        public static final String NUME_TABEL = "tabela_pachete";
        public static final String COL_ID_TRIMITERI_VECHI = "id_antet_trimiteri_vechi";
        public static final String COL_ID_TRIMITERI_NOU = "id_antet_trimiteri_nou";
    }

    //sql creare tabel
    public static final String SQL_CREAZA_TABEL_PACHETE = (" create table if not exists " +
            Tabela_Pachete.NUME_TABEL + " ( " +
            Tabela_Pachete.COL_ID_TRIMITERI_VECHI + Tip.INTREG + " , " +
            Tabela_Pachete.COL_ID_TRIMITERI_NOU + Tip.INTREG
            + ")");

    // TABELA TIPURI PENTRU OPERATII        (am numit tabela tipuri pentru a nu fi confundata cu clasa Tip
    public static final class Tabela_Tipuri implements BaseColumns {
        public static final String NUME_TABEL = "tabela_tipuri";
        public static final String COL_ID_TIPURI = "id_tipuri";
        public static final String COL_DENUMIRE = "denumire";
    }

    //sql creare tabel
    public static final String SQL_CREAZA_TABEL_TIPURI = (" create table if not exists " +
            Tabela_Tipuri.NUME_TABEL + " ( " +
            Tabela_Tipuri.COL_ID_TIPURI + Tip.INTREG + " , " +
            Tabela_Tipuri.COL_DENUMIRE + Tip.TEXT
            + ")");


}