package com.example.BD_ejemplo.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	public int victoria;
	public int derrota;

	@OneToMany(mappedBy = "partida", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
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
		victoria = 0;
		derrota = 0;
		tablero = new Tablero();

	}

	public Partida(long tiempo, int victoria, int derrota, long profit, Usuario usuario) {
		super();
		this.victoria = victoria;
		this.derrota = derrota;
		this.usuario = usuario;
	}

	
	public List<Ficha> getFichas() {
		return fichas;
	}

	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}

	public long getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(long idPartida) {
		this.idPartida = idPartida;
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
		return "Partida [idPartida=" + idPartida + ", victoria=" + victoria + ", derrota="
				+ derrota +"]";
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
		return apuesta * multi-apuesta;
	}
	
	public Celda recuperarcelda(String valor) {
		Celda c = new Celda();
		if(valor.equals("Rojo")){
			c.setColor("rojo");
			c.setTipo(3);
		}else if(valor.equals("Negro")) {
			c.setColor("negro");
			c.setTipo(3);
		}else if(valor.equals("Par")) {
			c.setTipo(2);
			c.setEspar(true);
		}else if(valor.equals("Impar")) {
			c.setTipo(2);
			c.setEspar(false);
		}else {
			for(int i = 0; i<3; i++) {
				for(int j = 0; j<13; j++) {
					int aux = Integer.parseInt(valor);
					if(tablero.getTablero()[i][j].getValor() == aux) {
						return tablero.getTablero()[i][j];
					}
				}
			}
		}
		return c;
	}
	public boolean comprobarApuesta(Celda ganadora, Celda jugador, Usuario j1, Tirada t) {
		
		//Si el jugador apuesta a un numero
		if(jugador.getTipo()==0 || jugador.getTipo()==1) {
			if(ganadora.getValor()==jugador.getValor()) {
				j1.setDinero(j1.getDinero()+ actualizarSaldoJugador(t.getApuesta(), 36));
				t.setProfit(actualizarSaldoJugador(t.getApuesta(), 36));
				t.setGanado(true);
				return true;
			}else {
				j1.setDinero(j1.getDinero() - t.getApuesta());
				t.setProfit(t.getApuesta()*-1);
				return false;
			}
			//Si el jugador apuesa a Par/Impar
		}else if(jugador.getTipo()==2) {
			if(ganadora.isEspar()==jugador.isEspar()) {
				j1.setDinero(j1.getDinero()+ actualizarSaldoJugador(t.getApuesta(), 2));
				t.setProfit(actualizarSaldoJugador(t.getApuesta(), 2));
				t.setGanado(true);
				return true;
			}else {
				j1.setDinero(j1.getDinero() - t.getApuesta());
				t.setProfit(t.getApuesta()*-1);
				return false;
			}
			//Si el jugador apuesta a Rojo/Negroe
		}else if(jugador.getTipo()==3) {
			if(ganadora.getColor()==jugador.getColor()) {
				j1.setDinero(j1.getDinero()+ actualizarSaldoJugador(t.getApuesta(), 2));
				t.setProfit(actualizarSaldoJugador(t.getApuesta(), 2));
				t.setGanado(true);
				return true;
			}else {
				j1.setDinero(j1.getDinero() - t.getApuesta());
				t.setProfit(t.getApuesta()*-1);
				return false;
			}
			//Sin opcion
		}else {
			return false;
		}
	}

}
