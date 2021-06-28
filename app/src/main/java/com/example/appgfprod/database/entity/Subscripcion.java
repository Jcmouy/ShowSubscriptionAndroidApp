package com.example.appgfprod.database.entity;

import com.example.appgfprod.database.converter.DateConverter;
import com.example.appgfprod.database.converter.EnumConverter;
import com.example.appgfprod.dto.EnumMetodoPago;

import java.io.Serializable;
import java.time.Instant;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "Subscripcion")
public class Subscripcion implements Serializable {

    @PrimaryKey
    @NonNull
    public int id;

    @ColumnInfo(name = "fecha")
    @NonNull
    @TypeConverters({DateConverter.class})
    private Instant fecha;

    @ColumnInfo(name = "metodoPago")
    @NonNull
    @TypeConverters({EnumConverter.class})
    private EnumMetodoPago metodoPago;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(@NonNull Instant fecha) {
        this.fecha = fecha;
    }

    @NonNull
    public EnumMetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(@NonNull EnumMetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
