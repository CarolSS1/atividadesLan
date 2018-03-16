package com.example.alunos.adivinhasalvaplacar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    int c, num_aleatorio, certo;
    EditText txtnum;
    Random gerador = new Random();
    Intent i;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num_aleatorio = gerador.nextInt(10);
        c = 0;
        certo = 0;
        txtnum = findViewById(R.id.txtNum);
        i = new Intent(MainActivity.this, Recorde.class);
    }

    public void joga(View v){
        TextView mensagem = (TextView) findViewById(R.id.id);
        String usuario = txtnum.getText().toString();
        if (num_aleatorio == 0){
            num_aleatorio = 1;
        }
        int num;
        num = Integer.parseInt(usuario);
        String msg;
        if (certo == 0) {
            if(num == num_aleatorio){
                msg = "Parabéns! Você acertou! ";
                mensagem.setText(msg);
                certo = 1;

                Bundle bundle = new Bundle();
                bundle.putInt("chances", c);
                i.putExtras(bundle);
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
        } else {
            msg = "Você já acertou o número, clique no botão 'Jogar novamente'! ";
            mensagem.setText(msg);
        }

    }

    public void deNovo(View v){
        c = 0;
        certo = 0;
        num_aleatorio = gerador.nextInt(10);
        TextView mensagem = (TextView) findViewById(R.id.id);
        String msg;
        msg = "Informe um número entre 1 e 1000:";
        mensagem.setText(msg);
    }

    public void carregarRecorde(View v){
        startActivity(i);
    }
}

