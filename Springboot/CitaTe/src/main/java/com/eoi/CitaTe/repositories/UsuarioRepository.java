package com.eoi.CitaTe.repositories;

import com.eoi.CitaTe.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

   // Optional<Usuario> findByUsername(String email);
    Optional<Usuario> findByEmail(String email);

    // Gaginacion

    Page<Usuario> findAll(Pageable pageable);



    @Query("Select count(id) from Usuario where email= ?1 and pass = ?2")
    Integer repValidarPassword(String email, String pass);

    Usuario findUsuarioByEmailAndPass(String email, String pass);
}
