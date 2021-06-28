package com.example.appgfprod.database.dao;

import com.example.appgfprod.database.entity.Moneda;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MonedaDao {

    @Query("SELECT * FROM MONEDA")
    boolean checkMonedas();

    @Query("SELECT * FROM MONEDA ORDER BY ID")
    List<Moneda> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMoneda(Moneda moneda);

    @Update
    void updateMoneda(Moneda moneda);

    @Delete
    void delete(Moneda moneda);

    @Query("DELETE FROM MONEDA")
    void deleteAllMonedas();

    @Query("SELECT * FROM MONEDA WHERE id = :id")
    Moneda findById(int id);

}
