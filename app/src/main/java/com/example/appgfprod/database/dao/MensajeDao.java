package com.example.appgfprod.database.dao;

import com.example.appgfprod.database.entity.Mensaje;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MensajeDao {

    @Query("SELECT * FROM MENSAJE")
    boolean checkMensajes();

    @Query("SELECT * FROM MENSAJE ORDER BY ID")
    List<Mensaje> getAll();

    @Query("SELECT * FROM MENSAJE WHERE obraNombre = :nombre ORDER BY ID")
    List<Mensaje> getAllMensajeByObra(String nombre);

    @Query("SELECT ID FROM MENSAJE ORDER BY ID DESC LIMIT 1")
    int getLastInsertedIdMensaje();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMensaje(Mensaje mensaje);

    @Update
    void updateMensaje(Mensaje mensaje);

    @Delete
    void delete(Mensaje mensaje);

    @Query("DELETE FROM MENSAJE")
    void deleteAllMensajes();

    @Query("SELECT * FROM MENSAJE WHERE id = :id")
    Mensaje findById(int id);

}
