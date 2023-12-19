package com.example.BD_ejemplo.service;

import java.util.List;

import com.example.BD_ejemplo.model.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findUsuarios();
	
	public Usuario crearUsuario(Usuario u);
	
    public Usuario findUsuarioByNombreYContrasena(String nombre, String contrasena);
    
    public Usuario chequearLogin(String nombre, String contra);
}
