package com.example.alunos.desafiotoolbar.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alunos.desafiotoolbar.R;
import com.example.alunos.desafiotoolbar.model.Pessoa;

import java.util.List;

public class PessoaAdapter extends BaseAdapter {
    private Activity atividade;
    private List<Pessoa> lista;

    public PessoaAdapter(Activity atividade, List<Pessoa> lista){
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
        Pessoa obj = lista.get(position);

        View v = atividade.getLayoutInflater().inflate(R.layout.row_layout,
                parent, false);

        TextView textNome = v.findViewById(R.id.lbl_nome);
        textNome.setText(obj.getNome());

        return v;
    }
}
