package com.aplicacion.web.repositorio;

import com.aplicacion.web.modelo.dominio.Socio;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepositorio extends JpaRepository<Socio, Long> {
    
    @Query("SELECT s FROM Socio s WHERE s.apellido LIKE %:apellido%")
    List<Socio> buscarPorApellido(@Param("apellido") String apellido);

    // Método paginado nativo de Spring Data JPA
    @Override
    Page<Socio> findAll(Pageable pageable);
}