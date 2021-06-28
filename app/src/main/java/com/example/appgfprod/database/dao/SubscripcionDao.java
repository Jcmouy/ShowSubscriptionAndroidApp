package com.example.appgfprod.database.dao;

import com.example.appgfprod.database.entity.Subscripcion;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface SubscripcionDao {

    @Query("SELECT * FROM SUBSCRIPCION")
    boolean checkSubscripciones();

    @Query("SELECT * FROM SUBSCRIPCION ORDER BY ID")
    List<Subscripcion> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSubscripcion(Subscripcion subscripcion);

    @Update
    void updateSubscripcion(Subscripcion subscripcion);

    @Delete
    void delete(Subscripcion subscripcion);

    @Query("DELETE FROM SUBSCRIPCION")
    void deleteAllSubscripciones();

    @Query("SELECT * FROM SUBSCRIPCION WHERE id = :id")
    Subscripcion findById(int id);

}
