package com.example.BD_ejemplo.runner;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.BD_ejemplo.model.Partida;
import com.example.BD_ejemplo.model.Tirada;
import com.example.BD_ejemplo.model.Usuario;
import com.example.BD_ejemplo.repository.PartidaRepository;
import com.example.BD_ejemplo.repository.TiradaRepository;
import com.example.BD_ejemplo.repository.UsuarioRepository;

@Component
public class MiCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PartidaRepository partidaRepository;
	
	@Autowired
	private TiradaRepository tiradaRepository;

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
     		usuario3.setNombre("a");
     		usuario1.setEdad(24);
     		usuario2.setEdad(21);
     		usuario3.setEdad(22);
     		usuario1.setContra("contra1");
     		usuario2.setContra("contra2");
     		usuario3.setContra("a");
     		usuario1.setDinero(1000L);
     		usuario2.setDinero(1000L);
     		usuario3.setDinero(50L);
     		usuario1.setCorreo("correo1@gmail.com");
     		usuario2.setCorreo("correo2@gmail.com");
     		usuario3.setCorreo("correo3@gmail.com");

     	// 3 partidas
    		Partida p1 = new Partida();
    		

    		// Se añaden usuarios a partidas*/
    		p1.setUsuario(usuario1);

    		Tirada tirada1 = new Tirada(100L, false, -1000L);
            Tirada tirada2 = new Tirada(50L, true, 100L);
            Tirada tirada3 = new Tirada(5L, false, -5L);
            Tirada tirada4 = new Tirada(5L, true, 180L);
            Tirada tirada5 = new Tirada(100L, true, 240);
            Tirada tirada6 = new Tirada(50L, false, -50L);
            Tirada tirada7 = new Tirada(100L, false, -1000L);
            Tirada tirada8 = new Tirada(50L, true, 100L);
            Tirada tirada9 = new Tirada(5L, false, -5L);
            Tirada tirada10 = new Tirada(5L, true, 180L);
            Tirada tirada11= new Tirada(100L, true, 240);
            Tirada tirada12 = new Tirada(50L, false, -50L);
            
            p1.getTiradas().add(tirada1);
            p1.getTiradas().add(tirada2);
            p1.getTiradas().add(tirada3);
            p1.getTiradas().add(tirada4);
            p1.getTiradas().add(tirada5);
            p1.getTiradas().add(tirada6);
            p1.getTiradas().add(tirada7);
            p1.getTiradas().add(tirada8);
            p1.getTiradas().add(tirada9);
            p1.getTiradas().add(tirada10);
            p1.getTiradas().add(tirada11);
            p1.getTiradas().add(tirada12);
            
            tirada1.setPartida(p1);
            tirada2.setPartida(p1);
            tirada3.setPartida(p1);
            tirada4.setPartida(p1);
            tirada5.setPartida(p1);
            tirada6.setPartida(p1);
            tirada7.setPartida(p1);
            tirada8.setPartida(p1);
            tirada9.setPartida(p1);
            tirada10.setPartida(p1);
            tirada11.setPartida(p1);
            tirada12.setPartida(p1);
            
        

    		// Se añaden las partidas a los usuarios
    		usuario1.getPartidas().add(p1);

    		// Creamos los usuarios
    		usuario1 = usuarioRepository.save(usuario1);
    		usuario2 = usuarioRepository.save(usuario2);
    		usuario3 = usuarioRepository.save(usuario3);

    		p1 = partidaRepository.save(p1);
    		
    		tirada1 = tiradaRepository.save(tirada1);
    		tirada2 = tiradaRepository.save(tirada2);
    		tirada3 = tiradaRepository.save(tirada3);
    		tirada4 = tiradaRepository.save(tirada4);
    		tirada5 = tiradaRepository.save(tirada5);
    		tirada6 = tiradaRepository.save(tirada6);
    		tirada7 = tiradaRepository.save(tirada7);
    		tirada8 = tiradaRepository.save(tirada8);
    		tirada9 = tiradaRepository.save(tirada9);
    		tirada10 = tiradaRepository.save(tirada10);
    		tirada11 = tiradaRepository.save(tirada11);
    		tirada12 = tiradaRepository.save(tirada12);

    }
}
