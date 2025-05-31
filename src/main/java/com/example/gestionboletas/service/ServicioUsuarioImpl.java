package com.example.gestionboletas.service;

import com.example.gestionboletas.model.Usuario;
import com.example.gestionboletas.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuarioImpl implements ServicioUsuario {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public Usuario obtenerUsuarioPorId(Long idUsuario) {
        return usuarioRepositorio.findById(idUsuario).orElse(null);
    }

    @Override
    public Usuario verificarUsuario(String cedula) {
        return usuarioRepositorio.findByCedula(cedula);
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        usuarioRepositorio.deleteById(idUsuario);
    }
}