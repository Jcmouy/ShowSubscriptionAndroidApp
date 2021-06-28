package com.example.appgfprod.dto;

import java.io.Serializable;
import java.time.Instant;

public class SubscripcionDto implements Serializable {

    private int id;

    private Instant fecha;

    private EnumMetodoPago metodoPago;

    public SubscripcionDto() {
    }

    public SubscripcionDto(int id, Instant fecha, EnumMetodoPago metodoPago) {
        this.id = id;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public EnumMetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(EnumMetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "SubscripcionDto{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", metodoPago=" + metodoPago +
                '}';
    }
}
