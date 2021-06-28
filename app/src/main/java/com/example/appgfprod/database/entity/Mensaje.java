package com.example.appgfprod.database.entity;

import com.example.appgfprod.database.converter.DateConverter;

import org.threeten.bp.LocalDateTime;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "Mensaje")
public class Mensaje implements Serializable {

    @PrimaryKey
    @NonNull
    public int id;

    @ColumnInfo(name = "remitente")
    @NonNull
    public String remitente;

    @ColumnInfo(name = "destinatario")
    @NonNull
    public String destinatario;

    @ColumnInfo(name = "fecha")
    @NonNull
    @TypeConverters({DateConverter.class})
    public LocalDateTime fecha;

    @ColumnInfo(name = "tipoContenido")
    @NonNull
    public String tipoContenido;

    @ColumnInfo(name = "valor")
    @NonNull
    public String valor;

    @ColumnInfo(name = "resumen")
    @NonNull
    public String resumen;

    @ColumnInfo(name = "obraNombre")
    @NonNull
    public String obraNombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(@NonNull String remitente) {
        this.remitente = remitente;
    }

    @NonNull
    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(@NonNull String destinatario) {
        this.destinatario = destinatario;
    }

    @NonNull
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(@NonNull LocalDateTime fecha) {
        this.fecha = fecha;
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

    @NonNull
    public String getObraNombre() {
        return obraNombre;
    }

    public void setObraNombre(@NonNull String obraNombre) {
        this.obraNombre = obraNombre;
    }
}
