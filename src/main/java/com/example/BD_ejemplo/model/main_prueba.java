package com.example.BD_ejemplo.model;

public class main_prueba {

	
    public static void main(String[] args) {
		
    	
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
    	System.out.println("MATRIZ TIPO: 0(0 verde), 1(número), 2(apuestas par/impar), 3(apuestas rojo/negro)");
    	t.imprimirTipo();
    	
    	
    	
    	
    	//Usuario que va a jugar la partida
    	Usuario usuario = new Usuario();
    	usuario.setNombre("JuanDeDios");
    	usuario.setEdad(50);
    	usuario.setContra("contra1234");
    	usuario.setDinero(100L);
    	//Prueba de una partida
    	Partida p1 = new Partida();
    	p1.getTablero().inicializarMatriz();
    	//p1.getTablero().imprimirValor();
    	System.out.println("----------------------------------------------------");
    	p1.getTablero().imprimirTipo();
    	p1.getTablero().imprimirpParImopar();
    	p1.getTablero().imprimirColor();
    	
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

    	//hay que ver esto, porque el atributo apuesta lo veo raro
    	//en este caso, vamos a hacer un movimiento con una ficha de 5 a un número
    	t1.setApuesta(f_5.getValor());
    	long profitTemporal = 0L;
    	Celda profit_aux = null;
    	profit_aux = p1.getTablero().getCeldaFilaColumna(2, 8);
    	   	
    	p1.actualizarProfitTirada(f_5, t1, profit_aux);
    	System.out.println("PROFIT DE LA TIRADA: "+t1.getProfit());
    	System.out.println("----------------------------------------------------");
    	System.out.println("MATRIZ CON LA FICHA COLOCADA");
    	p1.getTablero().imprimirOcupadas();
    	
    	//Se va a jugar: número aleatorio.
    	//En este caso, el número 8 va a salir
    	System.out.println("----------------------------------------------------");
    	System.out.println("SE TIRA DE LA RULETA...");
    	p1.restarSaldoApuesta(usuario, t1);
    	int numeroRuleta = 8;
    	System.out.println("NÚMERO RULETA: "+numeroRuleta);
    	Celda numRuleta = null;
    	numRuleta = p1.getTablero().getCeldaNumero(numeroRuleta);
    	System.out.println("Casilla del número de la ruleta: "+numRuleta.toString());
    	Celda apuesta = null;
    	apuesta = p1.getTablero().getCeldaFilaColumna(3, 8);
    	System.out.println("Casilla de la apuesta:           "+apuesta.toString());
    	
    	System.out.println("Saldo del jugador: "+p1.getUsuario().getDinero());
    	
    	if(p1.comprobarApuesta(numRuleta, apuesta, usuario, t1)) {
    		System.out.println("GANA");
    	}else {
    		System.out.println("PIERDE");
    	}
    	

    	System.out.println("Saldo FINAL: "+p1.getUsuario().getDinero());	
    	
	}
}
