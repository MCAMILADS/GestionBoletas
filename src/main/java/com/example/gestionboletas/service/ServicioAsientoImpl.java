package com.example.gestionboletas.service;


import com.example.gestionboletas.model.Asiento;
import com.example.gestionboletas.model.Funcion;
import com.example.gestionboletas.repository.AsientoRepositorio;
import com.example.gestionboletas.repository.VentaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicioAsientoImpl implements ServicioAsiento {

    @Autowired
    private AsientoRepositorio asientoRepositorio;

    @Autowired
    private VentaRepositorio ventaRepositorio;

    // ... (otros métodos, algunos de ellos están devolviendo List.of() o null, revisa si es intencional)

    @Override
    public List<Asiento> obtenerTodosLosAsientos() {
        return asientoRepositorio.findAll(); // Devuelve todos los asientos, no una lista vacía
    }

    // Este método necesita implementación real para buscar asientos disponibles
    @Override
    public List<Asiento> obtenerAsientosDisponibles(Funcion funcion) {
        // Implementa la lógica para obtener asientos disponibles para una función
        // Por ejemplo, filtrando los que no están en ventas relacionadas con esa función
        return List.of(); // Placeholder, implementa esto adecuadamente
    }

    @Override
    public Asiento obtenerAsientoPorId(String idAsiento) {
        Optional<Asiento> asientoOptional = asientoRepositorio.findById(idAsiento);
        return asientoOptional.orElse(null); // Devuelve el asiento si existe, o null si no
    }

    @Override
    @Transactional
    public Asiento guardarAsiento(Asiento asiento) {
        return asientoRepositorio.save(asiento);
    }

    @Override
    @Transactional
    public void eliminarAsiento(String idAsiento) {
        asientoRepositorio.deleteById(idAsiento);
    }

    @Override
    @Transactional
    public void marcarAsientoComoVendido(Asiento asiento) {
        asiento.setEstado(com.example.gestionboletas.enums.EstadoAsiento.VENDIDO);
        asientoRepositorio.save(asiento);
    }

    @Override
    @
            Transactional
    public void registrarAsiento(Asiento asiento) {
        asientoRepositorio.save(asiento);
    }
}