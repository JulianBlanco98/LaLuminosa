package com.example.BD_ejemplo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Ficha {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idFicha;
	private int valor;
	
	public Ficha(int valor) {
		super();
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	

}
