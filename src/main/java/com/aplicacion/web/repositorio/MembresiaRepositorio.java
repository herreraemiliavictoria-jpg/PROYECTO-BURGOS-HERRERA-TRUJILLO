package com.aplicacion.web.repositorio;

import com.aplicacion.web.modelo.dominio.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresiaRepositorio extends JpaRepository<Membresia, Long> {
    // Hereda automáticamente métodos como findAll(), findById(), save(), etc.
}