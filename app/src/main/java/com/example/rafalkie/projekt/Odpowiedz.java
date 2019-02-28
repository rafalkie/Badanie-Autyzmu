package com.example.rafalkie.projekt;

import android.content.ContentValues;

import android.database.sqlite.SQLiteDatabase;


/**
 * Created by rafalkie on 25.05.2017.
 */

public class Odpowiedz  {

    public  static final String TABLE_NAME="Odpowiedz";
    public static final String ID="id_odpowiedz";
    public  static final String NAME="nazwa";
    public  static final String ID_Symbol="id_symbol";





    private static String CREATE_TABLE_ODPOWIEDZ =
            " CREATE TABLE " + TABLE_NAME +"("
                    +ID+" INTEGER PRIMARY KEY,"
                    +NAME+" TEXT,"+
                    Odpowiedz.ID_Symbol+" INTEGER,FOREIGN KEY ("+Odpowiedz.ID_Symbol+") REFERENCES " +Symbol.TABLE_NAME + " ("+Symbol.ID+")"+
                    ")";



    private static String DROP_TABLE_ODPOWIEDZ=
            "DROP TABLE IF EXISTS "+ TABLE_NAME;

      void addOdpowiedz(String name,int symbol, DbHelper dbHelper){

        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NAME,name);
          cv.put(ID_Symbol,symbol);
        db.insert(TABLE_NAME,null,cv);



    }
    void dodaj_dane(DbHelper dbHelpe){

            addOdpowiedz("TAK", 1, dbHelpe);
            addOdpowiedz("NIE", 1, dbHelpe);
            addOdpowiedz("Nie potrafi", 2, dbHelpe);
            addOdpowiedz("Bardzo słabo", 2, dbHelpe);
            addOdpowiedz("Słabo", 2, dbHelpe);
            addOdpowiedz("Połowicznie", 2, dbHelpe);
            addOdpowiedz("Samodzielnie", 2, dbHelpe);
            addOdpowiedz("Bardzo dobrze ", 2, dbHelpe);
            addOdpowiedz("Ponadprzeciętnie", 2, dbHelpe);

    }





  //Getery Settery
    public static  String getDropTableOdpowiedz() {
        return DROP_TABLE_ODPOWIEDZ;
    }
    public static String getCreateTableOdpowiedz() {
        return CREATE_TABLE_ODPOWIEDZ;
    }
}
