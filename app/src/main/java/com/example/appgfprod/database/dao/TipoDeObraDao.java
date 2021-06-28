package com.example.appgfprod.database.dao;

import com.example.appgfprod.database.entity.TipoDeObra;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TipoDeObraDao {

    @Query("SELECT * FROM TIPODEOBRA")
    boolean checkTiposDeObra();

    @Query("SELECT * FROM TIPODEOBRA ORDER BY ID")
    List<TipoDeObra> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTipoDeObra(TipoDeObra tipoDeObra);

    @Update
    void updateTipoDeObra(TipoDeObra tipoDeObra);

    @Delete
    void delete(TipoDeObra tipoDeObra);

    @Query("DELETE FROM TIPODEOBRA")
    void deleteAllTiposDeObra();

    @Query("SELECT * FROM TIPODEOBRA WHERE id = :id")
    TipoDeObra findById(int id);

}
