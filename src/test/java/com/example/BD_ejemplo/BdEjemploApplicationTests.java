package com.example.BD_ejemplo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.BD_ejemplo.model.Partida;
import com.example.BD_ejemplo.model.Usuario;
import com.example.BD_ejemplo.repository.FichaRepository;
import com.example.BD_ejemplo.repository.PartidaRepository;
import com.example.BD_ejemplo.repository.UsuarioRepository;

@SpringBootTest
class BdEjemploApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PartidaRepository partidaRepository;
	
	@Autowired
	private FichaRepository fichaRepository;

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

		// 3 partidas
		Partida p1 = new Partida();
		Partida p2 = new Partida();
		Partida p3 = new Partida();

		// Rellenamos los datos de partidas: usuario1 tendrá 2 partidas, usuario2 tendrá
		// 1 y usuario 3: 0
		/*p1.setTiempo(3000L);
		p2.setTiempo(4000L);
		p3.setTiempo(500L);
		p1.setVictoria(6);
		p2.setVictoria(4);
		p3.setVictoria(10);
		p1.setDerrota(3);
		p2.setDerrota(6);
		p3.setDerrota(4);
		p1.setProfit(35L);
		p2.setProfit(-35L);
		p3.setProfit(10L);*/
		
		//Se añaden usuarios a partidas
		p1.setUsuario(usuario1);
		p2.setUsuario(usuario1);
		p3.setUsuario(usuario2);

		//Se añaden las partidas a los usuarios
		usuario1.getPartidas().add(p1);
		usuario1.getPartidas().add(p2);
		usuario2.getPartidas().add(p3);

		// Creamos los usuarios
		usuario1 = usuarioRepository.save(usuario1);
		usuario2 = usuarioRepository.save(usuario2);
		usuario3 = usuarioRepository.save(usuario3);
		
		//Creamos las direcciones
		p1=partidaRepository.save(p1);
		p2=partidaRepository.save(p2);
		p3=partidaRepository.save(p3);
		
		
		// Ver los usuarios en la base de datos
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		System.out.println("Número de usuarios: "+usuarios.size());
		Iterator it = usuarios.iterator();
		while (it.hasNext()) {
			Usuario aux = (Usuario) it.next();
			System.out.println(aux.toString());
		}
		
		//Mostrar todas las partidas
		List<Partida> partidas = (List<Partida>) partidaRepository.findAll();
		System.out.println("Número de partidas: "+partidas.size());
		Iterator it2 = partidas.iterator();
		while (it2.hasNext()) {
			Partida aux = (Partida) it2.next();
			System.out.println(aux.toString());
		}
		
		//Mostrar las partidas por idUsuario
		System.out.println("MOSTRAMOS PARTIDAS POR ID------------");
		System.out.println("Id usuario1: "+usuario2.getIdUsuario());
		List<Partida> partidasUsuario1 = partidaRepository.findPartidasByUserId(usuario2.getIdUsuario());
		System.out.println("Número de partidas de "+usuario2.getNombre()+" : "+partidasUsuario1.size());
		for (Partida partida : partidasUsuario1) {
		    System.out.println(partida.toString());
		}

		System.out.println("------------BORRAMOS USUARIO 2-------------");
		usuarioRepository.delete(usuario2);
		//Mostrar las partidas por idUsuario
		System.out.println("MOSTRAMOS PARTIDAS POR ID------------");
		System.out.println("Id usuario1: "+usuario2.getIdUsuario());
		List<Partida> partidasUsuario2 = partidaRepository.findPartidasByUserId(usuario2.getIdUsuario());
		System.out.println("Número de partidas de "+usuario2.getNombre()+" : "+partidasUsuario2.size());
		for (Partida partida : partidasUsuario2) {
		    System.out.println(partida.toString());
		}
		
		// Ver los usuarios en la base de datos
		List<Usuario> usuarios2 = (List<Usuario>) usuarioRepository.findAll();
		System.out.println("Número de usuarios: "+usuarios2.size());
		Iterator it11 = usuarios2.iterator();
		while (it11.hasNext()) {
			Usuario aux = (Usuario) it11.next();
			System.out.println(aux.toString());
		}
	}

}
