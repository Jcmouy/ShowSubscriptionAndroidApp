package com.example.appgfprod.database.entity;

import com.example.appgfprod.database.converter.DateConverter;

import org.threeten.bp.LocalDateTime;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "Obra",
        foreignKeys = {@ForeignKey(entity = TipoDeObra.class,
                        parentColumns = "id",
                        childColumns = "tipoDeObra_id"),
                        @ForeignKey(entity = Pais.class,
                        parentColumns = "id",
                        childColumns = "pais_id")})
public class Obra implements Serializable {

    @PrimaryKey
    @NonNull
    public int id;

    @ColumnInfo(name = "nombre")
    @NonNull
    public String nombre;

    @ColumnInfo(name = "descripcion")
    @NonNull
    public String descripcion;

    @ColumnInfo(name = "imagen")
    public int imagen;

    @ColumnInfo(name = "icono")
    public int icono;

    @ColumnInfo(name = "protagonistas")
    @NonNull
    public String protagonistas;

    @ColumnInfo(name = "direccion")
    @NonNull
    public String direccion;

    @ColumnInfo(name = "autores")
    @NonNull
    public String autores;

    @ColumnInfo(name = "fecha")
    @NonNull
    @TypeConverters({DateConverter.class})
    public LocalDateTime fecha;

    @ColumnInfo(name = "duracion")
    @NonNull
    public String duracion;

    @ColumnInfo(name = "tipoDeObra_id")
    @NonNull
    public String tipoDeObraId;

    @ColumnInfo(name = "pais_id")
    @NonNull
    public String paisId;

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

    @NonNull
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NonNull String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    @NonNull
    public String getProtagonistas() {
        return protagonistas;
    }

    public void setProtagonistas(@NonNull String protagonistas) {
        this.protagonistas = protagonistas;
    }

    @NonNull
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NonNull String direccion) {
        this.direccion = direccion;
    }

    @NonNull
    public String getAutores() {
        return autores;
    }

    public void setAutores(@NonNull String autores) {
        this.autores = autores;
    }

    @NonNull
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(@NonNull LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @NonNull
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(@NonNull String duracion) {
        this.duracion = duracion;
    }

    @NonNull
    public String getTipoDeObraId() {
        return tipoDeObraId;
    }

    public void setTipoDeObraId(@NonNull String tipoDeObraId) {
        this.tipoDeObraId = tipoDeObraId;
    }

    @NonNull
    public String getPaisId() {
        return paisId;
    }

    public void setPaisId(@NonNull String paisId) {
        this.paisId = paisId;
    }
}
