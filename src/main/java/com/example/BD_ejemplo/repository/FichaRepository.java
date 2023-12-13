package com.example.BD_ejemplo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.BD_ejemplo.model.Ficha;
import com.example.BD_ejemplo.model.Partida;



@Repository
public interface FichaRepository extends CrudRepository<Ficha, Long> {
	
	
	
}
