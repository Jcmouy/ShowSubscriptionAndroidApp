package com.example.appgfprod.database.entity;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Etiqueta",
        foreignKeys = {@ForeignKey(entity = Obra.class,
                parentColumns = "id",
                childColumns = "obra_id")})
public class Etiqueta implements Serializable {

    @PrimaryKey
    @NonNull
    public int id;

    @ColumnInfo(name = "nombre")
    @NonNull
    public String nombre;

    @ColumnInfo(name = "obra_id")
    @NonNull
    public int obraId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    public int getObraId() {
        return obraId;
    }

    public void setObraId(int obraId) {
        this.obraId = obraId;
    }
}
