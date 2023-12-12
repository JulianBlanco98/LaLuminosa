package com.example.BD_ejemplo.model;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Tirada {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idTirada;
	private long apuesta;
	private int ganado; //boolean
	private long profit;

		
	@ManyToOne
	public Partida partida;
	
	public Tirada() {
		apuesta=0L;
		ganado=0;
		profit=0L;
	}
	
	public Tirada(List<Ficha> nFichas, long apuesta, int ganado, long profit) {
		super();
		this.apuesta = apuesta;
		this.ganado = ganado;
		this.profit = profit;
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
	public int getGanado() {
		return ganado;
	}
	public void setGanado(int ganado) {
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
