package com.example.gestionboletas.repository;

import com.example.gestionboletas.model.Funcion;
import com.example.gestionboletas.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VentaRepositorio extends JpaRepository<Venta, Long> {
    List<Venta> findByFuncion(Funcion funcion);
}