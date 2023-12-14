package com.example.BD_ejemplo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BD_ejemplo.model.Ficha;
import com.example.BD_ejemplo.repository.FichaRepository;

@Service
public class FichaServiceImpl implements FichaService{
	
	@Autowired
	private FichaRepository ficharepository;

	@Override
	public Ficha guardarFicha(Ficha c) {
		c = ficharepository.save(c);
			return c;
	}


	
	
	
	
	

}
