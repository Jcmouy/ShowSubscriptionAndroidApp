package com.example.appgfprod.dto;

import org.threeten.bp.LocalDate;

import java.io.Serializable;

public class CuentaDto implements Serializable {

    private int id;

    private String codigo;

    private String nombre;

    private LocalDate fechaBaja;

    public CuentaDto() {
    }

    public CuentaDto(String codigo, String nombre ) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Override
    public String toString() {
        return "CuentaDto{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaBaja=" + fechaBaja +
                '}';
    }
}
