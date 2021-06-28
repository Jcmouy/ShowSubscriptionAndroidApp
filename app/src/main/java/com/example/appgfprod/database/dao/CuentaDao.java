package com.example.appgfprod.database.dao;

import com.example.appgfprod.database.entity.Cuenta;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CuentaDao {

    @Query("SELECT * FROM CUENTA")
    boolean checkCuentas();

    @Query("SELECT * FROM CUENTA ORDER BY ID")
    List<Cuenta> getAll();

    @Query("SELECT ID FROM CUENTA ORDER BY ID DESC LIMIT 1")
    int getLastInsertedIdCuenta();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertCuenta(Cuenta cuenta);

    @Update
    void updateCuenta(Cuenta cuenta);

    @Delete
    void delete(Cuenta cuenta);

    @Query("DELETE FROM CUENTA")
    void deleteAllCuentas();

    @Query("SELECT * FROM CUENTA WHERE id = :id")
    Cuenta findById(int id);

}
