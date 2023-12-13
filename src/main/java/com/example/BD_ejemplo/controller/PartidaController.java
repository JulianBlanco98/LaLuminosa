package com.example.BD_ejemplo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/principal")
public class PartidaController {

	
	@PostMapping
    public String manejarSolicitud(@RequestParam("fichaValor") String fichaValor,
                                   @RequestParam("numeroFicha") String numeroFicha) {
        // Haz lo que necesites con las variables en el controlador
        System.out.println("Ficha Valor: " + fichaValor);
        System.out.println("Número Ficha: " + numeroFicha);

        // Devuelve la vista o redirige a otra página
        return "principal";
    }
	
}
