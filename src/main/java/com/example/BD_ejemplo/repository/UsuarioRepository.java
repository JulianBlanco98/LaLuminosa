package com.example.BD_ejemplo.repository;




import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BD_ejemplo.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
    Usuario findByNombreAndContra(String nombre, String contrasena);
    
    @Query("SELECT u FROM Usuario u WHERE u.nombre = ?1 AND u.contra = ?2")
    Usuario chequearLogin(String nombre, String contra);
    
    @Query("SELECT u FROM Usuario u WHERE u.nombre = ?1")
    Usuario encontrarPorNombre(String nombre);

}
