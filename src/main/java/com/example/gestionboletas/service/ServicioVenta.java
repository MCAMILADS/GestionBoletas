package com.example.gestionboletas.service;

import com.example.gestionboletas.model.Venta;

import java.util.List;

public interface ServicioVenta {
    Venta realizarVenta(String idAsiento, Long idFuncion, Long idUsuario);
    Venta obtenerVentaPorId(Long idVenta);
    List<Venta> obtenerTodasLasVentas();
}