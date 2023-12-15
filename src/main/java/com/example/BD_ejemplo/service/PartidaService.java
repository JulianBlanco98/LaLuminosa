package com.example.BD_ejemplo.service;

import java.util.Optional;

import com.example.BD_ejemplo.model.Partida;

public interface PartidaService {
	
	public Partida crearPartida(Partida p);
	
	public Partida findPartidaByidPartida(long id);
	
    public Partida actualizarPartida(long id, Partida nuevaPartida);

	
}
