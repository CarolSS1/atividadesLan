package com.example.alunos.adivinhasalvaplacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import com.example.alunos.adivinhasalvaplacar.Recorde;
import com.example.alunos.adivinhasalvaplacar.RecordeAdapter;


public class mostraRecorde extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorde);

        ListView listview = findViewById(R.id.listView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        try{
            ArrayList <Recorde> lista = bundle.getParcelableArrayList(
                    "chances");
            RecordeAdapter adapter = new RecordeAdapter(
                    mostraRecorde.this, lista);
            listview.setAdapter(adapter);
        } catch(Exception e){
            Log.d(e.getClass().toString(), e.getMessage());
        }
    }

}
