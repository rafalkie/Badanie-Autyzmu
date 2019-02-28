package com.example.rafalkie.projekt;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity_Pytania_edit extends AppCompatActivity {

    public static final String KEY_ID="key_id";
    Long text;
    DbHelper dbHelper;
    int symbol;
    RadioButton check1;
    RadioButton check2;
    RadioGroup gropu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__pytania_edit);
        dbHelper = new DbHelper(this);
        Bundle b=getIntent().getExtras();
        text= b.getLong(KEY_ID,0);
        gropu=(RadioGroup) findViewById(R.id.gropu) ;

        check1=(RadioButton) findViewById(R.id.check1) ;
        check2=(RadioButton) findViewById(R.id.check2) ;

//        Log.d("MainActivity","sssssssssssssssss="+text );
        wyswietl_id();
        sprawdz_Symbol();


    }
    ///funkcja dzieki której pokazuje tekst w polu edycji
    public void wyswietl_id() {

        MultiAutoCompleteTextView text_edit =  (MultiAutoCompleteTextView) findViewById(R.id.text_edit);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query(Pytanie.TABLE_NAME, new String[]{Pytanie.NAME,Pytanie.ID,Pytanie.ID_Symbol}, null, null, null, null, null);



           c.moveToPosition(Integer.parseInt(""+text)-1);
           String name = c.getString(c.getColumnIndex(Pytanie.NAME));
           symbol = c.getInt(c.getColumnIndex(Pytanie.ID_Symbol));
           text_edit.setText(name);




        }

    public void refresh(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        MultiAutoCompleteTextView text_edit =  (MultiAutoCompleteTextView) findViewById(R.id.text_edit);

        String pytanie=text_edit.getText().toString();
        symbol=Symbol();
        String strSQL = "UPDATE "+Pytanie.TABLE_NAME+" SET "+Pytanie.NAME+" = '"+pytanie+"',"+Pytanie.ID_Symbol+" = '"+symbol+"'  WHERE "+Pytanie.ID+" = "+ text;

        db.execSQL(strSQL);
        Intent intent = new Intent(this, Activity_Pytania.class);
        startActivity(intent);
        finish();
    }
    public void back(View view) {
        Intent intent = new Intent(this, Activity_Pytania.class);
        startActivity(intent);
        finish();
    }
    public void sprawdz_Symbol(){
        if(symbol==1){
            check1.setChecked(true);
        }
        else{
            check2.setChecked(true);
        }
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
