package com.example.rafalkie.projekt;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rafalkie on 25.05.2017.
 */

public class administrator {

    public static final String TABLE_NAME="Administrator";
    public static final String ID="id_administrator";
    public static final String LOGIN="login";
    public static final String HASLO="haslo";
    public static final String ID_UZYTKOWNIK="id_uzytkownik";

    private static String CREATE_TABLE_ADMINISTRATOR =
            " CREATE TABLE "+ TABLE_NAME +"("
                    +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +LOGIN+" TEXT, " +HASLO+" TEXT, "+
                    administrator.ID_UZYTKOWNIK+" INTEGER,FOREIGN KEY ("+administrator.ID_UZYTKOWNIK+") REFERENCES " +Uzytkownik.TABLE_NAME + " ("+Uzytkownik.ID+")"+
                    ")";



    private static String DROP_TABLE_ADMINISTRATOR =
            "DROP TABLE IF EXISTS "+ TABLE_NAME;

    void addAdministrator(String login,String haslo,int id_uzytkownik,DbHelper dbHelper){

        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(LOGIN,login);
        cv.put(HASLO,haslo);
        cv.put(ID_UZYTKOWNIK,id_uzytkownik);
        db.insert(TABLE_NAME,null,cv);



    }

    //Getery Settery
    public static  String getDropTableAdministrator() {
        return DROP_TABLE_ADMINISTRATOR;
    }
    public static String getCreateTableAdministrator() {
        return CREATE_TABLE_ADMINISTRATOR;
    }
}
