package com.example.appgfprod.database.dao;

import com.example.appgfprod.database.entity.Contenido;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ContenidoDao {

    @Query("SELECT * FROM CONTENIDO")
    boolean checkContenidos();

    @Query("SELECT * FROM CONTENIDO ORDER BY ID")
    List<Contenido> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertContenido(Contenido contenido);

    @Update
    void updateContenido(Contenido contenido);

    @Delete
    void delete(Contenido contenido);

    @Query("DELETE FROM CONTENIDO")
    void deleteAllContenidos();

    @Query("SELECT * FROM CONTENIDO WHERE id = :id")
    Contenido findById(int id);

}
