package com.example.BD_ejemplo.repository;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.BD_ejemplo.model.Partida;



@Repository
public interface PartidaRepository extends CrudRepository<Partida, Long> {
	
//	@Query("SELECT d FROM Direccion d WHERE d.usuario.id = ?1")
//	List<Direccion> findDireccionesByUserId(Long userId);
	

}
