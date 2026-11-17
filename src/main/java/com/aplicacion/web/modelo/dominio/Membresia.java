package com.aplicacion.web.modelo.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "membresias")
public class Membresia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Equivalente a idPlan (PK)
    
    private String tipo;          // O puedes renombrarlo a 'nombre' (ej: Pase Libre, Musculación)
    private String descripcion;   // Descripción del plan
    private double costo;         // Equivalente a precio
    private int duracionDias;     // Duración en días (ej: 30)
    private int cantidadActPer;   // Cantidad de actividades permitidas por semana/mes
    private boolean estado;       // true = activo, false = inactivo

    public Membresia() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public int getCantidadActPer() {
        return cantidadActPer;
    }

    public void setCantidadActPer(int cantidadActPer) {
        this.cantidadActPer = cantidadActPer;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}