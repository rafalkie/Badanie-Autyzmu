package com.example.rafalkie.projekt;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rafalkie on 25.05.2017.
 */

public class Symbol  {
    public static final String TABLE_NAME="Symbol";
    public static final String ID="id_symbol";
    public static final String NAME="nazwa";


    private static String CREATE_TABLE_SYMBOL =
            " CREATE TABLE " + TABLE_NAME +"("
                    +ID+" INTEGER PRIMARY KEY,"
                    +NAME+" TEXT"
                    + ")";



    private static String DROP_TABLE_SYMBOL =
            "DROP TABLE IF EXISTS "+ TABLE_NAME;

    void addSymbol(String name,DbHelper dbHelper){

        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NAME,name);
        db.insert(TABLE_NAME,null,cv);



    }
    void dodaj_dane(DbHelper dbHelpe){


        addSymbol("Tak-Nie", dbHelpe);
        addSymbol("Siedem poziomów odpowiedzi",dbHelpe);

//        addSymbol("Rodzaje wsparcia",dbHelpe);
//        addSymbol("Samodzielność Poziom 1", dbHelpe);
//        addSymbol("Umiejętność porozumiewania się Poziom 1",dbHelpe);
//        addSymbol("Umiejętność porozumiewania się Poziom 2",dbHelpe);
//        addSymbol("Kompetencje społeczne",dbHelpe);
    }

    //Getery Settery
    public static  String getDropTableSymbol() {
        return DROP_TABLE_SYMBOL;
    }
    public static String getCreateTableSymbol() {
        return CREATE_TABLE_SYMBOL;
    }
}
