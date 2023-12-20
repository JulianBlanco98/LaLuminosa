package com.example.BD_ejemplo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.BD_ejemplo.model.Partida;
import com.example.BD_ejemplo.model.Tirada;
import com.example.BD_ejemplo.model.Usuario;
import com.example.BD_ejemplo.repository.FichaRepository;
import com.example.BD_ejemplo.repository.PartidaRepository;
import com.example.BD_ejemplo.repository.TiradaRepository;
import com.example.BD_ejemplo.repository.UsuarioRepository;

@SpringBootTest
class BdEjemploApplicationTestsPartidaTirada {

	@Autowired
	private TiradaRepository tiradaRepository;

	@Autowired
	private PartidaRepository partidaRepository;
	


	@Test
	void contextLoads() {

		Scanner in = new Scanner(System.in);

		System.out.println("----------------EMPIEZAN LOS TEST partida tirada----------------");



		// 3 partidas
		Partida p1 = new Partida();
		Partida p2 = new Partida();
		Partida p3 = new Partida();

		// Rellenamos los datos de partidas: usuario1 tendrá 2 partidas, usuario2 tendrá
		// 1 y usuario 3: 0
		/*p1.setTiempo(3000L);
		p2.setTiempo(4000L);
		p3.setTiempo(500L);*/
		p1.setVictoria(6);
		p2.setVictoria(4);
		p3.setVictoria(10);
		p1.setDerrota(3);
		p2.setDerrota(6);
		p3.setDerrota(4);
		/*p1.setProfit(35L);
		p2.setProfit(-35L);
		p3.setProfit(10L);*/
		
		//creamos 2 tiradas
		Tirada t1 = new Tirada();
		Tirada t2 = new Tirada();

		//asignamos valores a los atributos de tirada
		t1.setApuesta(70L);
//		t1.setGanado(1); //boolean
		t1.setProfit(70L);
		t2.setApuesta(110L);
//		t2.setGanado(0); //boolean
		t2.setProfit(-110L);
		
		t1.setPartida(p1);
		t2.setPartida(p1);
		
		p1.getTiradas().add(t1);
		p1.getTiradas().add(t2);
	
			
		//Creamos las direcciones
		p1=partidaRepository.save(p1);
		p2=partidaRepository.save(p2);
		p3=partidaRepository.save(p3);
		
		//Creamos las tiradas
		t1=tiradaRepository.save(t1);
		t2=tiradaRepository.save(t2);
		
		
		
		//Ver las tiradas en la base de datos
		List<Tirada> listaTiradas = (List<Tirada>) tiradaRepository.findAll();
		System.out.println("Número de tiradas: "+listaTiradas.size());
		Iterator it2 = listaTiradas.iterator();
		while(it2.hasNext()) {
			Tirada aux = (Tirada)it2.next();
			System.out.println(aux.toString());
		}
		
		//Mostrar todas las partidas
		List<Partida> partidas = (List<Partida>) partidaRepository.findAll();
		System.out.println("Número de partidas: "+partidas.size());
		Iterator it = partidas.iterator();
		while (it.hasNext()) {
			Partida aux = (Partida) it.next();
			System.out.println(aux.toString());
		}
		
		//Mostrar tiradas por id de Partida
		List<Tirada> tiradasPartidas = tiradaRepository.findTiradasByPartidaId(p1.getIdPartida());
		System.out.println("Número de tiradas de : "+tiradasPartidas.size());
		Iterator it3 = tiradasPartidas.iterator();
		while(it3.hasNext()) {
			Tirada aux =(Tirada)it3.next();
			System.out.println(aux.toString());
		}
		
		

		


	}

}
