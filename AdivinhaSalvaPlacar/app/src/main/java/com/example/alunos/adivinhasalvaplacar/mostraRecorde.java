package com.example.alunos.adivinhasalvaplacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.alunos.adivinhasalvaplacar.adapter.RecordeAdapter;
import com.example.alunos.adivinhasalvaplacar.model.Recorde;
import java.util.ArrayList;

public class mostraRecorde extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorde);

        ListView listview = findViewById(R.id.listView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        try{
            ArrayList <Recorde> lista = bundle.getParcelableArrayList(
                    "recorde");
            RecordeAdapter adapter = new RecordeAdapter(
                    mostraRecorde.this, lista);
            listview.setAdapter(adapter);
        } catch(Exception e){
            Log.d(e.getClass().toString(), e.getMessage());
        }
    }

}
