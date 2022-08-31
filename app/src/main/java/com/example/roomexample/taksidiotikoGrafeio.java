package com.example.roomexample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class taksidiotikoGrafeio {
    @PrimaryKey
    @ColumnInfo (name = "tId")
    private int grafId;

    @ColumnInfo(name= "tName")  @NonNull     //Κρύβω το όνομα της στήλης της βάσης και οριζω το όνομα που θα χρησιμοποιώ στον κώδικά μου
                                            //για να κρύψω τα metadata της βάσης δεδομένων
    private String grafName;
    @ColumnInfo(name= "tAddress")   @NonNull
    private String GrafAddress;

    public int getGrafId() {
        return grafId;
    }

    public void setGrafId(int grafId) {
        this.grafId = grafId;
    }

    @NonNull
    public String getGrafName() {
        return grafName;
    }

    public void setGrafName(@NonNull String grafName) {
        this.grafName = grafName;
    }

    @NonNull
    public String getGrafAddress() {
        return GrafAddress;
    }

    public void setGrafAddress(@NonNull String grafAddress) {
        GrafAddress = grafAddress;
    }
}
