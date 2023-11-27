package com.example.BD_ejemplo.model;

public class main_prueba {

	
    public static void main(String[] args) {
		
    	/**
    	//Pruebas de tablero: completadas
    	Tablero t = new Tablero();
    	t.inicializarMatriz();
    	System.out.println("PRUEBAS");
    	
    	System.out.println("MATRIZ POR VALOR");
    	t.imprimirValor();
    	
    	System.out.println("--------------------------------------------------");
    	System.out.println("MATRIZ POR COLOR");
    	t.imprimirColor();
    	System.out.println("--------------------------------------------------");
    	System.out.println("MATRIZ PAR/IMPAR");
    	t.imprimirpParImopar();
    	System.out.println("--------------------------------------------------");
    	System.out.println("MATRIZ TIPO: 0(0 verde), 1(número), 2(apuestas)");
    	t.imprimirTipo();
    	*/
    	
    	//Prueba de una partida
    	Partida p1 = new Partida();
    	p1.getTablero().inicializarMatriz();
    	p1.getTablero().imprimirValor();
    	
    	//Fichas para apostar
    	Ficha f_5 = new Ficha(5);
    	Ficha f_10 = new Ficha(10);
    	Ficha f_20 = new Ficha(20);
    	Ficha f_50 = new Ficha(50);
    	Ficha f_100 = new Ficha(100);
    	
    	p1.calcularTiradaUnica(f_5);
    	
    	
    	
	}
}
