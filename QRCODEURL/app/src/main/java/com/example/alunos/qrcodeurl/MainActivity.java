package com.example.alunos.qrcodeurl;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Elementos do layout
    private Button btnScan;
    private TextView lblNome, lblEndereco;
    private String aUrl;
    //QRCode scanner
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScan = findViewById(R.id.btnScan);
        lblNome = findViewById(R.id.lblTexto1);
        lblEndereco = findViewById(R.id.lblTexto2);

        //intializing scan object
        qrScan = new IntentIntegrator(this);

        //attaching onclick listener
        btnScan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        qrScan.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null){
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            }else {
                try{
                    JSONObject obj = new JSONObject(result.getContents());
                    lblNome.setText(obj.getString("name"));
                    lblEndereco.setText(obj.getString("address"));

                }catch (JSONException e){
                    String string = result.getContents();
                    if((string.indexOf("http://www")!=0) && (string.indexOf(".com")!=0)){
                        Intent intencao = new Intent(Intent.ACTION_VIEW, Uri.parse(string.toLowerCase()));
                        startActivity(intencao);
                    } else {
                        e.printStackTrace();
                        Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                    }

                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
