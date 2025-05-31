package com.example.gestionboletas.repository;

import com.example.gestionboletas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Usuario findByCedula(String cedula);
}