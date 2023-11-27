package com.example.BD_ejemplo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Partida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPartida;
	public long tiempo;
	public int victoria;
	public int derrota;
	public long profit;

	@OneToMany(mappedBy = "partida", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tirada> tiradas = new ArrayList<>();

	@ManyToOne
	public Usuario usuario;

	// prueba
	@Transient
	public Tablero tablero;

	public Partida() {
		tiempo = 0L;
		victoria = 0;
		derrota = 0;
		profit = 0;
		tablero = new Tablero();

	}

	public Partida(long tiempo, int victoria, int derrota, long profit, Usuario usuario) {
		super();
		this.tiempo = tiempo;
		this.victoria = victoria;
		this.derrota = derrota;
		this.profit = profit;
		this.usuario = usuario;
	}

	public long getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(long idPartida) {
		this.idPartida = idPartida;
	}

	public long getTiempo() {
		return tiempo;
	}

	public void setTiempo(long tiempo) {
		this.tiempo = tiempo;
	}

	public int getVictoria() {
		return victoria;
	}

	public void setVictoria(int victoria) {
		this.victoria = victoria;
	}

	public int getDerrota() {
		return derrota;
	}

	public void setDerrota(int derrota) {
		this.derrota = derrota;
	}

	public long getProfit() {
		return profit;
	}

	public void setProfit(long profit) {
		this.profit = profit;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Tirada> getTiradas() {
		return tiradas;
	}

	public void setTiradas(List<Tirada> tiradas) {
		this.tiradas = tiradas;
	}

	@Override
	public String toString() {
		return "Partida [idPartida=" + idPartida + ", tiempo=" + tiempo + ", victoria=" + victoria + ", derrota="
				+ derrota + ", profit=" + profit + "]";
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	/**
	 * Calcular la apuesta según la ficha usada y donde la haya colocado el usuario.
	 * 
	 * @param ficha:   ficha que pone en el tablero
	 * @param fila:    fila donde coloca la ficha
	 * @param columna: columna donde coloca la ficha
	 * @return
	 */

	public double calcularTiradaUnica(Ficha ficha, int fila, int columna, long saldo) {

		int valorFicha = ficha.getValor();
		int valorTablero = tablero.getValorTablero(fila, columna);
		long profitSaldo = 0L;
		int tipoCelda = tablero.getTipoCeldaTablero(fila, columna);
		System.out.println("Valor de la ficha: " + valorFicha);
		System.out.println("Valor de la posición de la ficha en el tablero: " + valorTablero);
		System.out.println("Saldo del jugador " + this.getUsuario().getNombre() + ": " + saldo);
		
		//Poner la celda de tablero en ocupada = true por la ficha que se va a juagr
		

		// Una vez obtenido el valor del tablero donde se ha colocado la ficha, hay que
		// ver todas las posibidades

		System.out.println("\n-->Tipo de casilla a apostar: " + tipoCelda);
		profitSaldo = actualizarSaldo(saldo, tipoCelda, valorFicha);
		System.out.println("Ganacias previstas: "+profitSaldo);

		return profitSaldo;

	}

	/**
	 * Método para calcular el saldo nuevo
	 * 
	 * @return
	 */
	public long actualizarSaldo(long saldo, int tipo, int apuesta) {

		int multiplicador = 0;
		int ganancias = 0;
		if(tipo == 0 || tipo == 1) {
			multiplicador = 36;
		}
		else {
			multiplicador = 2;
		}
		ganancias = apuesta * multiplicador;
		return (saldo + ganancias);
	}

}
