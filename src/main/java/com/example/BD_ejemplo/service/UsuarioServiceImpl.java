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
		
		usuarioRepository.save(u);
		return findUsuarios();
	}

}
