package com.example.BD_ejemplo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BD_ejemplo.model.Usuario;
import com.example.BD_ejemplo.repository.UsuarioRepository;

public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> findUsuarios() {
		
		return (List<Usuario>) usuarioRepository.findAll();
		
		
		
	}

}
