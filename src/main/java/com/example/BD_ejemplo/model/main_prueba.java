package com.example.BD_ejemplo.model;

public class main_prueba {

	
    public static void main(String[] args) {
		
    	
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
    	
    	
	}
}
