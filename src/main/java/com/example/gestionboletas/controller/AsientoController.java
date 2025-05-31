package com.example.gestionboletas.controller;

import com.example.gestionboletas.model.Asiento;
import com.example.gestionboletas.model.Funcion;
import com.example.gestionboletas.service.ServicioAsiento;
import com.example.gestionboletas.service.ServicioFuncion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/asientos")
public class AsientoController {

    @Autowired
    private ServicioAsiento servicioAsiento;

    @Autowired
    private ServicioFuncion servicioFuncion;

    @GetMapping("/disponibles")
    public ResponseEntity<List<Asiento>> obtenerAsientosDisponibles(@RequestParam Long funcionId) {
        Funcion funcion = servicioFuncion.obtenerFuncionPorId(funcionId);
        if (funcion == null) {
            return ResponseEntity.notFound().build();
        }
        List<Asiento> asientosDisponibles = servicioAsiento.obtenerAsientosDisponibles(funcion);
        return ResponseEntity.ok(asientosDisponibles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asiento> obtenerAsientoPorId(@PathVariable String id) {
        Asiento asiento = servicioAsiento.obtenerAsientoPorId(id);
        if (asiento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(asiento);
    }
}