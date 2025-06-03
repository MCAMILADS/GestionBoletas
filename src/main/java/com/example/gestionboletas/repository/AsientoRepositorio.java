package com.example.gestionboletas.repository;


import com.example.gestionboletas.model.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsientoRepositorio extends JpaRepository<Asiento, String> {
}