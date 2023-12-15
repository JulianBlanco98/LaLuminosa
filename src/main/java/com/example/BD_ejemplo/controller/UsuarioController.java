package com.example.BD_ejemplo.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.BD_ejemplo.model.Celda;
import com.example.BD_ejemplo.model.Partida;
import com.example.BD_ejemplo.model.Tablero;
import com.example.BD_ejemplo.model.Tirada;
import com.example.BD_ejemplo.model.Usuario;
import com.example.BD_ejemplo.repository.PartidaRepository;
import com.example.BD_ejemplo.service.FichaService;
import com.example.BD_ejemplo.service.PartidaService;
import com.example.BD_ejemplo.service.TiradaService;
import com.example.BD_ejemplo.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PartidaService partidaservice;

	@Autowired
	private FichaService fichaservice;

	@Autowired
	private TiradaService tiradaservice;
	
	@GetMapping("/registro")
	public String showAddUsuarioForm(Usuario usuario) {
		System.out.println("\t UsuarioController::showAddUsuarioForm");
		return "registro";
	}

	@PostMapping("/registro")
	public String addUsuario(Usuario usuario, Model model) {
		System.out.println("\t UsuarioController::addUsuario");
		/// logica de validacion de usuarios, email correcto, repetido o no?, nombre
		/// usuario repetido, formato....
		//
		// Esquema común:
		// Si hay errores entonces
		// devolver la misma vista;
		// Yo no escribo la logica de control de errores. Sorry :(.
		// Pista: Spring y Thymeleaf proporcionan formas de validar datos...

		System.out.println(usuario);

		// le pedimos al servicio que nos cree un usuario
		model.addAttribute("usuarios", usuarioService.crearUsuario(usuario)); // no es estrictamente necesario añadir el
																				// atributo al model aquí.

		return "redirect:/index.html"; // se registra OK, se redirecciona a la página principal.
	}

	@GetMapping("/login")
	public String showLogin(Usuario usuario) {
		System.out.println("\t UsuarioController::showLogin");
		return "login";
	}

	/*
	 * @PostMapping("/tirada") public String
	 * manejarResultado(@RequestParam("outcome") String
	 * outcome,@RequestParam("valorTablero") String fichaValor,
	 * 
	 * @RequestParam("numeroFicha") String numeroFicha,@RequestParam("clasePartida")
	 * long idPartida , Model model) { // Realizar operaciones con el valor outcome
	 * System.out.println("Resultado recibido en el controlador: " + outcome);
	 * System.out.println("Número de la ficha:"+numeroFicha);
	 * System.out.println("apostado en: "+fichaValor); Partida aux =
	 * partidaservice.findPartidaByidPartida(idPartida);
	 * System.out.println("ID PARTIDA: "+aux.getIdPartida()+", dinero:"+aux.
	 * getUsuario().getDinero());
	 * 
	 * 
	 * //partidaservice Tablero t = new Tablero(); t.inicializarMatriz();
	 * aux.setTablero(t);
	 * 
	 * //Aplicar la lógica de la ruleta Tirada tirada = new Tirada(); long
	 * apuestaJugador = Long.parseLong(numeroFicha);
	 * tirada.setApuesta(apuestaJugador);
	 * System.out.println("Apuesta de la tirada: "+tirada.getApuesta());
	 * 
	 * Celda numeroRuleta = null; Celda apostada = null;
	 * 
	 * numeroRuleta = aux.recuperarcelda(outcome);
	 * System.out.println("Celda de la ruleta: "+numeroRuleta.toString()); apostada
	 * = aux.recuperarcelda(fichaValor);
	 * System.out.println("Celda de la apuesta: "+apostada.toString()); boolean
	 * ganaTirada = aux.comprobarApuesta(numeroRuleta, apostada, aux.getUsuario(),
	 * tirada); if (ganaTirada) { System.out.println("Has ganado la apuesta");
	 * model.addAttribute("partida", aux); return "redirect:/prueba";
	 * 
	 * } else { System.out.println("Has perdido"); model.addAttribute("partida",
	 * aux); return "redirect:/prueba"; //return a html de derrota }
	 * 
	 * 
	 * 
	 * 
	 * //guardar en BD // model.addAttribute("partida", aux); // return
	 * "redirect:/index"; }
	 */

	@PostMapping("/tirada")
	public ResponseEntity<?> manejarResultado(@RequestParam("outcome") String outcome,
			@RequestParam("valorTablero") String fichaValor, @RequestParam("numeroFicha") String numeroFicha,
			@RequestParam("clasePartida") long idPartida, Model model) {
		// Realizar operaciones con el valor outcome
		System.out.println("Resultado recibido en el controlador: " + outcome);
		System.out.println("Número de la ficha:" + numeroFicha);
		System.out.println("apostado en: " + fichaValor);
		Partida aux = partidaservice.findPartidaByidPartida(idPartida);
		System.out.println("ID PARTIDA: " + aux.getIdPartida() + ", dinero:" + aux.getUsuario().getDinero());

		// partidaservice
		Tablero t = new Tablero();
		t.inicializarMatriz();
		aux.setTablero(t);

		// Aplicar la lógica de la ruleta
		Tirada tirada = new Tirada();
		long apuestaJugador = Long.parseLong(numeroFicha);
		tirada.setApuesta(apuestaJugador);
		System.out.println("Apuesta de la tirada: " + tirada.getApuesta());

		Celda numeroRuleta = null;
		Celda apostada = null;

		numeroRuleta = aux.recuperarcelda(outcome);
		System.out.println("Celda de la ruleta: " + numeroRuleta.toString());
		apostada = aux.recuperarcelda(fichaValor);
		System.out.println("Celda de la apuesta: " + apostada.toString());
		boolean ganaTirada = aux.comprobarApuesta(numeroRuleta, apostada, aux.getUsuario(), tirada);
		
		aux.getTiradas().add(tirada);
		tirada.setPartida(aux);
		aux = partidaservice.actualizarPartida(idPartida, aux);
		tirada = tiradaservice.guardarTirada(tirada);
		System.out.println(tirada.toString());
		
		
		//Guardar la tirada en la base de datos
		
		
		
		
		if (ganaTirada) {
			System.out.println("Has ganado la apuesta");
			model.addAttribute("partida", aux);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return ResponseEntity.ok().body(Collections.singletonMap("gano", true));

		} else {
			System.out.println("Has perdido");
			model.addAttribute("partida", aux);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ResponseEntity.ok().body(Collections.singletonMap("gano", false));
			// return a html de derrota
		}

		// guardar en BD
//	    model.addAttribute("partida", aux);
//        return "redirect:/index";
	}

	@GetMapping("/prueba")
	public String ganador(@ModelAttribute Partida partida, Model model) {
		System.out.println("Controller ganador");
//	    System.out.println("ID PARTIDA: "+partida.getIdPartida()+", dinero:"+partida.getUsuario().getDinero());
//    	model.addAttribute("partida", partida);

		System.out.println("Controller ganador2");

		return "ganador";
	}

	@PostMapping("/index")
	public String login(@ModelAttribute Usuario usuario, Model model) {
		System.out.println("\t UsuarioController::login");

		Usuario aux = usuarioService.chequearLogin(usuario.getNombre(), usuario.getContra());
		if (aux != null) {

			// Creamos la Partida del Jugador
			Partida partida = new Partida();
			// Inicializamos el tablero
			partida.getTablero().inicializarMatriz();

			// Se la añadimos tanto al usuario como a la partida (1 a N)
			partida.setUsuario(aux);
			aux.getPartidas().add(partida);

			for (int i = 0; i < 5; i++) {
				partida.getFichas().get(i).setPartida(partida);
				fichaservice.guardarFicha(partida.getFichas().get(i));
			}
			partida = partidaservice.crearPartida(partida);

			// System.out.println(aux.toString());
			// System.out.println("Usuario dinero: "+aux.getDinero());

			// le añadimos ambos atributos
//			model.addAttribute("usuario", aux);
			model.addAttribute("partida", partida);

			return "principal";
		} else {
			return "Error";
		}
	}

}
