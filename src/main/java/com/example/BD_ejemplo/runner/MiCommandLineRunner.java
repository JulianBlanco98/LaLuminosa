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
     		usuario3.setNombre("a");
     		usuario1.setEdad(24);
     		usuario2.setEdad(21);
     		usuario3.setEdad(22);
     		usuario1.setContra("contra1");
     		usuario2.setContra("contra2");
     		usuario3.setContra("a");
     		usuario1.setDinero(1000L);
     		usuario2.setDinero(50L);
     		usuario3.setDinero(1000L);
     		usuario1.setCorreo("correo1@gmail.com");
     		usuario2.setCorreo("correo2@gmail.com");
     		usuario3.setCorreo("correo3@gmail.com");

     	// 3 partidas
    		Partida p1 = new Partida();
    		

    		// Se añaden usuarios a partidas*/
    		p1.setUsuario(usuario1);

           
        

    		// Se añaden las partidas a los usuarios
    		usuario1.getPartidas().add(p1);

    		// Creamos los usuarios
    		usuario1 = usuarioRepository.save(usuario1);
    		usuario2 = usuarioRepository.save(usuario2);
    		usuario3 = usuarioRepository.save(usuario3);

    		p1 = partidaRepository.save(p1);
  
    }
}
