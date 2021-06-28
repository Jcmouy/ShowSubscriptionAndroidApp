package com.example.appgfprod.database.entity;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Contenido",
        foreignKeys = {@ForeignKey(entity = Obra.class,
                parentColumns = "id",
                childColumns = "obra_id")})
public class Contenido implements Serializable {

    @PrimaryKey
    @NonNull
    public int id;

    @ColumnInfo(name = "indice")
    @NonNull
    public String indice;

    @ColumnInfo(name = "subIndice")
    @NonNull
    public String subIndice;

    @ColumnInfo(name = "tipoContenido")
    @NonNull
    public String tipoContenido;

    @ColumnInfo(name = "valor")
    @NonNull
    public String valor;

    @ColumnInfo(name = "resumen")
    @NonNull
    public String resumen;

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
    public String getIndice() {
        return indice;
    }

    public void setIndice(@NonNull String indice) {
        this.indice = indice;
    }

    @NonNull
    public String getSubIndice() {
        return subIndice;
    }

    public void setSubIndice(@NonNull String subIndice) {
        this.subIndice = subIndice;
    }

    @NonNull
    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(@NonNull String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    @NonNull
    public String getValor() {
        return valor;
    }

    public void setValor(@NonNull String valor) {
        this.valor = valor;
    }

    @NonNull
    public String getResumen() {
        return resumen;
    }

    public void setResumen(@NonNull String resumen) {
        this.resumen = resumen;
    }

    public int getObraId() {
        return obraId;
    }

    public void setObraId(int obraId) {
        this.obraId = obraId;
    }
}
