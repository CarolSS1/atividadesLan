package com.example.alunos.salvarplacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int c, num_aleatorio, certo, var, maior = 0, i;
    EditText txtnum;
    Random gerador = new Random();
    int[] vetor = new int[5];
    int[] vetor2 = new int[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num_aleatorio = gerador.nextInt(1001);
        c = 1;
        certo = 0;
        var = 0;
        txtnum = findViewById(R.id.txtNum);
        for(i = 0; i<5; i++){
            vetor[i] = 0;
        }
        for(i = 0; i<6; i++){
            vetor2[i] = 0;
        }
    }

    public void joga(View v) {
        TextView mensagem = (TextView) findViewById(R.id.id);
        String usuario = txtnum.getText().toString();
        if (num_aleatorio == 0) {
            num_aleatorio = 1;
        }
        int num;
        num = Integer.parseInt(usuario);
        String msg;
        if (certo == 0) {
            if (num == num_aleatorio) {
                msg = "Parabéns! Você acertou! ";
                mensagem.setText(msg);
                certo = 1;
                for(i = 0; i<5; i++){
                    if(i == 0){
                        var = vetor[i];
                        vetor[i] = c;
                    } else {
                        c = vetor[i];
                        vetor[i] = var;
                    }
                }
                for(i = 0; i<4; i++){
                    if(vetor[i] >= vetor[i+1]){
                        maior = vetor[i+1];
                    } else {
                        maior = vetor[i];
                    }
                }
            } else {
                ++c;
                msg = "Você errou!";
                if (num > num_aleatorio) {
                    msg += " O palpite foi maior";
                    mensagem.setText(msg);
                } else {
                    msg += " O palpite foi menor";
                    mensagem.setText(msg);
                }
            }
        } else {
            msg = "Você já acertou o número, clique no botão 'Jogar novamente'! ";
            mensagem.setText(msg);
        }

    }

    public void deNovo(View v) {
        c = 1;
        certo = 0;
        num_aleatorio = gerador.nextInt(1001);
        TextView mensagem = (TextView) findViewById(R.id.id);
        String msg;
        msg = "Informe um número entre 1 e 1000:";
        mensagem.setText(msg);
    }

    public void carregarRecorde(View v){
        vetor2[0] = maior;
        vetor2[1] = vetor[0];
        vetor2[2] = vetor[1];
        vetor2[3] = vetor[2];
        vetor2[4] = vetor[3];
        vetor2[5] = vetor[4];

        Intent j = new Intent(MainActivity.this, Salvar.class);
        Bundle bundle = new Bundle();
        bundle.putIntArray("vetor", vetor2);
        j.putExtras(bundle);
        startActivity(j);

    }
}

