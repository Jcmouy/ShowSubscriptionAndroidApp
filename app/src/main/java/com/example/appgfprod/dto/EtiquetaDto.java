package com.example.appgfprod.dto;

import java.io.Serializable;

public class EtiquetaDto implements Serializable {

    private int id;

    private String nombre;

    private ObraDto obra;

    public EtiquetaDto() {
    }

    public EtiquetaDto(int id, String nombre, ObraDto obra) {
        this.id = id;
        this.nombre = nombre;
        this.obra = obra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ObraDto getObra() {
        return obra;
    }

    public void setObra(ObraDto obra) {
        this.obra = obra;
    }

    @Override
    public String toString() {
        return "EtiquetaDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", obra=" + obra +
                '}';
    }
}
