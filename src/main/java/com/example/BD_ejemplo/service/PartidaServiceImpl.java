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

	@Override
	public Partida actualizarPartida(long id, Partida nuevaPartida) {

		Partida p = partidarepository.buscarPartidaID(id);
		p.setUsuario(nuevaPartida.getUsuario());
		p.setTiradas(nuevaPartida.getTiradas());
		if(nuevaPartida.getTiradas().get(nuevaPartida.getTiradas().size()-1).isGanado()){
			p.setVictoria(p.getVictoria()+1);
		}else {
			p.setDerrota(p.getDerrota()+1);
		}
		
		return null;
	}
	

	
	
	

}
