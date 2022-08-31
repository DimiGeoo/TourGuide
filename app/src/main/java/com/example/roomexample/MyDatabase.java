package com.example.roomexample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {taksidiotikoGrafeio.class, proteinomenhEkdromh.class, paketoEkdromhs.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract myDAO mydaotemp();
}
