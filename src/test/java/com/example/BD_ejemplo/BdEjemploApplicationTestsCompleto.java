package com.example.BD_ejemplo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.BD_ejemplo.model.Ficha;
import com.example.BD_ejemplo.model.Partida;
import com.example.BD_ejemplo.model.Tirada;
import com.example.BD_ejemplo.model.Usuario;
import com.example.BD_ejemplo.repository.FichaRepository;
import com.example.BD_ejemplo.repository.PartidaRepository;
import com.example.BD_ejemplo.repository.TiradaRepository;
import com.example.BD_ejemplo.repository.UsuarioRepository;

@SpringBootTest
class BdEjemploApplicationTestsCompleto {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PartidaRepository partidaRepository;

	@Autowired
	private TiradaRepository tiradaRepository;

	@Autowired
	private FichaRepository fichaRepository;

	@Test
	void contextLoads() {

		Scanner in = new Scanner(System.in);

		System.out.println("----------------EMPIEZAN LOS TEST COMPLETOS----------------");

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

		// Se añaden usuarios a partidas
		p1.setUsuario(usuario1);
		p2.setUsuario(usuario1);
		p3.setUsuario(usuario2);

		// Se añaden las partidas a los usuarios
		usuario1.getPartidas().add(p1);
		usuario1.getPartidas().add(p2);
		usuario2.getPartidas().add(p3);

		// Creamos los usuarios
		usuario1 = usuarioRepository.save(usuario1);
		usuario2 = usuarioRepository.save(usuario2);
		usuario3 = usuarioRepository.save(usuario3);

		// creamos las fichas: siempre van a ser las mismas
		Ficha f1 = new Ficha();
		Ficha f2 = new Ficha();
		Ficha f3 = new Ficha();
		Ficha f4 = new Ficha();
		Ficha f5 = new Ficha();
		Ficha f6 = new Ficha();

		// le damos los valores
		f1.setValor(1);
		f2.setValor(5);
		f3.setValor(10);
		f4.setValor(20);
		f5.setValor(50);
		f6.setValor(100);

		// creamos 2 tiradas
		Tirada t1 = new Tirada();
		Tirada t2 = new Tirada();
		Tirada t3 = new Tirada();

		// asignamos valores a los atributos de tirada
//		t1.setApuesta(70L);
//		t1.setGanado(1); // boolean
//		t1.setProfit(70L);
//		t2.setApuesta(110L);
//		t2.setGanado(0); // boolean
//		t2.setProfit(-110L);
//		t2.setApuesta(130L);
//		t2.setGanado(0); // boolean
//		t2.setProfit(-20L);

		// se añaden las fichas a tiradas dependiendo de la apuesta
//		f1.setTirada(t1);
//		f2.setTirada(t1);
////		f3.setTirada(t1);
//		f4.setTirada(t1);
//		f5.setTirada(t1);
////		f6.setTirada(t1);
////		f1.setTirada(t2);
////		f2.setTirada(t2);
//		f3.setTirada(t2);
////		f4.setTirada(t2);
////		f5.setTirada(t2);
//		f6.setTirada(t2);

//		// se añaden las fichas
//		t1.getnFichas().add(f1);
//		t1.getnFichas().add(f2);
//		t1.getnFichas().add(f3);
//		t1.getnFichas().add(f4);
//		t1.getnFichas().add(f5);
//		t1.getnFichas().add(f6);
//		t2.getnFichas().add(f1);
//		t2.getnFichas().add(f2);
//		t2.getnFichas().add(f3);
//		t2.getnFichas().add(f4);
//		t2.getnFichas().add(f5);
//		t2.getnFichas().add(f6);

		t1.setPartida(p1);
		t2.setPartida(p1);
		t3.setPartida(p2);

		p1.getTiradas().add(t1);
		p1.getTiradas().add(t2);
		p2.getTiradas().add(t3);

		// Creamos las direcciones
		p1 = partidaRepository.save(p1);
		p2 = partidaRepository.save(p2);
		p3 = partidaRepository.save(p3);

		// Creamos las tiradas
		t1 = tiradaRepository.save(t1);
		t2 = tiradaRepository.save(t2);
		t3 = tiradaRepository.save(t3);

		// Creamos las fichas
		f1 = fichaRepository.save(f1);
		f2 = fichaRepository.save(f2);
		f3 = fichaRepository.save(f3);
		f4 = fichaRepository.save(f4);
		f5 = fichaRepository.save(f5);
		f6 = fichaRepository.save(f6);

		// Ver los usuarios en la base de datos
		System.out.println("---------USUARIOS--------");
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		System.out.println("Número de usuarios: " + usuarios.size());
		Iterator it = usuarios.iterator();
		while (it.hasNext()) {
			Usuario aux = (Usuario) it.next();
			System.out.println(aux.toString());
		}

		// Mostrar todas las partidas
		System.out.println("--------PARTIDAS--------");
		List<Partida> partidas = (List<Partida>) partidaRepository.findAll();
		System.out.println("Número de partidas: " + partidas.size());
		Iterator it2 = partidas.iterator();
		while (it2.hasNext()) {
			Partida aux = (Partida) it2.next();
			System.out.println(aux.toString());
		}

		// Ver las tiradas en la base de datos
		System.out.println("-------TIRADAS-----------");
		List<Tirada> listaTiradas = (List<Tirada>) tiradaRepository.findAll();
		System.out.println("Número de tiradas: " + listaTiradas.size());
		Iterator it3 = listaTiradas.iterator();
		while (it3.hasNext()) {
			Tirada aux = (Tirada) it3.next();
			System.out.println(aux.toString());
		}

		// Mostrar las partidas por idUsuario
		System.out.println("----------PARTIDA POR ID DE USUARIO-----------");
		System.out.println("Id usuario1: " + usuario1.getIdUsuario());
		List<Partida> partidasUsuario1 = partidaRepository.findPartidasByUserId(usuario1.getIdUsuario());
		System.out.println("Número de partidas de " + usuario1.getNombre() + " : " + partidasUsuario1.size());
		for (Partida partida : partidasUsuario1) {
			System.out.println(partida.toString());
		}

		// Mostrar tiradas por id de Partida
		System.out.println("-----------TIRADA POR ID DE PARTIDA----------");
		List<Tirada> tiradasPartidas = tiradaRepository.findTiradasByPartidaId(p1.getIdPartida());
		System.out.println("Número de tiradas de : " + tiradasPartidas.size());
		Iterator it5 = tiradasPartidas.iterator();
		while (it5.hasNext()) {
			Tirada aux = (Tirada) it5.next();
			System.out.println(aux.toString());
		}

		// Mostrar tiradas por id de Usuario
		System.out.println("-----------TIRADA POR ID DE USUARIO----------");
		List<Tirada> tiradasUsuario = tiradaRepository.findTiradasByUsuarioId(usuario1.getIdUsuario());
		Iterator it6 = tiradasUsuario.iterator();
		while (it6.hasNext()) {
			Tirada aux = (Tirada) it6.next();
			System.out.println(aux.toString());
		}

		usuarioRepository.delete(usuario1);
		System.out.println("---------------BORRAMOS EL USUARIO 1------------");
		// Ver los usuarios en la base de datos
		System.out.println("---------USUARIOS--------");
		List<Usuario> usuarios2 = (List<Usuario>) usuarioRepository.findAll();
		System.out.println("Número de usuarios: " + usuarios2.size());
		Iterator it1 = usuarios2.iterator();
		while (it1.hasNext()) {
			Usuario aux = (Usuario) it1.next();
			System.out.println(aux.toString());
		}
		// Mostrar todas las partidas
		System.out.println("--------PARTIDAS--------");
		List<Partida> partidas2 = (List<Partida>) partidaRepository.findAll();
		System.out.println("Número de partidas: " + partidas2.size());
		Iterator it21 = partidas2.iterator();
		while (it21.hasNext()) {
			Partida aux = (Partida) it21.next();
			System.out.println(aux.toString());
		}

		// Ver las tiradas en la base de datos
		System.out.println("-------TIRADAS-----------");
		List<Tirada> listaTiradas2 = (List<Tirada>) tiradaRepository.findAll();
		System.out.println("Número de tiradas: " + listaTiradas2.size());
		Iterator it31 = listaTiradas2.iterator();
		while (it31.hasNext()) {
			Tirada aux = (Tirada) it31.next();
			System.out.println(aux.toString());
		}

		// Ver las tiradas en la base de datos
		System.out.println("---------MOSTRAMOS LAS FICHAS-----------");
		// Ver las fichas en la base de datos
		List<Ficha> listaFichas = (List<Ficha>) fichaRepository.findAll();
		System.out.println("Número de fichas: " + listaFichas.size());
		Iterator ite = listaFichas.iterator();
		while (ite.hasNext()) {
			Ficha aux = (Ficha) ite.next();
			System.out.println(aux.toString());
		}
		
		
		

	}

}
