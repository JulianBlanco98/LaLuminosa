package com.example.BD_ejemplo.runner;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.BD_ejemplo.model.Partida;
import com.example.BD_ejemplo.model.Usuario;
import com.example.BD_ejemplo.repository.PartidaRepository;
import com.example.BD_ejemplo.repository.UsuarioRepository;

@Component
public class MiCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PartidaRepository partidaRepository;

    @Override
    public void run(String... args) throws Exception {
    	


        System.out.println("¡La aplicación se ha iniciado! Realizando tareas de inicialización...");
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
    		p1.setTiempo(3000L);
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
    		p3.setProfit(10L);

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

    		p1 = partidaRepository.save(p1);
    		p2 = partidaRepository.save(p2);
    		p3 = partidaRepository.save(p3);

        // Agrega tu lógica de inicialización aquí
    }
}