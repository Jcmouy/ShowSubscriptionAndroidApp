package com.example.appgfprod.database.dao;

import com.example.appgfprod.database.entity.Pago;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PagoDao {

    @Query("SELECT * FROM PAGO")
    boolean checkPagos();

    @Query("SELECT * FROM PAGO ORDER BY ID")
    List<Pago> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPago(Pago pago);

    @Update
    void updatePago(Pago pago);

    @Delete
    void delete(Pago pago);

    @Query("DELETE FROM PAGO")
    void deleteAllPagos();

    @Query("SELECT * FROM PAGO WHERE id = :id")
    Pago findById(int id);

}
