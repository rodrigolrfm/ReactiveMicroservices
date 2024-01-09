package com.middevs.reactor.spring.app.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;


@Document(collection="productos")
public class Producto {

    @Id
    private String id;

    private String nombre;

    private Double precio;

    private String marca;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", tiempoCreacion=" + tiempoCreacion +
                '}';
    }
}
