package com.example.roomexample;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class proteinomenhEkdromh {
    @PrimaryKey
    private int prId;
    @NonNull
    private String prCity;
    @NonNull
    private String prCountry;
    @NonNull
    private int prDiarkeia;
    @NonNull
    private String prEidos;

    public int getPrId() {
        return prId;
    }

    public void setPrId(int prId) {
        this.prId = prId;
    }

    public String getPrCity() {
        return prCity;
    }

    public void setPrCity(String prCity) {
        this.prCity = prCity;
    }

    public String getPrCountry() {
        return prCountry;
    }

    public void setPrCountry(String prCountry) {
        this.prCountry = prCountry;
    }

    public int getPrDiarkeia() {
        return prDiarkeia;
    }

    public void setPrDiarkeia(int prDiarkeia) {
        this.prDiarkeia = prDiarkeia;
    }

    public String getPrEidos() {
        return prEidos;
    }

    public void setPrEidos(String prEidos) {
        this.prEidos = prEidos;
    }
}
