package com.example.gestionboletas.service;


import com.example.gestionboletas.model.Asiento;
import com.example.gestionboletas.model.Funcion;
import com.example.gestionboletas.repository.AsientoRepositorio;
import com.example.gestionboletas.repository.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioAsientoImpl implements ServicioAsiento {

    @Autowired
    private AsientoRepositorio asientoRepositorio;

    @Autowired
    private VentaRepositorio ventaRepositorio;

    @Override
    public List<Asiento> obtenerAsientosDisponibles(Funcion funcion) {
        List<Asiento> todosLosAsientos = asientoRepositorio.findAll();

        List<String> asientosVendidosIds = ventaRepositorio.findByFuncion(funcion).stream()
                .map(venta -> venta.getAsiento().getIdAsiento())
                .collect(Collectors.toList());

        return todosLosAsientos.stream()
                .filter(asiento -> !asientosVendidosIds.contains(asiento.getIdAsiento()) &&
                        asiento.getEstado() == asiento.getEstado().DISPONIBLE)
                .collect(Collectors.toList());
    }

    @Override
    public Asiento obtenerAsientoPorId(String idAsiento) {
        return asientoRepositorio.findById(idAsiento).orElse(null);
    }

    @Override
    public void marcarAsientoComoVendido(Asiento asiento) {
        asiento.setEstado(asiento.getEstado().VENDIDO);
        asientoRepositorio.save(asiento);
    }
}