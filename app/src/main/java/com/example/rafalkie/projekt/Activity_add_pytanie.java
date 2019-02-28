package com.example.rafalkie.projekt;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Activity_add_pytanie extends AppCompatActivity {
    Pytanie pyt;
    DbHelper dbHelper;
    MultiAutoCompleteTextView tekst;
    RadioButton check1;
    RadioButton check2;
    RadioGroup gropu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pytanie);
        dbHelper = new DbHelper(this);
        pyt=new Pytanie();
        tekst=(MultiAutoCompleteTextView)  findViewById(R.id.text_add);
        gropu=(RadioGroup) findViewById(R.id.gropu) ;
        check1=(RadioButton) findViewById(R.id.check1) ;
        check2=(RadioButton) findViewById(R.id.check2) ;


    }




    public void add_text(View view) {

        String pytanie=tekst.getText().toString();
        pyt.addPytanie(pytanie,Symbol(),dbHelper);
        alert();
    }
    public void back(View view) {

        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        finish();
    }


    public void alert(){
        AlertDialog.Builder dialog_bulider = new AlertDialog.Builder(this);
        dialog_bulider.setMessage("Pytanie zostało dodane do bazy danych");

        dialog_bulider.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        dialog_bulider.create();
        dialog_bulider.show();
    }
    public int Symbol(){
        if(check1.isChecked()){
            return 1;

        }
        if(check2.isChecked()){
           return 2;

        }

        return 1;
    }



}
