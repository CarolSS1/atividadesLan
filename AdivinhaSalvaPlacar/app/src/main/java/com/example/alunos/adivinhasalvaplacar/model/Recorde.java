package com.example.alunos.adivinhasalvaplacar.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Recorde implements Parcelable{

    private int chances;

    public Recorde(int chances){
        this.chances = chances;
    }

    public int getChance(){
        return chances;
    }

    public void setChance(int chances){
        this.chances = chances;
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

    @SuppressWarnings("unused")
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
