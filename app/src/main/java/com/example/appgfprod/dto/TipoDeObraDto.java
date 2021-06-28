package com.example.appgfprod.dto;

import java.io.Serializable;

public class TipoDeObraDto implements Serializable {

    private int id;

    private EnumTipoDeObra tipo;

    private String descripcion;

    public TipoDeObraDto() {
    }

    public TipoDeObraDto(int id, EnumTipoDeObra tipo, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnumTipoDeObra getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoDeObra tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoDeObraDto{" +
                "id=" + id +
                ", tipo=" + tipo +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
