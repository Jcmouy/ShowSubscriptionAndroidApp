package com.example.appgfprod.dto;

import java.io.Serializable;

public class ContenidoDto implements Serializable {

    private int id;

    private String indice;

    private String subIndice;

    private String tipoContenido;

    private String valor;

    private String resumen;

    private ObraDto obra;

    public ContenidoDto() {
    }

    public ContenidoDto(int id, String indice, String subIndice, String tipoContenido, String valor, String resumen, ObraDto obra) {
        this.id = id;
        this.indice = indice;
        this.subIndice = subIndice;
        this.tipoContenido = tipoContenido;
        this.valor = valor;
        this.resumen = resumen;
        this.obra = obra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getSubIndice() {
        return subIndice;
    }

    public void setSubIndice(String subIndice) {
        this.subIndice = subIndice;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public ObraDto getObra() {
        return obra;
    }

    public void setObra(ObraDto obra) {
        this.obra = obra;
    }

    @Override
    public String toString() {
        return "ContenidoDto{" +
                "id=" + id +
                ", indice='" + indice + '\'' +
                ", subIndice='" + subIndice + '\'' +
                ", tipoContenido='" + tipoContenido + '\'' +
                ", valor='" + valor + '\'' +
                ", resumen='" + resumen + '\'' +
                ", obra=" + obra +
                '}';
    }
}
