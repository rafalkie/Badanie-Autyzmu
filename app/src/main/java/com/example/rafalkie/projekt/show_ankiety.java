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
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class show_ankiety extends AppCompatActivity {


    private ListView listView;
    private itm_P_listAdapter adapter;
    private List<itm_P> mList;


    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ankiety);

        dbHelper = new DbHelper(this);
        podaj_pytania();

        final TextView iteam_pyt2 = (TextView) findViewById(R.id.iteam_pyt);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(show_ankiety.this, Show_ankieta_view.class);


                intent.putExtra(Show_ankieta_view.KEY2_ID,listView.getItemIdAtPosition(i)+1);

                startActivity(intent);

            }
        });
    }


    private void podaj_pytania() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query(Uzytkownik.TABLE_NAME, new String[]{Uzytkownik.NAME,Uzytkownik.ID}, null, null, null, null, null);


        listView = (ListView) findViewById(R.id.list_pytania);

        mList = new ArrayList<>();
        String name;
        int id_pytania;


        for (int i = 0; i <c.getCount(); i++) {
            c.moveToPosition(i);
            id_pytania = c.getInt(c.getColumnIndex(Uzytkownik.ID));
            String a="";
            mList.add(new itm_P(i, "Ankieta nr " + id_pytania,a));


        }

        adapter = new itm_P_listAdapter(getApplicationContext(), mList);
        listView.setAdapter(adapter);


    }

}
