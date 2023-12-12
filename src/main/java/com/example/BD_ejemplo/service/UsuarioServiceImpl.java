package com.example.BD_ejemplo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BD_ejemplo.model.Usuario;
import com.example.BD_ejemplo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> findUsuarios() {
		
		return (List<Usuario>) usuarioRepository.findAll();
		
		
		
	}

	@Override
	public Iterable<Usuario> crearUsuario(Usuario u) {
		// TODO Auto-generated method stub
		
		u.setDinero(1000L); //añade 1000 euros de saldo inicial
		usuarioRepository.save(u);
		return findUsuarios();
	}
	
	@Override
    public Usuario findUsuarioByNombreYContrasena(String nombre, String contrasena) {
        // Implementation for finding a user by name and password
        return usuarioRepository.findByNombreAndContra(nombre, contrasena);
    }

}
