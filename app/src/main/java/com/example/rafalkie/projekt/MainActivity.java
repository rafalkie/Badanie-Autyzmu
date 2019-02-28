package com.example.rafalkie.projekt;


import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.TextView;

import static java.lang.Integer.parseInt;


public class MainActivity extends AppCompatActivity {


    DbHelper dbHelper;


    int n;
    int a =-1;
    String symbol;
     int id_pytania;
     long id_uzytkownik;
    Ustawienia ust=new Ustawienia();

    int[] pytanie = new int[ust.getLiczba_pytan()];
    int[] odpowiedz = new int[ust.getLiczba_pytan()];



    int liczba_choroby =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


         dbHelper = new DbHelper(this);

        SprawdzDaneCzyWgrane();
        LogData();
        AddUzytkownik();

      Log.d("MainActivity2", "Punktów= " );

        ///wypełnianie tablicy
        for (int i = 0; i < ust.getLiczba_pytan(); i++)
            odpowiedz[i] = -1;

    }




    private void LogData(){
        Odpowiedz odpowiedz =new Odpowiedz();
        TextView pytanie=(TextView) findViewById(R.id.pytanie);
        TextView nr_pyt=(TextView) findViewById(R.id.nr);
        GridLayout  gridLayout=(GridLayout) findViewById(R.id.gridLayout) ;
        FrameLayout frame1 =(FrameLayout) findViewById(R.id.frame1) ;
        Button btn1 =(Button) findViewById(R.id.button1);
        Button btn2 =(Button) findViewById(R.id.button2);

        Button btn3 =(Button) findViewById(R.id.button3);
        Button btn4 =(Button) findViewById(R.id.button4);
        Button btn5 =(Button) findViewById(R.id.button5);
        Button btn6 =(Button) findViewById(R.id.button6);
        Button btn7 =(Button) findViewById(R.id.button7);
        Button btn8 =(Button) findViewById(R.id.button8);
        Button btn9 =(Button) findViewById(R.id.button9);



        SQLiteDatabase db=dbHelper.getReadableDatabase();


        Cursor c =db.query(Pytanie.TABLE_NAME,new String[] {Pytanie.NAME,Pytanie.ID_Symbol,Pytanie.ID},null,null,null,null,null);

        c.moveToPosition(getA());   ///wczytuje aktualną pozycje kursora , gdzie cały czas jest inkrementacja zmiennej pomocniczej po klikaniu w przycisk

            ///////////

                c.moveToNext();
                String name = c.getString(c.getColumnIndex(Pytanie.NAME));
                 symbol = c.getString(c.getColumnIndex(Pytanie.ID_Symbol));
                id_pytania=c.getInt(c.getColumnIndex(Pytanie.ID));

                Log.d("MainActivity", c.getPosition() + " " + name +"symbol ="+symbol);
                pytanie.setText(name);


///////////////////////////


        Cursor d =db.rawQuery("Select * from "+Odpowiedz.TABLE_NAME ,new String[] {});
        if(parseInt(symbol)==1) {
            btn9.setVisibility(View.INVISIBLE);
            gridLayout.setVisibility(View.INVISIBLE);
            frame1.setVisibility(View.VISIBLE);
            d.moveToNext();

            btn1.setText(d.getString(d.getColumnIndex(Odpowiedz.NAME)));
            d.moveToNext();

            btn2.setText(d.getString(d.getColumnIndex(Odpowiedz.NAME)));
        }
        if(parseInt(symbol)==2) {
            frame1.setVisibility(View.INVISIBLE);
            btn9.setVisibility(View.VISIBLE);
            gridLayout.setVisibility(View.VISIBLE);
            d.moveToNext();
            d.moveToNext();
            d.moveToNext();
            int a=1;

            btn3.setText(d.getString(d.getColumnIndex(Odpowiedz.NAME)));
            d.moveToNext();
            btn4.setText(d.getString(d.getColumnIndex(Odpowiedz.NAME)));
            d.moveToNext();
            btn5.setText(d.getString(d.getColumnIndex(Odpowiedz.NAME)));
            d.moveToNext();
            btn6.setText(d.getString(d.getColumnIndex(Odpowiedz.NAME)));
            d.moveToNext();
            btn7.setText(d.getString(d.getColumnIndex(Odpowiedz.NAME)));
            d.moveToNext();
            btn8.setText(d.getString(d.getColumnIndex(Odpowiedz.NAME)));
            d.moveToNext();
            btn9.setText(d.getString(d.getColumnIndex(Odpowiedz.NAME)));


        }

        nr_pyt.setText("Pytanie "+String.format("%d", getA()+2)+" z "+ust.getLiczba_pytan());
    }

    void addAnkietaPytanie(int id_pyt,int id_odp){

        SQLiteDatabase db=dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(Ankieta_pytanie.ID_ODPOWIEDZ,id_odp);
        cv.put(Ankieta_pytanie.ID_PYTANIE,id_pyt);
        cv.put(Ankieta_pytanie.ID_UZYTKOWNIK,id_uzytkownik);

        long id=db.insert(Ankieta_pytanie.TABLE_NAME,null,cv);


    }

    void SprawdzDaneCzyWgrane(){

        SQLiteDatabase db=dbHelper.getReadableDatabase();

        Cursor dx =db.rawQuery("Select * from "+Pytanie.TABLE_NAME ,new String[] {});
       db.getVersion();
        int t=dx.getCount();
        if(t<=0){
            Log.d("MainActivity","Udało się"+t);
            Odpowiedz odpowiedz =new Odpowiedz();
            Pytanie pytanie = new Pytanie();
            Symbol symbol = new Symbol();




            pytanie.dodaj_dane(dbHelper);
            odpowiedz.dodaj_dane(dbHelper);
            symbol.dodaj_dane(dbHelper);

        }
        else{
            Log.d("MainActivity","Dane już wgrane"+t);
        }


    }
    void Twoja_odp(int a,boolean i){


        if(i==true){
            odpowiedz[getA()+1] =a-1;
        }
        TextView odp_nr=(TextView) findViewById(R.id.odp_nr);
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor d =db.rawQuery("Select * from "+Odpowiedz.TABLE_NAME ,new String[] {});


        if(a==-1){                                          // -1 liczba pomocnicza jesli równa sie to znaczy ze jeszcze nie zastąpiono liczy w tablicy lub kliknieto next lub back
//
            if(odpowiedz[getA()+1]!=-1){                   //kliknieto next lub back i wtedy wartosc jest wczytana z tablicy

                d.moveToPosition(odpowiedz[getA()+1]);
                odp_nr.setText("Twoja odpowiedź: " + d.getString(d.getColumnIndex(Odpowiedz.NAME)));
            }
            else{                                           //jeszcze nic nie wybrano

                odp_nr.setText("Twoja odpowiedź: nie wybrano");
            }
        }
        else {
            d.moveToPosition(odpowiedz[getA()+1]);
            odp_nr.setText("Twoja odpowiedź: " + d.getString(d.getColumnIndex(Odpowiedz.NAME)));

        }
    }

    private void AddUzytkownik(){
        SQLiteDatabase db=dbHelper.getReadableDatabase();


        SQLiteDatabase dba=dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(Uzytkownik.NAME,"Użytkownik");


        id_uzytkownik =dba.insert(Uzytkownik.TABLE_NAME,null,cv);
        Log.d("MainActivity2","Numer id uzytkownika= "+id_uzytkownik);
    }


    public void next(View view) {
        if(getA()<=ust.getLiczba_pytan()-3) {
            setA(getA() + 1);
            LogData();
            Log.d("MainActivity2", "dddddddddddddddddddddd= " + (getA() + 1));
            Twoja_odp(-1, false);
        }

    }
    public void back(View view) {
        if(getA()>=0) {
            setA(getA() - 1);
            LogData();
            Twoja_odp(-1,false);
        }

    }
    public void btn1(View view) {
        Dla_button_funkcja(1);

    }
    public void btn2(View view) {
        Dla_button_funkcja(2);

    }
    public void btn3(View view) {

        Dla_button_funkcja(3);
    }
    public void btn4(View view) {
        Dla_button_funkcja(4);
    }
    public void btn5(View view) {
        Dla_button_funkcja(5);

    }
    public void btn6(View view) {
        Dla_button_funkcja(6);

    }
    public void btn7(View view) {
        Dla_button_funkcja(7);

    }
    public void btn8(View view) {
        Dla_button_funkcja(8);

    }
    public void btn9(View view) {
        Dla_button_funkcja(9);

    }

    public void Dla_button_funkcja(int a){
       final int x= getLiczba_choroby(); // zapamietuje liczbe punktów , zabezpieczenie gdy klikniemy w "Nie" wtedy przeżuca od nowa tą samą liczbe

        if(getA()<=ust.getLiczba_pytan()-3) {
            Twoja_odp(a,true);
            setA(getA()+ 1);
            LogData();
            Twoja_odp(-1,false);
        }
        else{                                                           //zakończenie ankiety
            Twoja_odp(a,true);          //// tu wywołuje to co powyzej czesc bo ostatni sie niezapisywał w tablicy liczba

            oblicz_punkty();
            String chory=" zdrowy";
            if(getLiczba_choroby()<ust.getChory_od())              ///jesli masz mniej niz 80 p to pacjent chory
                chory=" chory";
            AlertDialog.Builder dialog_bulider = new AlertDialog.Builder(this);
            dialog_bulider.setMessage("Numer Twojej ankiety to: "+id_uzytkownik +"\nWynik badania: "+getLiczba_choroby()+".\nPacjent jest "+chory+"\nCzy zakończyć ankiete?");

            dialog_bulider.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ///Pętla wklepująca dane do bazy z tablicy
                    for (int i = 0; i < ust.getLiczba_pytan(); i++) {
                        addAnkietaPytanie(i + 1, odpowiedz[i] + 1);
                    }
                    Run_Scene_2();

                }
            });
            dialog_bulider.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    setLiczba_choroby(x);  ///Wpisanie tej samej liczby punktów jeszcze raz zeby sie nie dublowały punkty po klinkniecu=iu w Nie
                }
            });
            dialog_bulider.create();
            dialog_bulider.show();


        }
    }
    public void Run_Scene_2(){
    Intent intent = new Intent(this, MainActivity2.class);
    startActivity(intent);
    finish();}

    public void  oblicz_punkty() {
        int a=0;
        for (int i = 0; i < ust.getLiczba_pytan(); i++) {
             a=odpowiedz[i]+1;
            int b=0;
            //Przydzielanie punktów  do poszczególnych odpowiedzi
            if(a==1)
                b=7;
            if(a==2)
                b=0;
            if(a==3)
                b=1;
            if(a==4)
                b=2;
            if(a==5)
                b=3;
            if(a==6)
                b=4;
            if(a==7)
               b=5;
            if(a==8)
                b=6;
            if(a==9)
               b=7;
            Log.d("MainActivity2", "Punktów= " + b);
            setLiczba_choroby(getLiczba_choroby()+b);


    }
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getLiczba_choroby() {
        return liczba_choroby;
    }

    public void setLiczba_choroby(int liczba_choroby) {
        this.liczba_choroby = liczba_choroby;
    }
}
