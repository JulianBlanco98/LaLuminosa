package com.example.BD_ejemplo.model;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Tirada {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idTirada;
	private List<Ficha> nFichas;
	private long apuesta;
	private int ganado; //boolean
	private long profit;
		
	public Tirada() {
		nFichas= new LinkedList<>();
		apuesta=0L;
		ganado=0;
		profit=0L;
	}
	
	public Tirada(List<Ficha> nFichas, long apuesta, int ganado, long profit) {
		super();
		this.nFichas = nFichas;
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
	public List<Ficha> getnFichas() {
		return nFichas;
	}
	public void setnFichas(List<Ficha> nFichas) {
		this.nFichas = nFichas;
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
	
	
	
	
	
	

}
