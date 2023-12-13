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
	
	@OneToMany(mappedBy = "partida")
	public List<Ficha> fichas = new ArrayList<>();

	// prueba
	@Transient
	public Tablero tablero;

	public Partida() {
		fichas= new ArrayList<>();
		fichas.add(new Ficha(5));
		fichas.add(new Ficha(10));
		fichas.add(new Ficha(20));
		fichas.add(new Ficha(50));
		fichas.add(new Ficha(100));
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

	/*public long calcularTiradaUnica(Ficha ficha, int fila, int columna, long saldo) {

		int valorFicha = ficha.getValor();
		int valorTablero = tablero.getValorTablero(fila, columna);
		long profitSaldo = 0L;
		int tipoCelda = tablero.getTipoCeldaTablero(fila, columna);
		System.out.println("Valor de la ficha: " + valorFicha);
		System.out.println("Valor de la posición de la ficha en el tablero: " + valorTablero);
		System.out.println("Saldo del jugador " + this.getUsuario().getNombre() + ": " + saldo);
		
		//Poner la celda de tablero en ocupada = true por la ficha que se va a juagr
		tablero.fichaEnCelda(fila, columna);

		// Una vez obtenido el valor del tablero donde se ha colocado la ficha, hay que
		// ver todas las posibidades

		System.out.println("\n-->Tipo de casilla a apostar: " + tipoCelda);
		profitSaldo = actualizarSaldoTemporal(saldo, tipoCelda, valorFicha);
		System.out.println("Saldo previsto: "+(profitSaldo-ficha.getValor()));

		return profitSaldo;

	}*/

	public void actualizarProfitTirada(Ficha ficha, Tirada t, Celda apuesta) {
		
		if(apuesta.getTipo() == 0 || apuesta.getTipo() == 1) {
			t.setProfit(ficha.getValor() * 36);
		}
		else {
			t.setProfit(ficha.getValor() * 2);
		}
	}
	
	
	public void comprobarTiradas(Tirada tirada) {
		
		//Número aleatorio de la ruleta. Prueba de que se acierta un número
		int numeroSacado = 11; 
		
	}
	
	public void restarSaldoApuesta(Usuario j1, Tirada t) {		
		j1.setDinero(j1.getDinero()-t.getApuesta());	
	}
	
	public long actualizarSaldoJugador(long apuesta, int multi) {
		return apuesta * multi;
	}
	
	
	public boolean comprobarApuesta(Celda ganadora, Celda jugador, Usuario j1, Tirada t) {
		
		//Si el jugador apuesta a un numero
		if(jugador.getTipo()==0 || jugador.getTipo()==1) {
			if(ganadora.getValor()==jugador.getValor()) {
				j1.setDinero(j1.getDinero()+ actualizarSaldoJugador(t.getApuesta(), 36));
				return true;
			}else {
				return false;
			}
			//Si el jugador apuesa a Par/Impar
		}else if(jugador.getTipo()==2) {
			if(ganadora.isEspar()==jugador.isEspar()) {
				j1.setDinero(j1.getDinero()+ actualizarSaldoJugador(t.getApuesta(), 2));

				return true;
			}else {
				return false;
			}
			//Si el jugador apuesta a Rojo/Negroe
		}else if(jugador.getTipo()==3) {
			if(ganadora.getColor()==jugador.getColor()) {
				j1.setDinero(j1.getDinero()+ actualizarSaldoJugador(t.getApuesta(), 2));
				return true;
			}else {
				return false;
			}
			//Sin opcion
		}else {
			return false;
		}
	}

}
