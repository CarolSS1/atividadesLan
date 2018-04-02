package com.example.alunos.salvarplacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class Salvar extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvar);

        Intent intencao = getIntent();
        Bundle pacote = intencao.getExtras();

        int[] vetor = new int[6];
        vetor = pacote.getIntArray("vetor");

        int maior = vetor[0];
        int R1 = vetor[1];
        int R2 = vetor[2];
        int R3 = vetor[3];
        int R4 = vetor[4];
        int R5 = vetor[5];
        TextView txtR1 = (TextView) findViewById(R.id.textR1);
        TextView txtR2 = (TextView) findViewById(R.id.textR2);
        TextView txtR3 = (TextView) findViewById(R.id.textR3);
        TextView txtR4 = (TextView) findViewById(R.id.textR4);
        TextView txtR5 = (TextView) findViewById(R.id.textR5);
        TextView txtmaior = (TextView) findViewById(R.id.textMaior);

        txtR1.setText(Integer.toString(R1));
        txtR2.setText(Integer.toString(R2));
        txtR3.setText(Integer.toString(R3));
        txtR4.setText(Integer.toString(R4));
        txtR5.setText(Integer.toString(R5));
        txtmaior.setText(Integer.toString(maior));

    }
}

