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

		

	}

}
