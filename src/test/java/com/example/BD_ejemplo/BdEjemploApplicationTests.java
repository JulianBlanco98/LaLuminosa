package com.example.BD_ejemplo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.BD_ejemplo.model.Partida;
import com.example.BD_ejemplo.model.Usuario;
import com.example.BD_ejemplo.repository.PartidaRepository;
import com.example.BD_ejemplo.repository.UsuarioRepository;

@SpringBootTest
class BdEjemploApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PartidaRepository partidaRepository;

	@Test
	void contextLoads() {

		Scanner in = new Scanner(System.in);

		System.out.println("----------------EMPIEZAN LOS TEST----------------");

		// 3 usuarios nuevos
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		Usuario usuario3 = new Usuario();

		// Rellenamos sus datos
		usuario1.setNombre("Julian");
		usuario2.setNombre("Ignacio");
		usuario3.setNombre("Nicolas");
		usuario1.setEdad(24);
		usuario2.setEdad(21);
		usuario3.setEdad(22);
		usuario1.setContra("contra1");
		usuario2.setContra("contra2");
		usuario3.setContra("contra3");
		usuario1.setDinero(1000L);
		usuario2.setDinero(1000L);
		usuario3.setDinero(1000L);

		// Creamos los usuarios
		usuario1 = usuarioRepository.save(usuario1);
		usuario2 = usuarioRepository.save(usuario2);
		usuario3 = usuarioRepository.save(usuario3);

		//Ver los usuarios en la base de datos
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		Iterator it = usuarios.iterator();
		while (it.hasNext()) {
			Usuario aux = (Usuario) it.next();
			System.out.println(aux.toString());
		}
		
		//3 partidas
		Partida p1 = new Partida();
		Partida p2 = new Partida();
		Partida p3 = new Partida();
		
		

	}

}
