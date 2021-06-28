package com.example.appgfprod.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FuncionDto implements Serializable {

    private int id;

    private LocalDateTime fecha;

    private BigDecimal precio;

    private MonedaDto moneda;

    private PaisDto pais;

    public FuncionDto() {
    }

    public FuncionDto(int id, LocalDateTime fecha, BigDecimal precio, MonedaDto moneda, PaisDto pais) {
        this.id = id;
        this.fecha = fecha;
        this.precio = precio;
        this.moneda = moneda;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public MonedaDto getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaDto moneda) {
        this.moneda = moneda;
    }

    public PaisDto getPais() {
        return pais;
    }

    public void setPais(PaisDto pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "FuncionDto{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", precio=" + precio +
                ", moneda=" + moneda +
                ", pais=" + pais +
                '}';
    }
}
