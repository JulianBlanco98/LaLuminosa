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

@Entity
public class Partida {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idPartida;
	public long tiempo;
	public int victoria;
	public int derrota;
	public long profit;
	
    @OneToMany(mappedBy = "partida", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <Tirada> tiradas = new ArrayList<>();

	@ManyToOne
	public Usuario usuario;
	
	//prueba
	public Tablero tablero;
	
	public Partida() {
		tiempo=0L;
		victoria=0;
		derrota=0;
		profit=0;
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
	 * @param ficha
	 * @return
	 */
	
	public double calcularTiradaUnica(Ficha ficha) {
		
		int valorFicha = ficha.getValor();
		
		return 0L;
		
	}
	
	
	
}
