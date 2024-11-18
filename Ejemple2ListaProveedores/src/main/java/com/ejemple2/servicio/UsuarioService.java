package com.ejemple2.servicio;

import com.ejemple2.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public boolean validarUsuario(String nombre, String password) {
        return usuarioRepository.findByNombreAndPasswordUsuario(nombre, password).isPresent();
    }
}
