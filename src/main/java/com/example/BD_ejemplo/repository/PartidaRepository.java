package com.example.BD_ejemplo.repository;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BD_ejemplo.model.Partida;



@Repository
public interface PartidaRepository extends CrudRepository<Partida, Long> {
	
	
	

}
