package com.aplicacion.web.controlador;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ManejadorErroresControlador {
    @ExceptionHandler(NoResourceFoundException.class)
    public String manejarError404(NoResourceFoundException ex, Model model) {
        model.addAttribute("mensajeError", "Página no encontrada (Error 404)");
        model.addAttribute("detalle", "La dirección web que ingresaste no existe en el sistema del gimnasio.");
        return "error";
    }

    // Captura cualquier excepción general que ocurra en los controladores
    @ExceptionHandler(Exception.class)
    public String manejarErrorGeneral(Exception ex, Model model) {
        model.addAttribute("mensajeError", "Ocurrió un inconveniente inesperado al procesar la solicitud.");
        model.addAttribute("detalle", ex.getMessage());
        return "error"; 
    }
}