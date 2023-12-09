package com.example.BD_ejemplo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.BD_ejemplo.model.Tablero;

@Controller
public class TableroController {

    @GetMapping("/tablero")
    public String mostrarTablero(Model model) {
        
        Tablero tablero = new Tablero();
        tablero.inicializarMatriz();

        model.addAttribute("tablero", tablero);

        // Devolver el nombre de la vista Thymeleaf
        return "tablero";
    }
}
