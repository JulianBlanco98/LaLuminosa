package com.example.BD_ejemplo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String holaPage(Model model) {
		String texto ="Hola mundo en ejecución";
		model.addAttribute("Bienvenida", texto);
		
		return "index";
	}
	
	@GetMapping("/Usuario/listarUsuarios")
	public String ListarUsuario(Model model) {
		
		List<Usuario> usuarios = 
		
		
		return "listarUsuario";
	}

}
