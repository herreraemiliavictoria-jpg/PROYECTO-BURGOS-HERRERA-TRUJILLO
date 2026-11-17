package com.aplicacion.web.controlador;

import com.aplicacion.web.modelo.dominio.Socio;
import com.aplicacion.web.servicio.PrincipalServicio;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrincipalControlador {

    @Autowired
    private PrincipalServicio principalServicio;

    @GetMapping({"/", "/index"})
    public String inicio(Model model) {
        return "index";
    }

    @GetMapping("/nuevoSocio")
    public String crearSocio(Model modelo) {
        Socio socio = new Socio();
        modelo.addAttribute("socio", socio);
        modelo.addAttribute("membresias", principalServicio.listarMembresias());
        return "formularioSocio";
    }

    @PostMapping("/registrarSocio")
    public String registrarSocio(@ModelAttribute("socio") Socio socio) throws IOException {
        principalServicio.guardarSocio(socio);
        return "redirect:/nuevoSocio";
    }

    // Listar socios con paginación y filtros dinámicos
    @GetMapping("/mostrarSocios")
    public String listarSocios(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) String apellido,
            @RequestParam(required = false) Long membresiaId,
            Model modelo) {

        modelo.addAttribute("membresias", principalServicio.listarMembresias());
        modelo.addAttribute("apellidoFiltro", apellido);
        modelo.addAttribute("membresiaFiltro", membresiaId);

        // Si hay algún filtro activo, se filtran los resultados usando Streams en el servicio
        if ((apellido != null && !apellido.isBlank()) || membresiaId != null) {
            List<Socio> filtrados = principalServicio.filtrarSocios(apellido, membresiaId);
            modelo.addAttribute("socios", filtrados);
            modelo.addAttribute("paginado", false);
        } else {
            // Si no hay filtros, se segmenta de a 5 socios por página
            Pageable pageable = PageRequest.of(page, 5);
            Page<Socio> paginaSocios = principalServicio.listarSociosPaginados(pageable);

            modelo.addAttribute("socios", paginaSocios.getContent());
            modelo.addAttribute("paginaActual", page);
            modelo.addAttribute("totalPaginas", paginaSocios.getTotalPages());
            modelo.addAttribute("paginado", true);
        }

        return "listaSocios";
    }

    @GetMapping("/formularioBusquedaPorApellido")
    public String formularioBuscar(Model modelo) {
        modelo.addAttribute("apellido", "");
        return "formularioBusquedaPorApellido";
    }

    // Endpoint para buscar por apellido usando tu @Query
    @PostMapping("/buscarSociosPorApellido")
    public String buscarSocios(@RequestParam(value = "apellido") String apellido, Model modelo) {
        List<Socio> socios = principalServicio.buscarSocioPorApellido(apellido);
        modelo.addAttribute("membresias", principalServicio.listarMembresias());
        modelo.addAttribute("socios", socios);
        modelo.addAttribute("paginado", false);
        return "listaSocios";
    }
}