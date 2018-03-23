package com.example.alunos.adivinhasalvaplacar;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;


public class Recorde extends AppCompatActivity {

    private int chances;

    public Recorde(int chances){
        this.chances = chances;
    }

    public int getRecorde(){
        return chances;
    }

    protected Recorde(Parcel in) {
        chances = in.readInt();
    }

    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(chances);
    }

    @SuppressWarnings ("unused")
    public static final Parcelable.Creator<Recorde> CREATOR =
            new Parcelable.Creator<Recorde>(){
                @Override
                public Recorde createFromParcel(Parcel in){
                    return new Recorde(in);
                }

                @Override
                public Recorde[] newArray(int size){
                    return new Recorde[size];
                }
            };
}
