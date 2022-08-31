package com.example.roomexample;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity (primaryKeys = {"paId", "taxId", "protId"},
        foreignKeys = {
        @ForeignKey(entity = taksidiotikoGrafeio.class,
                parentColumns = "tId",
                childColumns = "taxId",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE),
        @ForeignKey(entity = proteinomenhEkdromh.class,
                parentColumns = "prId",
                childColumns = "protId",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)
})
public class paketoEkdromhs {
    private int paId;
    private int taxId;
    private int protId;
    @NonNull
    private String paDate;
    @NonNull
    private int paPrice;

    public int getPaId() {
        return paId;
    }

    public void setPaId(int paId) {
        this.paId = paId;
    }

    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }

    public int getProtId() {
        return protId;
    }

    public void setProtId(int protId) {
        this.protId = protId;
    }

    public String getPaDate() {
        return paDate;
    }

    public void setPaDate(String paDate) {
        this.paDate = paDate;
    }

    public int getPaPrice() {
        return paPrice;
    }

    public void setPaPrice(int paPrice) {
        this.paPrice = paPrice;
    }
}
