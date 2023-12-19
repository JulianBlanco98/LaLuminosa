package com.example.BD_ejemplo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tirada {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idTirada;
	private long apuesta;
	private boolean ganado; //boolean
	private long profit;
	private int numeroRuleta;

		
	@ManyToOne
	public Partida partida;
	
	public Tirada() {
		apuesta=0L;
		ganado=false;
		profit=0L;
		numeroRuleta=-1;
	}
	
	public Tirada(long apuesta, boolean ganado, long profit, int numeroRuleta) {
		super();
		this.apuesta = apuesta;
		this.ganado = ganado;
		this.profit = profit;
		this.numeroRuleta = numeroRuleta;
	}
	
	
	public int getNumeroRuleta() {
		return numeroRuleta;
	}

	public void setNumeroRuleta(int numeroRuleta) {
		this.numeroRuleta = numeroRuleta;
	}

	public long getIdTirada() {
		return idTirada;
	}
	public void setIdTirada(long idTirada) {
		this.idTirada = idTirada;
	}
	public long getApuesta() {
		return apuesta;
	}
	public void setApuesta(long apuesta) {
		this.apuesta = apuesta;
	}
	public boolean isGanado() {
		return ganado;
	}
	public void setGanado(boolean ganado) {
		this.ganado = ganado;
	}
	public long getProfit() {
		return profit;
	}
	public void setProfit(long profit) {
		this.profit = profit;
	}
	

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	@Override
	public String toString() {
		return "Tirada [idTirada=" + idTirada + ", apuesta=" + apuesta + ", ganado=" + ganado + ", profit=" + profit
				+ "]";
	}
}
