package com.example.BD_ejemplo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BD_ejemplo.model.Ficha;
import com.example.BD_ejemplo.model.Tirada;
import com.example.BD_ejemplo.repository.FichaRepository;
import com.example.BD_ejemplo.repository.TiradaRepository;

@Service
public class TiradaServiceImpl implements TiradaService{
	
	@Autowired
	private TiradaRepository tiradarepository;

	@Override
	public Tirada guardarTirada(Tirada t) {
		t = tiradarepository.save(t);
		return t;
	}


	
	
	
	
	

}
