package com.example.BD_ejemplo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.BD_ejemplo.model.Partida;


@Repository
public interface PartidaRepository extends CrudRepository<Partida, Long> {
	
//	@Query("SELECT p FROM Partida p WHERE p.usuario.idUsuario = ?1")
//	List<Partida> findPartidasByID(Long userId);
	
	@Query("SELECT p FROM Partida p WHERE p.usuario.idUsuario = ?1")
	List<Partida> findPartidasByUserId(Long userId);
	
	@Query("SELECT p FROM Partida p WHERE p.idPartida = ?1")
	Partida buscarPartidaID(Long idPartida);

//	@Query("SELECT p FROM Partida p WHERE p.usuario.idUsuario = :userId")
//    List<Partida> findPartidasByUserId(@Param("userId") Long userId);

}
