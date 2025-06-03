package com.example.gestionboletas.repository;

import com.example.gestionboletas.model.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LugarRepositorio extends JpaRepository<Lugar, Long> {
}