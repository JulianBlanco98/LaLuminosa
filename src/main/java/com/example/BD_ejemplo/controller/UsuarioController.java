package com.example.BD_ejemplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.BD_ejemplo.service.UsuarioService;

@Controller
public class UsuarioController {

	private UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioController usuarioService) {
		super();
		this.usuarioService =  (UsuarioService) usuarioService;		
	}
	
	
}
