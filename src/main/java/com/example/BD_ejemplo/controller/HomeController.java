package com.example.BD_ejemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.BD_ejemplo.model.Usuario;
import com.example.BD_ejemplo.service.UsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listarUsuarios")
	public String ListarUsuario(Model model) {
		
		List<Usuario> usuarios = usuarioService.findUsuarios();
		model.addAttribute("usuarios", usuarios);
		
		return "listarUsuario";
	}
	/*@GetMapping("/")
	public String holaPage(Model model) {
		String texto ="Hola mundo en ejecución";
		model.addAttribute("Bienvenida", texto);
		
		return "index";
	}*/
	public String index() {		
        return "redirect:/index";
    }

	

}
