package com.example.rafalkie.projekt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rafalkie on 25.05.2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="autyzm.db";
    public static final int DATABASE_VERSION=1;


    //konstruktor podejemy nazwe bazy danych i zmienna z wersje
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Pytanie.getCreateTablePytania());
        db.execSQL(Odpowiedz.getCreateTableOdpowiedz());
        db.execSQL(Symbol.getCreateTableSymbol());
        db.execSQL(Uzytkownik.getCreateTableUzytkownik());
        db.execSQL(administrator.getCreateTableAdministrator());
        db.execSQL(Ankieta_pytanie.getCreateTableAnkietaPytanie());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Pytanie.getDropTablePytanie());
        db.execSQL(Odpowiedz.getDropTableOdpowiedz());
        db.execSQL(Symbol.getDropTableSymbol());
        db.execSQL(Uzytkownik.getDropTableUzytkownik());
        db.execSQL(administrator.getDropTableAdministrator());
        db.execSQL(Ankieta_pytanie.getDropTableAnkietaPytanie());
        onCreate(db);

    }
}
