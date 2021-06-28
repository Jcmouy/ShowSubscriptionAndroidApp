package com.example.appgfprod.database.entity;

import com.example.appgfprod.database.converter.EnumConverter;
import com.example.appgfprod.dto.EnumTipoDeObra;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "TipoDeObra")
public class TipoDeObra implements Serializable {

    @PrimaryKey
    @NonNull
    public int id;

    @ColumnInfo(name = "tipo")
    @NonNull
    @TypeConverters({EnumConverter.class})
    public EnumTipoDeObra tipo;

    @ColumnInfo(name = "descripcion")
    @NonNull
    public String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public EnumTipoDeObra getTipo() {
        return tipo;
    }

    public void setTipo(@NonNull EnumTipoDeObra tipo) {
        this.tipo = tipo;
    }

    @NonNull
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NonNull String descripcion) {
        this.descripcion = descripcion;
    }
}
