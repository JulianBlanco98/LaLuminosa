package com.example.BD_ejemplo.repository;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BD_ejemplo.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
    Usuario findByNombreAndContra(String nombre, String contrasena);
}
