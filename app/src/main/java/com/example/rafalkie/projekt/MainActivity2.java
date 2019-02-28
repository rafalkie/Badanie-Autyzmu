package com.example.rafalkie.projekt;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void startAnkieta(View view) {




        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public void  load_form(View view) {




        Intent intent = new Intent(this, Activity_Pytania.class);
        startActivity(intent);

    }
    public void Dodaj_pytanie(View view) {


        Intent intent = new Intent(this, Activity_add_pytanie.class);
        startActivity(intent);

    }
    public void show_ankieta(View view) {


        Intent intent = new Intent(this, show_ankiety.class);
        startActivity(intent);

    }
    public void Ustawienia(View view) {


        Intent intent = new Intent(this, Ustawienia.class);
        startActivity(intent);

    }

    public void koniec(View view) {


        finish();


    }



}
