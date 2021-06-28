package com.example.appgfprod.database.dao;

import com.example.appgfprod.database.entity.Obra;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ObraDao {

    @Query("SELECT * FROM OBRA")
    boolean checkObras();

    @Query("SELECT * FROM OBRA ORDER BY ID")
    List<Obra> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertObra(Obra obra);

    @Update
    void updateObra(Obra obra);

    @Delete
    void delete(Obra obra);

    @Query("DELETE FROM OBRA")
    void deleteAllObras();

    @Query("SELECT * FROM OBRA WHERE id = :id")
    Obra findById(int id);

    @Query("SELECT * FROM OBRA WHERE nombre = :nombre")
    Obra findByNombre(String nombre);

}
