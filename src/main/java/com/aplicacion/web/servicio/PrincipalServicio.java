package com.aplicacion.web.servicio;

import com.aplicacion.web.modelo.dominio.Membresia;
import com.aplicacion.web.modelo.dominio.Socio;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PrincipalServicio {
    public List<Socio> listarSocios();
    public Page<Socio> listarSociosPaginados(Pageable pageable);
    public List<Socio> filtrarSocios(String apellido, Long membresiaId);
    public Socio guardarSocio(Socio socio);
    public List<Socio> buscarSocioPorApellido(String apellido);
    
    // Asegúrate de que esté escrito exactamente así (en plural):
    public List<Membresia> listarMembresias();
}