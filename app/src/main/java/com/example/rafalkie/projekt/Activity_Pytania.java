package com.example.rafalkie.projekt;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.rafalkie.projekt.R.id.iteam_pyt;

public class Activity_Pytania extends AppCompatActivity {

    private ListView listView;
    private itm_P_listAdapter adapter;
    private List<itm_P> mList;


    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__pytania);

        dbHelper = new DbHelper(this);
        podaj_pytania();

        final TextView iteam_pyt2 = (TextView) findViewById(R.id.iteam_pyt);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Activity_Pytania.this, Activity_Pytania_edit.class);

//                Log.d("MainActivity","ddddddddddddddddddddddd"+(listView.getItemIdAtPosition(i)+1) );
                intent.putExtra(Activity_Pytania_edit.KEY_ID,listView.getItemIdAtPosition(i)+1);

                startActivity(intent);

            }
        });
    }


    private void podaj_pytania() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query(Pytanie.TABLE_NAME, new String[]{Pytanie.NAME,Pytanie.ID_Symbol,Pytanie.ID}, null, null, null, null, null);


        listView = (ListView) findViewById(R.id.list_pytania);

        mList = new ArrayList<>();
        String name;
        int id_pytania;


        for (int i = 0; i <c.getCount(); i++) {
            c.moveToPosition(i);
            name = c.getString(c.getColumnIndex(Pytanie.NAME));
            id_pytania = c.getInt(c.getColumnIndex(Pytanie.ID));

            mList.add(new itm_P(i, "Pytanie " + id_pytania, name));


        }

        adapter = new itm_P_listAdapter(getApplicationContext(), mList);
        listView.setAdapter(adapter);


    }


}
