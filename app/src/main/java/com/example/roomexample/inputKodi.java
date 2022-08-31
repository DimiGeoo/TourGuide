package com.example.roomexample;

import com.google.firebase.firestore.DocumentReference;

public class inputKodi {
    private DocumentReference  KodikosEkdromis;
        private DocumentReference   KodikosPaketou;
    private String Hotel;


    public DocumentReference getKodikosEkdromis() {
            return KodikosEkdromis;
    }

    public void setKodikosEkdromis(DocumentReference kodikosEkdromis) {
        KodikosEkdromis = kodikosEkdromis;
    }

    public DocumentReference getKodikosPaketou() {
        return KodikosPaketou;
    }

    public void setKodikosPaketou(DocumentReference kodikosPaketou) {
        KodikosPaketou = kodikosPaketou;
    }

    public String getHotel() {
        return Hotel;
    }

    public void setHotel(String hotel) {
        Hotel = hotel;
    }
}
