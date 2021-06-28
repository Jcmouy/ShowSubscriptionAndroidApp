package com.example.appgfprod.database.entity;

import com.example.appgfprod.database.converter.DateConverter;

import java.io.Serializable;
import java.time.Instant;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "Pago",
        foreignKeys = {@ForeignKey(entity = Subscripcion.class,
                parentColumns = "id",
                childColumns = "subscripcion_id")})
public class Pago implements Serializable {

    @PrimaryKey
    @NonNull
    public int id;

    @ColumnInfo(name = "idExterno")
    @NonNull
    public String idExterno;

    @ColumnInfo(name = "fechaExterna")
    @NonNull
    @TypeConverters({DateConverter.class})
    public Instant fechaExterna;

    @ColumnInfo(name = "subscripcion_id")
    @NonNull
    public String subscripcionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(@NonNull String idExterno) {
        this.idExterno = idExterno;
    }

    @NonNull
    public Instant getFechaExterna() {
        return fechaExterna;
    }

    public void setFechaExterna(@NonNull Instant fechaExterna) {
        this.fechaExterna = fechaExterna;
    }

    @NonNull
    public String getSubscripcionId() {
        return subscripcionId;
    }

    public void setSubscripcionId(@NonNull String subscripcionId) {
        this.subscripcionId = subscripcionId;
    }
}
