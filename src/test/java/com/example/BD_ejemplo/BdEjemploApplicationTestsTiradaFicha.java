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
class BdEjemploApplicationTestsTiradaFicha {
	
	@Autowired
	private FichaRepository fichaRepository;
	
	@Autowired
	private TiradaRepository tiradaRepository;

	@Test
	void contextLoads() {

		Scanner in = new Scanner(System.in);

		System.out.println("----------------EMPIEZAN LOS TEST DE FICHA Y TIRADAS----------------");
		
		//creamos 2 tiradas
		Tirada t1 = new Tirada();
		Tirada t2 = new Tirada();

		//asignamos valores a los atributos de tirada
//		t1.setApuesta(70L);
//		t1.setGanado(1); //boolean
//		t1.setProfit(70L);
//		t2.setApuesta(110L);
//		t2.setGanado(0); //boolean
//		t2.setProfit(-110L);
		
		//creamos las fichas: siempre van a ser las mismas
		Ficha f1= new Ficha();
		Ficha f2= new Ficha();
		Ficha f3= new Ficha();
		Ficha f4= new Ficha();
		Ficha f5= new Ficha();
		Ficha f6= new Ficha();
		
		//le damos los valores
		f1.setValor(1);
		f2.setValor(5);
		f3.setValor(10);
		f4.setValor(20);
		f5.setValor(50);
		f6.setValor(100);
		
		//se añaden las fichas a tiradas dependiendo de la apuesta
////		f1.setTirada(t1);
////		f2.setTirada(t1);
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
//		
//		//se añaden las fichas
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
		
		//Creamos las 2 tiradas
		t1 = tiradaRepository.save(t1);
		t2 = tiradaRepository.save(t2);
		
		//Creamos las fichas
		f1= fichaRepository.save(f1);
		f2= fichaRepository.save(f2);
		f3= fichaRepository.save(f3);
		f4= fichaRepository.save(f4);
		f5= fichaRepository.save(f5);
		f6= fichaRepository.save(f6);
		
		//Ver las fichas en la base de datos
		List<Ficha> listaFichas = (List<Ficha>) fichaRepository.findAll();
		System.out.println("Número de fichas: "+listaFichas.size());
		Iterator it = listaFichas.iterator();
		while(it.hasNext()) {
			Ficha aux = (Ficha)it.next();
			System.out.println(aux.toString());
		}
		
		//Ver las tiradas en la base de datos
		List<Tirada> listaTiradas = (List<Tirada>) tiradaRepository.findAll();
		System.out.println("Número de tiradas: "+listaTiradas.size());
		Iterator it2 = listaTiradas.iterator();
		while(it2.hasNext()) {
			Tirada aux = (Tirada)it2.next();
			System.out.println(aux.toString());
		}
		
		//Ver las fichas según la tirada usada
		/*List<Ficha> fichasUsadas = fichaRepository.findFichasByTiradaId(t1.getIdTirada());
		System.out.println("Número de fichas usadas: "+fichasUsadas.size());
		Iterator it3 = fichasUsadas.iterator();
		while(it3.hasNext()) {
			Ficha aux = (Ficha)it3.next();
			System.out.println(aux.toString());
		}*/
		
		
	}

}
