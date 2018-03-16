package com.example.alunos.adivinhasalvaplacar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;


public class Recorde extends AppCompatActivity {

    int recorde[] = new int[6];
    int placar;
    int var;
    int x, v = 0;
    String chances;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorde);
        TextView recorde1 = (TextView) findViewById(R.id.txtRecorde1);
        TextView recorde2 = (TextView) findViewById(R.id.txtRecorde2);
        TextView recorde3 = (TextView) findViewById(R.id.txtRecorde3);
        TextView recorde4 = (TextView) findViewById(R.id.txtRecorde4);
        TextView recorde5 = (TextView) findViewById(R.id.txtRecorde5);
        TextView recorde6 = (TextView) findViewById(R.id.txtRecorde6);

        Intent intencao = getIntent();
        Bundle pacote = intencao.getExtras();
        chances = pacote.getString("chances");

        placar = Integer.parseInt(chances);
        if ( v == 0 ){
            for(x = 0; x < 6; x++){
                recorde[x] = 1;
            }
            v = 1;
        }else {
            for(x = 0; x < 6; x++){
                if(placar <= recorde[x]){
                    var = recorde [x];
                    recorde[x] = placar;
                    placar = var;
                }
            }
        }

        recorde1.setText(recorde[0]);
        recorde2.setText(recorde[1]);
        recorde3.setText(recorde[2]);
        recorde4.setText(recorde[3]);
        recorde5.setText(recorde[4]);
        recorde6.setText(recorde[5]);

    }
}
