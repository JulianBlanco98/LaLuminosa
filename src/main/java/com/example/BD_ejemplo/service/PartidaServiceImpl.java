package com.example.BD_ejemplo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BD_ejemplo.model.Partida;
import com.example.BD_ejemplo.repository.PartidaRepository;

@Service
public class PartidaServiceImpl implements PartidaService{
	
	@Autowired
	private PartidaRepository partidarepository;

	@Override
	public Partida crearPartida(Partida p) {
		p = partidarepository.save(p);
		return p;
	}

	@Override
	public Partida findPartidaByidPartida(long id) {
		Partida p = partidarepository.buscarPartidaID(id);
		return p;
	}
	
	
	
	
	

}