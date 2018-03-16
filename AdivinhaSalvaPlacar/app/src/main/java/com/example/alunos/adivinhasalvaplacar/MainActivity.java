package com.example.alunos.adivinhasalvaplacar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Random gerador = new Random();
    int num_aleatorio = gerador.nextInt(1001), c = 0;


    public void joga(View v){
        TextView mensagem = (TextView) findViewById(R.id.id);
        EditText cxeNum = findViewById(R.id.cxeNum);
        String usuario = cxeNum.getText().toString();
        if (num_aleatorio == 0){
            num_aleatorio = 1;
        }
        int num;
        num = Integer.parseInt(usuario);
        String msg;
        if(num == num_aleatorio){
            msg = "Parabéns! Você acertou! ";
            mensagem.setText(msg)
        } else {
            ++c;
            msg = "Você errou!";
            if (num>num_aleatorio){
                msg += " O palpite foi maior";
                mensagem.setText(msg);
            } else {
                msg += " O palpite foi menor";
                mensagem.setText(msg);
            }
        }
    }



    public void deNovo(View v){
        c = 0;
        num_aleatorio = gerador.nextInt(1001);
        TextView mensagem = (TextView) findViewById(R.id.id);
        String msg;
        msg = "Informe um número entre 1 e 1000:";
        mensagem.setText(msg);
    }
}

