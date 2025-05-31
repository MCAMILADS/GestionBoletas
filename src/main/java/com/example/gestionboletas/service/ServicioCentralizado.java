package com.example.gestionboletas.service;

import com.example.gestionboletas.model.Venta;

public interface ServicioCentralizado {
    void validarDisponibilidadAsiento(String idAsiento, Long idFuncion);
    void enviarInformacionVenta(Venta venta);
}
