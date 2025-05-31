package com.example.gestionboletas.repository;

import com.example.gestionboletas.model.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionRepositorio extends JpaRepository<Funcion, Long> {
    // Puedes añadir métodos de consulta personalizados aquí si es necesario
}
