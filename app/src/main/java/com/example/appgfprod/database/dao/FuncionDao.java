package com.example.appgfprod.database.dao;

import com.example.appgfprod.database.entity.Funcion;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface FuncionDao {

    @Query("SELECT * FROM FUNCION")
    boolean checkFunciones();

    @Query("SELECT * FROM FUNCION ORDER BY ID")
    List<Funcion> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFuncion(Funcion funcion);

    @Update
    void updateFuncion(Funcion funcion);

    @Delete
    void delete(Funcion funcion);

    @Query("DELETE FROM FUNCION")
    void deleteAllFunciones();

    @Query("SELECT * FROM FUNCION WHERE id = :id")
    Funcion findById(int id);

}
