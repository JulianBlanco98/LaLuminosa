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
    	
    	//Usuario que va a jugar la partida
    	Usuario usuario = new Usuario();
    	usuario.setNombre("JuanDeDios");
    	usuario.setEdad(50);
    	usuario.setContra("contra1234");
    	usuario.setDinero(100L);
    	//Prueba de una partida
    	Partida p1 = new Partida();
    	p1.getTablero().inicializarMatriz();
    	p1.getTablero().imprimirValor();
    	System.out.println("----------------------------------------------------");
    	p1.getTablero().imprimirTipo();
    	
    	//Añadir usuario (en memoria)
    	p1.setUsuario(usuario);
    	
    	//Fichas para apostar
    	Ficha f_5 = new Ficha(5);
    	Ficha f_10 = new Ficha(10);
    	Ficha f_20 = new Ficha(20);
    	Ficha f_50 = new Ficha(50);
    	Ficha f_100 = new Ficha(100);
    	
    	//Primera tirada
    	Tirada t1 = new Tirada();
    	t1.addFichas(f_5);
    	t1.addFichas(f_10);
    	t1.addFichas(f_20);
    	t1.addFichas(f_50);
    	t1.addFichas(f_100);
    	
    	//hay que ver esto, porque el atributo apuesta lo veo raro
    	//en este caso, vamos a hacer un movimiento con una ficha de 5 a un número
    	t1.setApuesta(f_5.getValor());
    	long profitTemporal = 0L;
    	profitTemporal = p1.calcularTiradaUnica(t1.getnFichas().get(0), 1, 4, usuario.getDinero());
    	t1.setProfit(profitTemporal - usuario.getDinero());
    	System.out.println("PROFIT DE LA TIRADA: "+t1.getProfit());
    	System.out.println("----------------------------------------------------");
//    	p1.calcularTiradaUnica(f_100, 3, 3, usuario.getDinero());
//    	System.out.println("----------------------------------------------------");
    	System.out.println("MATRIZ CON LA FICHA COLOCADA");
    	p1.getTablero().imprimirOcupadas();
    	    	
    	
	}
}
