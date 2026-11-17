package com.aplicacion.web.servicio;

import com.aplicacion.web.modelo.dominio.Membresia;
import com.aplicacion.web.modelo.dominio.Socio;
import com.aplicacion.web.repositorio.MembresiaRepositorio;
import com.aplicacion.web.repositorio.SocioRepositorio;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PrincipalServicioImpl implements PrincipalServicio {

    @Autowired
    private SocioRepositorio socioRepositorio;

    @Autowired
    private MembresiaRepositorio membresiaRepositorio;

    @Override
    public List<Socio> listarSocios() {
        return socioRepositorio.findAll();
    }

    @Override
    public Page<Socio> listarSociosPaginados(Pageable pageable) {
        return socioRepositorio.findAll(pageable);
    }

    @Override
    public List<Socio> filtrarSocios(String apellido, Long membresiaId) {
        return socioRepositorio.findAll().stream()
                .filter(s -> apellido == null || apellido.isBlank() || 
                             s.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                .filter(s -> membresiaId == null || 
                             (s.getMembresia() != null && s.getMembresia().getId().equals(membresiaId)))
                .collect(Collectors.toList());
    }

    @Override
    public Socio guardarSocio(Socio socio) {
        return socioRepositorio.save(socio);
    }

    @Override
    public List<Socio> buscarSocioPorApellido(String apellido) {
        return socioRepositorio.buscarPorApellido(apellido);
    }

    @Override
    public List<Membresia> listarMembresias() {
        return membresiaRepositorio.findAll();
    }
}