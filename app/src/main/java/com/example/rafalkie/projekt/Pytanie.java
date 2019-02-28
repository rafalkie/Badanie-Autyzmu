package com.example.rafalkie.projekt;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by rafalkie on 25.05.2017.
 */

public class Pytanie  {

    public static final String TABLE_NAME="Pytanie";
    public static final String ID="id_pytanie";
    public static final String NAME="nazwa";
    public static final String ID_Symbol="id_symbol";



    private static String CREATE_TABLE_PYTANIA =
            " CREATE TABLE "+ Pytanie.TABLE_NAME +"("
                    +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +NAME+" TEXT, "+
                    Pytanie.ID_Symbol+" INTEGER,FOREIGN KEY ("+Pytanie.ID_Symbol+") REFERENCES " +Symbol.TABLE_NAME + " ("+Symbol.ID+")"+
                    ")";



    private static String DROP_TABLE_PYTANIE =
            "DROP TABLE IF EXISTS"+ Pytanie.TABLE_NAME;


    void addPytanie(String name,int id_symbol,DbHelper dbHelper ){

        SQLiteDatabase db=dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(NAME,name);
        cv.put(ID_Symbol,id_symbol);

        long id=db.insert(TABLE_NAME,null,cv);

    }

     void dodaj_dane(DbHelper dbHelpe){

             addPytanie("Potrafi stopniowo odejść od wspomagania , podpowiedzi osoby wspomagającej ?", 1, dbHelpe);
             addPytanie("Zdecydowanie nie chce/odmawia wsparcia i podpowiedzi bo sam chce ,sam już potrafi wykonać daną czynność ?", 1, dbHelpe);
             addPytanie("Wykonując dane zadanie wymaga tylko sprawdzania końcowych rezultatów ? ", 1, dbHelpe);
             addPytanie("Tylko od czasu do czasu/ sporadycznie wymaga kontroli ?", 1, dbHelpe);
             addPytanie("Nie przejawia uzależnienia od wsparcia, podpowiedzi lub  pomocy ?", 1, dbHelpe);

             addPytanie("Samodzielne (i właściwe) korzystanie z toalety ?", 2, dbHelpe);
             addPytanie("Na polecenie „STOP!”/”DOŚĆ” lub podobne potrafi przerwać daną czynność ?", 2, dbHelpe);
             addPytanie("Posiada podstawowe nawyki higieniczne ?", 1, dbHelpe);
             addPytanie("Utrzymuje higienę podczas miesiączki ,potrafi golić się ?", 2, dbHelpe);
             addPytanie("Korzysta z łazienki ?", 2, dbHelpe);

             addPytanie("Rozumie podstawowe polecenia słowne i gesty, czy polecenia słowne podparte gestem ?", 1, dbHelpe);
             addPytanie("Odpowiada na pytania o aktualne samopoczucie: „lubię to”/”nie lubię tego”, „czuję się dobrze/źle” ?", 1, dbHelpe);
             addPytanie("Potrafi samodzielnie wskazywać (np. ręką, palcem wzrokiem), że chce daną rzecz ?", 2, dbHelpe);
             addPytanie("Wykonuje polecenia - z odroczeniem, odracza gratyfikację w czasie (np. chce mu się pić, ale wypije herbatę dopiero jak ostygnie) ?", 1, dbHelpe);
             addPytanie("Wykonuje instrukcje podane w formie wizualnej (np. w postaci zdjęć, rysunku, filmu instruktażowego) ?", 2, dbHelpe);

             addPytanie("Potrafi odmówić (za pomocą gestu lub słów, np. odepchnąć ręka od tego czego nie lubi, powiedzieć „Nie”, „Nie chcę”,  albo „Chcę czegoś innego”) ?", 2, dbHelpe);
             addPytanie("Potrafi poprosić o więcej (np. powie „Chcę więcej” lub pokaże to gestem) ?", 2, dbHelpe);
             addPytanie("Potrafi poczekać na coś (np. na polecenie „Potem”, „Jak wykonasz ,to to …”, „Poczekaj. Jak będzie twoja kolej.” ) ?", 2, dbHelpe);
             addPytanie("Potrafi poczekać przy kasie, zapłacić i włożyć zakupy do torby ?", 2, dbHelpe);
             addPytanie("Reaguje na komunikat „Koniec”/”Stop” (i np. kończy daną czynność, zajęcia czy aktywność) ?", 1, dbHelpe);

             addPytanie("Akceptuje nieobecność rodziców w domu, normalnie się bawiąc (może przez krótki czas okazywać niezadowolenie) ?", 1, dbHelpe);
             addPytanie("Okazuje pozytywne zachowania wobec członków własnej rodziny ?", 1, dbHelpe);
             addPytanie("Demonstruje właściwe zachowania wobec nieznanych osób ?", 1, dbHelpe);
             addPytanie("Brak trudnych zachowań (samouszkadzajacych, agresywnych i destrukcyjnych) ?", 1, dbHelpe);
             addPytanie("Brak autoagresji, agresji wobec innych oraz agresji obronnej (np. „oddawania” koledze, gdy zostanie przez niego zaatakowany) ?", 1, dbHelpe);

         }



    public static String getCreateTablePytania() {
        return CREATE_TABLE_PYTANIA;
    }

    public static String getDropTablePytanie() {
        return DROP_TABLE_PYTANIE;
    }











}
