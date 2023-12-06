package com.example.BD_ejemplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BD_ejemplo.model.Usuario;
import com.example.BD_ejemplo.service.UsuarioService;


@Controller
public class UsuarioController {

	private UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioController usuarioService) {
		super();
		this.usuarioService =  (UsuarioService) usuarioService;		
	}
	
	@GetMapping("/registro")
    public String showAddUsuarioForm(Usuario usuario) {    	
    	System.out.println("\t UsuarioController::showAddUsuarioForm");    	
        return "registro";
    }
	@PostMapping("/addUsuario")
	public String addUsuario(Usuario usuario, Model model){
    	System.out.println("\t UsuarioController::addUsuario");    	    	
    	///logica de validacion de usuarios, email correcto, repetido o no?, nombre usuario repetido, formato....
    	// 
    	//  Esquema común: 
    	//		Si hay errores entonces 		
    	//			devolver la misma vista;
    	//Yo no escribo la logica de control de errores. Sorry :(. 
    	//Pista: Spring y Thymeleaf proporcionan formas de validar datos...

    	//le pedimos al servicio que nos cree un usuario    	
        model.addAttribute("usuarios", usuarioService.crearUsuario(usuario)); //no es estrictamente necesario añadir el atributo al model aquí.  	

        return "redirect:/index.html"; //se registra OK, se redirecciona a la página principal.  
    }
	
}
