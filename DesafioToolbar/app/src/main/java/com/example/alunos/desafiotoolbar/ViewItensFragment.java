package com.example.alunos.desafiotoolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alunos.desafiotoolbar.model.Pessoa;

import java.util.ArrayList;

public class ViewItensFragment extends Fragment{
    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.view_items_layout, container, false);
        MainActivity m = new MainActivity();
        m.mostrarLista(v);
        return v;
    }



}
