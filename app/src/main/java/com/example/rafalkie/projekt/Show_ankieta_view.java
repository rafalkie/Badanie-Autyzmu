package com.example.rafalkie.projekt;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Show_ankieta_view extends AppCompatActivity {

    public static final String KEY2_ID="key2_id";
    long text;
    private ListView listView;
    private itm_P_listAdapter adapter;
    private List<itm_P> mList;


    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ankieta_view);

        Bundle b=getIntent().getExtras();
        text= b.getLong(KEY2_ID,0);
        Log.d("MainActivity","ddddddddddddddddddddddd=="+ text);

        dbHelper = new DbHelper(this);
        podaj_pytania();


    }



    private void podaj_pytania() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("Select "+Pytanie.TABLE_NAME+"."+Pytanie.NAME+","+Odpowiedz.TABLE_NAME+"."+Odpowiedz.NAME+" from "+Ankieta_pytanie.TABLE_NAME+" , "+Odpowiedz.TABLE_NAME+" , "+Pytanie.TABLE_NAME+" where "+Ankieta_pytanie.ID_UZYTKOWNIK+"="+text+
                " and  Pytanie.id_pytanie=Ankieta_pytanie.id_pytanie and Odpowiedz.id_odpowiedz=Ankieta_pytanie.id_odpowiedz",null);
        Cursor d = db.rawQuery("Select "+Odpowiedz.TABLE_NAME+"."+Odpowiedz.NAME+","+Pytanie.TABLE_NAME+"."+Pytanie.NAME+" from "+Ankieta_pytanie.TABLE_NAME+" , "+Odpowiedz.TABLE_NAME+" , "+Pytanie.TABLE_NAME+" where "+Ankieta_pytanie.ID_UZYTKOWNIK+"="+text+
                " and  Pytanie.id_pytanie=Ankieta_pytanie.id_pytanie and Odpowiedz.id_odpowiedz=Ankieta_pytanie.id_odpowiedz",null);



        listView = (ListView) findViewById(R.id.list_pytania);

        mList = new ArrayList<>();
        String name;
        String id_pytania;


        for (int i = 0; i <c.getCount(); i++) {
            c.moveToPosition(i);
            d.moveToPosition(i);
            name = d.getString(d.getColumnIndex(Odpowiedz.NAME));
            id_pytania = c.getString(c.getColumnIndex(Pytanie.NAME));

            mList.add(new itm_P(i, (i+1)+". "+ name, "  Odpowiedź: "+id_pytania));


        }

        adapter = new itm_P_listAdapter(getApplicationContext(), mList);
        listView.setAdapter(adapter);


    }
}
