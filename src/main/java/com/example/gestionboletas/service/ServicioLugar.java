package com.example.gestionboletas.service;

import com.example.gestionboletas.model.Lugar;
import java.util.List;

public interface ServicioLugar {
    Lugar obtenerLugarPorId(Long idLugar);
    List<Lugar> obtenerTodosLosLugares();
    Lugar guardarLugar(Lugar lugar);
    void eliminarLugar(Long idLugar);
}