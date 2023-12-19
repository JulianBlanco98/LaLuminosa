package com.example.BD_ejemplo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BD_ejemplo.model.Usuario;
import com.example.BD_ejemplo.repository.PartidaRepository;
import com.example.BD_ejemplo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findUsuarios() {

		return (List<Usuario>) usuarioRepository.findAll();

	}

	@Override
	public Usuario crearUsuario(Usuario u) {
		// TODO Auto-generated method stub
		System.out.println("Nombre usuario: " + u.getNombre());
		Usuario aux = usuarioRepository.encontrarPorNombre(u.getNombre());

		if (aux != null) {
			System.out.println("Entra aqui...");
			return null;
		} else {
			u.setDinero(1000L); // añade 1000 euros de saldo inicial
			usuarioRepository.save(u);
			System.out.println("Guarda el usuario: " + u.getNombre());
			return u;
		}
	}

	@Override
	public Usuario findUsuarioByNombreYContrasena(String nombre, String contrasena) {
		// Implementation for finding a user by name and password
		return usuarioRepository.findByNombreAndContra(nombre, contrasena);
	}

	@Override
	public Usuario chequearLogin(String nombre, String contra) {
		// TODO Auto-generated method stub
		return usuarioRepository.chequearLogin(nombre, contra);
	}

}
