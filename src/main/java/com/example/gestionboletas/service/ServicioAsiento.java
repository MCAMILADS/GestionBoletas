package com.example.gestionboletas.service;

import com.example.gestionboletas.model.Asiento;
import com.example.gestionboletas.model.Funcion;
import java.util.List;

public interface ServicioAsiento {
    List<Asiento> obtenerAsientosDisponibles(Funcion funcion);
    Asiento obtenerAsientoPorId(String idAsiento);
    void marcarAsientoComoVendido(Asiento asiento);
}