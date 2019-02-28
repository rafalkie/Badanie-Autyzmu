package com.example.rafalkie.projekt;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rafalkie on 25.05.2017.
 */

public class Uzytkownik {
    public static final String TABLE_NAME="Uzytkownik";
    public static final String ID="id_uzytkownik";
    public static final String NAME="nazwa";


    private static String CREATE_TABLE_UZYTKOWNIK =
            " CREATE TABLE " + TABLE_NAME +"("
                    +ID+" INTEGER PRIMARY KEY,"
                    +NAME+" TEXT"
                    + ")";



    private static String DROP_TABLE_UZYTKOWNIK =
            "DROP TABLE IF EXISTS "+ TABLE_NAME;

    void addUzytkownik(String name,DbHelper dbHelper){

        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NAME,name);
        db.insert(TABLE_NAME,null,cv);



    }

    //Getery Settery
    public static  String getDropTableUzytkownik() {
        return DROP_TABLE_UZYTKOWNIK;
    }
    public static String getCreateTableUzytkownik() {
        return CREATE_TABLE_UZYTKOWNIK;
    }
}
