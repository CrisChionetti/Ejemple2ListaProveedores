package com.ejemple2.repository;

import com.ejemple2.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreAndPasswordUsuario(String nombre, String passwordUsuario);
}


