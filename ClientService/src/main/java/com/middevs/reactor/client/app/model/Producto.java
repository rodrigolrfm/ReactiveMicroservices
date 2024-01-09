package com.middevs.reactor.client.app.model;

import java.util.Date;

public class Producto {

    private String id;

    private String nombre;

    private Double precio;

    private String marca;

    private Date tiempoCreacion;


    public Producto() {
    }

    public Producto(String nombre, Double precio, String marca) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getTiempoCreacion() {
        return tiempoCreacion;
    }

    public void setTiempoCreacion(Date tiempoCreacion) {
        this.tiempoCreacion = tiempoCreacion;
    }
}
