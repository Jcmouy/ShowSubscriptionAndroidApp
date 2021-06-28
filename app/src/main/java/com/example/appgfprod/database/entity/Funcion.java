package com.example.appgfprod.database.entity;

import com.example.appgfprod.database.converter.DateConverter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "Funcion",
        foreignKeys = {@ForeignKey(entity = Moneda.class,
                parentColumns = "id",
                childColumns = "moneda_id"),
                @ForeignKey(entity = Pais.class,
                        parentColumns = "id",
                        childColumns = "pais_id")})
public class Funcion implements Serializable {

    @PrimaryKey
    @NonNull
    public int id;

    @ColumnInfo(name = "fecha")
    @NonNull
    @TypeConverters({DateConverter.class})
    private LocalDateTime fecha;

    @ColumnInfo(name = "precio")
    @NonNull
    private BigDecimal precio;

    @ColumnInfo(name = "moneda_id")
    @NonNull
    private int monedaId;

    @ColumnInfo(name = "pais_id")
    @NonNull
    private int paisId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(@NonNull LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @NonNull
    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(@NonNull BigDecimal precio) {
        this.precio = precio;
    }

    public int getMonedaId() {
        return monedaId;
    }

    public void setMonedaId(int monedaId) {
        this.monedaId = monedaId;
    }

    public int getPaisId() {
        return paisId;
    }

    public void setPaisId(int paisId) {
        this.paisId = paisId;
    }
}
