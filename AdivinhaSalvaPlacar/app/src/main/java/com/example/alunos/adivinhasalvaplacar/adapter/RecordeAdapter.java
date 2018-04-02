package com.example.alunos.adivinhasalvaplacar.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.alunos.adivinhasalvaplacar.R;
import com.example.alunos.adivinhasalvaplacar.model.Recorde;
import java.util.List;



public class RecordeAdapter extends BaseAdapter{
    private Activity atividade;
    private List<Recorde> lista;

    public RecordeAdapter(Activity atividade, List<Recorde> lista){
        this.atividade = atividade;
        this.lista = lista;
    }

    @Override
    public int getCount(){
        return lista.size();
    }

    @Override
    public Object getItem(int position){
        return lista.get(position);
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Recorde obj = lista.get(position);

        View v = atividade.getLayoutInflater().inflate(R.layout.row_layout,
                parent, false);

        TextView lbl_chances = v.findViewById(R.id.lbl_chances);
        lbl_chances.setText(obj.getChance());

        return v;
    }
}
