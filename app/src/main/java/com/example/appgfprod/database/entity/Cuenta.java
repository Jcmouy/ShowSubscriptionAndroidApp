package com.example.appgfprod.database.entity;

import com.example.appgfprod.database.converter.DateConverter;

import org.threeten.bp.LocalDateTime;
import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "Cuenta")
public class Cuenta implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;

    @ColumnInfo(name = "codigo")
    @NonNull
    public String codigo;

    @ColumnInfo(name = "nombre")
    @NonNull
    public String nombre;

    @ColumnInfo(name = "fechaBaja")
    @TypeConverters({DateConverter.class})
    public LocalDateTime fechaBaja;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(@NonNull String codigo) {
        this.codigo = codigo;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public LocalDateTime getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(@NonNull LocalDateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
}
