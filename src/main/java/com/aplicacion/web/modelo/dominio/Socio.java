
package com.aplicacion.web.modelo.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



/**
 *
 * @author 
 */
@Entity
@Table(name="socios")
public class Socio
{
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String apellido;
    private String dni;
    private boolean activo;

    // Relación con Membresía (Cumple con el requisito de relaciones entre entidades)
    @ManyToOne
    @JoinColumn(name = "membresia_id")
    private Membresia membresia;

    public Socio() {}
    
    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isActivo() {
        return activo;
    }

    // Getters y Setters
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Membresia getMembresia() {
        return membresia;
    }
    public void setMembresia(Membresia membresia) { 
        this.membresia = membresia; 
    }
}
