package com.example.roomexample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface myDAO {
    @Insert
    public void addTaksidiotikoGrafeio(taksidiotikoGrafeio TAKSIDIOTIKOGRAFEIO);
    @Insert
    public void addProteinomenhEkdromh(proteinomenhEkdromh PROTEINOMENHEKDROMH);
    @Insert
    public void addPaketoEkdromhs(paketoEkdromhs PAKETOEKDROMHS);


    @Query("SELECT * FROM TAKSIDIOTIKOGRAFEIO")
    public List<taksidiotikoGrafeio> getTaksidiotikoGrafeio();
    @Query("SELECT * FROM PROTEINOMENHEKDROMH")
    public List<proteinomenhEkdromh> getProteinomenhEkdromh();
    @Query("SELECT * FROM PAKETOEKDROMHS")
    public List<paketoEkdromhs> getPaketoEkdromhs();
    @Query("SELECT DISTINCT PR.* FROM PROTEINOMENHEKDROMH PR, TAKSIDIOTIKOGRAFEIO TAKS, PAKETOEKDROMHS PAK " +
            "WHERE PR.prId = PAK.protId AND PAK.taxId = TAKS.tId AND TAKS.tName = 'Take Me Somewhere';")
    public List<proteinomenhEkdromh> getQuery4();
    @Query("SELECT PAK.* FROM PAKETOEKDROMHS PAK, PROTEINOMENHEKDROMH PR WHERE PAK.protId = PR.prId AND PR.prCity = 'Madrid';")
    public List<paketoEkdromhs> getQuery5();
    @Query("SELECT * FROM PAKETOEKDROMHS WHERE paPrice < 200;")
    public List<paketoEkdromhs> getQuery6();


    @Delete
    public void deleteTaksidiotikoGrafeio(taksidiotikoGrafeio TAKSIDIOTIKOGRAFEIO);
    @Delete
    public void deleteProteinomenhEkdromh(proteinomenhEkdromh PROTEINOMENHEKDROMH);
    @Delete
    public void deletePaketoEkdromhs(paketoEkdromhs PAKETOEKDROMHS);

    @Update
    public void updateTaksidiotikoGrafeio(taksidiotikoGrafeio TAKSIDIOTIKOGRAFEIO);
    @Update
    public void updateProteinomenhEkdromh(proteinomenhEkdromh PROTEINOMENHEKDROMH);
    @Update
    public void updatePaketoEkdromhs(paketoEkdromhs PAKETOEKDROMHS);
}
