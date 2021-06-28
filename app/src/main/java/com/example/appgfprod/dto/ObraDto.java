package com.example.appgfprod.dto;

import org.threeten.bp.LocalDateTime;

import java.io.Serializable;

public class ObraDto implements Serializable {

    private int id;

    private String nombre;

    private String descripcion;

    private int imagen;

    private int icono;

    private String protagonistas;

    private String direccion;

    private String autores;

    private LocalDateTime fecha;

    private String duracion;

    private TipoDeObraDto tipoDeObra;

    private PaisDto pais;

    public ObraDto() {
    }

    public ObraDto(int id, String nombre, String descripcion, int imagen, int icono, String protagonistas, String direccion, String autores, LocalDateTime fecha, String duracion, TipoDeObraDto tipoDeObra, PaisDto pais) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.icono = icono;
        this.protagonistas = protagonistas;
        this.direccion = direccion;
        this.autores = autores;
        this.fecha = fecha;
        this.duracion = duracion;
        this.tipoDeObra = tipoDeObra;
        this.pais = pais;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
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

    public String getProtagonistas() {
        return protagonistas;
    }

    public void setProtagonistas(String protagonistas) {
        this.protagonistas = protagonistas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public TipoDeObraDto getTipoDeObra() {
        return tipoDeObra;
    }

    public void setTipoDeObra(TipoDeObraDto tipoDeObra) {
        this.tipoDeObra = tipoDeObra;
    }

    public PaisDto getPais() {
        return pais;
    }

    public void setPais(PaisDto pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "ObraDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen=" + imagen +
                ", icono=" + icono +
                ", protagonistas='" + protagonistas + '\'' +
                ", direccion='" + direccion + '\'' +
                ", autores='" + autores + '\'' +
                ", fecha=" + fecha +
                ", duracion='" + duracion + '\'' +
                ", tipoDeObra=" + tipoDeObra +
                ", pais=" + pais +
                '}';
    }
}
