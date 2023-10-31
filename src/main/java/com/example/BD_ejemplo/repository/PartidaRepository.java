package com.example.BD_ejemplo.repository;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.BD_ejemplo.model.Partida;



@Repository
public interface PartidaRepository extends CrudRepository<Partida, Long> {
	
	@Query("SELECT p FROM Partida p WHERE p.usuario.idUsuario = ?1")
	List<Partida> findPartidasByID(Long userId);

}
