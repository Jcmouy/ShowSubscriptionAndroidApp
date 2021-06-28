package com.example.appgfprod.dto;

import org.threeten.bp.LocalDateTime;

import java.io.Serializable;

public class MensajeDto implements Serializable {

    private int id;

    private String remitente;

    private String destinatario;

    private LocalDateTime fecha;

    private String tipoContenido;

    private String valor;

    private String resumen;

    private String obraNombre;

    public MensajeDto() {
    }

    public MensajeDto(int id, String remitente, String destinatario, LocalDateTime fecha, String tipoContenido, String valor, String resumen, String obraNombre) {
        this.id = id;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.fecha = fecha;
        this.tipoContenido = tipoContenido;
        this.valor = valor;
        this.resumen = resumen;
        this.obraNombre = obraNombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
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

    public String getObraNombre() {
        return obraNombre;
    }

    public void setObraNombre(String obraNombre) {
        this.obraNombre = obraNombre;
    }

    @Override
    public String toString() {
        return "MensajeDto{" +
                "id=" + id +
                ", remitente='" + remitente + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", fecha=" + fecha +
                ", tipoContenido='" + tipoContenido + '\'' +
                ", valor='" + valor + '\'' +
                ", resumen='" + resumen + '\'' +
                ", obraNombre='" + obraNombre + '\'' +
                '}';
    }
}
