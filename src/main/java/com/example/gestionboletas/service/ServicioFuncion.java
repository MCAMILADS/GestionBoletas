package com.example.gestionboletas.service;

import com.example.gestionboletas.model.Funcion;
import java.util.List;

public interface ServicioFuncion {
    Funcion obtenerFuncionPorId(Long idFuncion);
    List<Funcion> obtenerTodasLasFunciones();
    Funcion guardarFuncion(Funcion funcion);
    void eliminarFuncion(Long idFuncion);
}