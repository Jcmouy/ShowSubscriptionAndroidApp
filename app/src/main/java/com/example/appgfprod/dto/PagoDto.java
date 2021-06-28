package com.example.appgfprod.dto;

import java.io.Serializable;
import java.time.Instant;

public class PagoDto implements Serializable {

    private int id;

    private String idExterno;

    private Instant fechaExterna;

    private SubscripcionDto subscripcion;

    public PagoDto() {
    }

    public PagoDto(int id, String idExterno, Instant fechaExterna, SubscripcionDto subscripcion) {
        this.id = id;
        this.idExterno = idExterno;
        this.fechaExterna = fechaExterna;
        this.subscripcion = subscripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
    }

    public Instant getFechaExterna() {
        return fechaExterna;
    }

    public void setFechaExterna(Instant fechaExterna) {
        this.fechaExterna = fechaExterna;
    }

    public SubscripcionDto getSubscripcion() {
        return subscripcion;
    }

    public void setSubscripcion(SubscripcionDto subscripcion) {
        this.subscripcion = subscripcion;
    }

    @Override
    public String toString() {
        return "PagoDto{" +
                "id=" + id +
                ", idExterno='" + idExterno + '\'' +
                ", fechaExterna=" + fechaExterna +
                ", subscripcion=" + subscripcion +
                '}';
    }
}
