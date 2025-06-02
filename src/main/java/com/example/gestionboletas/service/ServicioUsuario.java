package com.example.gestionboletas.service;

import com.example.gestionboletas.model.Usuario;
import java.util.List;

public interface ServicioUsuario {
    Usuario obtenerUsuarioPorId(Long idUsuario);
    Usuario verificarUsuario(String cedula);
    Usuario registrarUsuario(Usuario usuario);
    List<Usuario> obtenerTodosLosUsuarios();
    void eliminarUsuario(Long idUsuario);

}