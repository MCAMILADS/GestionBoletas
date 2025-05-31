package com.example.gestionboletas.controller;

import com.example.gestionboletas.model.Venta;
import com.example.gestionboletas.service.ServicioVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private ServicioVenta servicioVenta;

    @PostMapping("/realizar")
    public ResponseEntity<Venta> realizarVenta(@RequestParam String asientoId,
                                               @RequestParam Long funcionId,
                                               @RequestParam(required = false) Long usuarioId) {
        try {
            Venta venta = servicioVenta.realizarVenta(asientoId, funcionId, usuarioId);
            return new ResponseEntity<>(venta, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Podríamos tener manejo de excepciones más específico
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable Long id) {
        Venta venta = servicioVenta.obtenerVentaPorId(id);
        if (venta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(venta);
    }
}