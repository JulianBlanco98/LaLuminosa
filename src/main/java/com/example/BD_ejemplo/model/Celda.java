package com.example.BD_ejemplo.model;

public class Celda {
		
	private int valor;
	private String color;
	private Boolean espar; //true: par, false: impar
	private int tipo; //0: es el 0 verde, 1: es número normal, 2: casilla de apuestas
	private int apuesta; //x2: color, par/impar, x18: numero, x36: 0 verde
	
	public Celda() {
		valor=0;
		color="";
		espar=null;
		tipo=0;
		apuesta=0;
	}
	//
	
	public Celda(int valor, String color, boolean espar, int tipo, int apuesta) {
		super();
		this.valor = valor;
		this.color = color;
		this.espar = espar;
		this.tipo = tipo;
		this.apuesta=apuesta;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Boolean isEspar() {
		return espar;
	}
	public void setEspar(Boolean espar) {
		this.espar = espar;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getApuesta() {
		return apuesta;
	}

	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}
	
	
	
	
	
	
	
}
