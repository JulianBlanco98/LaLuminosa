package com.example.BD_ejemplo.service;

import java.util.List;

import com.example.BD_ejemplo.model.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findUsuarios();
	
	public Iterable<Usuario> crearUsuario(Usuario u);

}
