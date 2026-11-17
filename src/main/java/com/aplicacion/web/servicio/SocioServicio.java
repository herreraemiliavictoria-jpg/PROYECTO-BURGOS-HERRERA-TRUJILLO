/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.web.servicio;

import com.aplicacion.web.modelo.dominio.Socio;
import com.aplicacion.web.repositorio.SocioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocioServicio {

    @Autowired
    private SocioRepositorio socioRepositorio;

    // Método que utiliza el @Query del repositorio
    public List<Socio> buscarPorApellido(String apellido) {
        return socioRepositorio.buscarPorApellido(apellido);
    }

    // Opcional: Usando Streams para filtrar además por estado activo
    public List<Socio> buscarActivosPorApellido(String apellido) {
        List<Socio> socios = socioRepositorio.buscarPorApellido(apellido);
        
        return socios.stream()
                     .filter(Socio::isActivo)
                     .collect(Collectors.toList());
    }
}