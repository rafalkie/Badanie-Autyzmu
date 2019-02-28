package com.example.rafalkie.projekt;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static java.lang.Integer.parseInt;

public class Ustawienia extends AppCompatActivity {

    public static final String PREF_NAME ="my_prefs";
    public static final String PREF_NAME2 ="my_prefs2";
    public static final String KEY_PYTANIA ="pytania";
    public static final String KEY_CHORY ="chory";




    public static int liczba_pytann=24;
    public static int chory=80;


    EditText editText;
    EditText editText2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustawienia);

        SharedPreferences prefs = getSharedPreferences(PREF_NAME,80);
        SharedPreferences prefs2 = getSharedPreferences(PREF_NAME2,24);
        setChory_od(prefs.getInt(KEY_PYTANIA,80));
        setLiczba_pytan(prefs2.getInt(KEY_CHORY,24));


        editText=(EditText) findViewById(R.id.editText) ;
        editText.setText(""+ liczba_pytann);

        editText2=(EditText) findViewById(R.id.editText2) ;
        editText2.setText(""+ chory);




    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences prefs = getSharedPreferences(PREF_NAME,80);
        SharedPreferences prefs2 = getSharedPreferences(PREF_NAME2,24);
        prefs.edit().putInt(KEY_PYTANIA, chory).apply();
        prefs2.edit().putInt(KEY_CHORY, liczba_pytann).apply();
    }



    public void refresh(View view){
        setLiczba_pytan( parseInt(editText.getText().toString()));
        setChory_od(parseInt(editText2.getText().toString()) );
        editText.setText(getLiczba_pytan()+"");
        editText2.setText(getChory_od()+"");

        alert();
    }
    public int getLiczba_pytan() {
        return liczba_pytann;
    }
    public void setLiczba_pytan(int liczba_pytan) {
        this.liczba_pytann = liczba_pytan;
    }
    public int getChory_od() {
        return chory;
    }

    public void setChory_od(int chory_od) {
        this.chory = chory_od;
    }

    public void alert(){
        AlertDialog.Builder dialog_bulider = new AlertDialog.Builder(this);
        dialog_bulider.setMessage("Ustawienia zostały zmienione");

        dialog_bulider.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ///Pętla wklepująca dane do bazy z tablicy

            }
        });

        dialog_bulider.create();
        dialog_bulider.show();
    }
    public EditText getEditText() {
        return editText;
    }

    public EditText getEditText2() {
        return editText2;
    }
}
