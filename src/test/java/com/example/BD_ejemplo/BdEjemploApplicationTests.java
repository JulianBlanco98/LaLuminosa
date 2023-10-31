package com.example.BD_ejemplo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.BD_ejemplo.model.Usuario;
import com.example.BD_ejemplo.repository.UsuarioRepository;

@SpringBootTest
class BdEjemploApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	

	@Test
	void contextLoads() {

		Scanner in = new Scanner(System.in);

		System.out.println("----------------EMPIEZAN LOS TEST----------------");
		
		
		
		//3 usuarios nuevos
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		Usuario usuario3 = new Usuario();
		
		//Rellenamos sus datos
		usuario1.setNombre("Julian");usuario2.setNombre("Ignacio");usuario3.setNombre("Nicolas");
		usuario1.setEdad(24);usuario2.setEdad(21);usuario3.setEdad(22);
		usuario1.setContra("contra1");usuario2.setContra("contra2");usuario3.setContra("contra3");
		usuario1.setDinero(1000L);usuario2.setDinero(1000L);usuario3.setDinero(1000L);
		

	}

}
