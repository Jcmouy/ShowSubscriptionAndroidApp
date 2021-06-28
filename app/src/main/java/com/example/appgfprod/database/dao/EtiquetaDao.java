package com.example.appgfprod.database.dao;

import com.example.appgfprod.database.entity.Etiqueta;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface EtiquetaDao {

    @Query("SELECT * FROM ETIQUETA")
    boolean checkEtiquetas();

    @Query("SELECT * FROM ETIQUETA ORDER BY ID")
    List<Etiqueta> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEtiqueta(Etiqueta etiqueta);

    @Update
    void updateEtiqueta(Etiqueta etiqueta);

    @Delete
    void delete(Etiqueta etiqueta);

    @Query("DELETE FROM ETIQUETA")
    void deleteAllEtiquetas();

    @Query("SELECT * FROM ETIQUETA WHERE id = :id")
    Etiqueta findById(int id);

}
