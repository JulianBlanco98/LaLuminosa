package com.example.BD_ejemplo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ficha {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idFicha;
	public int valor;
	
	@ManyToOne
	private Partida partida;
	
	public Ficha() {
		valor=0;
	}
	
	public Ficha(int valor) {
		super();
		this.valor = valor;
	}
	
	public long getIdFicha() {
		return idFicha;
	}




	public void setIdFicha(long idFicha) {
		this.idFicha = idFicha;
	}


	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}




	@Override
	public String toString() {
		return "Ficha [idFicha=" + idFicha + ", valor=" + valor + "]";
	}
	
	
	
	

}
