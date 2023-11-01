package com.example.BD_ejemplo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.BD_ejemplo.model.Ficha;
import com.example.BD_ejemplo.model.Partida;
import com.example.BD_ejemplo.model.Tirada;



@Repository
public interface TiradaRepository extends CrudRepository<Tirada, Long> {
	
	@Query("SELECT t FROM Tirada t WHERE t.partida.idPartida = ?1")
	List<Tirada> findTiradasByPartidaId(Long partidaId);
	
//	@Query("SELECT * FROM Tirada WHERE partida_id IN (SELECT idPartida FROM Partida WHERE usuario_id = :idUser)")
//	List<Tirada> findTiradasByUserId(Long userId);
	
	@Query("SELECT t FROM Tirada t WHERE t.partida.usuario.idUsuario = ?1")
    List<Tirada> findTiradasByUsuarioId(Long usuarioId);

}
