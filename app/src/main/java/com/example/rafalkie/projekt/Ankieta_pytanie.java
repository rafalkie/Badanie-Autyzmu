package com.example.rafalkie.projekt;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rafalkie on 25.05.2017.
 */

public class Ankieta_pytanie  {
    public static final String TABLE_NAME="Ankieta_pytanie";
    public static final String ID="id_ankieta_pytanie";
    public static final String ID_ODPOWIEDZ="id_odpowiedz";
    public static final String ID_PYTANIE="id_pytanie";
    public static final String ID_UZYTKOWNIK="id_uzytkownik";



    private static String CREATE_TABLE_ANKIETA_PYTANIE =
            " CREATE TABLE "+ TABLE_NAME +"("
                    +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +
                    Ankieta_pytanie.ID_UZYTKOWNIK+" INTEGER REFERENCES " +Uzytkownik.TABLE_NAME + " ("+Uzytkownik.ID+"),"
                    +ID_PYTANIE+" INTEGER REFERENCES " +Pytanie.TABLE_NAME + " ("+Pytanie.ID+"),"+
                    Ankieta_pytanie.ID_ODPOWIEDZ+" INTEGER,"+
                    "FOREIGN KEY ("+Ankieta_pytanie.ID_ODPOWIEDZ+") REFERENCES " +Odpowiedz.TABLE_NAME + " ("+Odpowiedz.ID+")"+
                    ")";



    private static String DROP_TABLE_ANKIETA_PYTANIE =
            "DROP TABLE IF EXISTS "+ TABLE_NAME;

    void addAnkieta_pytanie(int id_odpowiedz,int id_pytanie,int id_uzytkownik,DbHelper dbHelper){

        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(ID_ODPOWIEDZ,id_odpowiedz);
        cv.put(ID_PYTANIE,id_pytanie);
        cv.put(ID_UZYTKOWNIK,id_uzytkownik);

        db.insert(TABLE_NAME,null,cv);



    }

    //Getery Settery

    public static String getCreateTableAnkietaPytanie() {
        return CREATE_TABLE_ANKIETA_PYTANIE;
    }

    public static String getDropTableAnkietaPytanie() {
        return DROP_TABLE_ANKIETA_PYTANIE;
    }
}
