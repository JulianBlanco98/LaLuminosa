package com.example.BD_ejemplo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Partida {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idPartida;
	public long tiempo;
	public int victoria;
	public int derrota;
	public long profit;
	
	@ManyToOne
	public Usuario usuario;
	
	public Partida() {
		tiempo=0L;
		victoria=0;
		derrota=0;
		profit=0;
		
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

	@Override
	public String toString() {
		return "Partida [idPartida=" + idPartida + ", tiempo=" + tiempo + ", victoria=" + victoria + ", derrota="
				+ derrota + ", profit=" + profit + "]";
	}
	
	
	
}
