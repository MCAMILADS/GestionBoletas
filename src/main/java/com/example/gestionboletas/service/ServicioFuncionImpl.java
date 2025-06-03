package com.example.gestionboletas.service;

import com.example.gestionboletas.model.Funcion;
import com.example.gestionboletas.repository.FuncionRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioFuncionImpl implements ServicioFuncion {

    @Autowired
    private FuncionRepositorio funcionRepositorio;

    @Override
    public Funcion obtenerFuncionPorId(Long idFuncion) {
        return funcionRepositorio.findById(idFuncion).orElse(null);
    }

    @Override
    public List<Funcion> obtenerTodasLasFunciones() {
        return funcionRepositorio.findAll();
    }

    @Override
    @Transactional // Añade @Transactional si este método modifica la BD (aunque aquí solo guarda)
    public Funcion guardarFuncion(Funcion funcion) {
        return funcionRepositorio.save(funcion);
    }

    @Override
    @Transactional // Añade @Transactional si este método modifica la BD
    public void eliminarFuncion(Long idFuncion) {
        funcionRepositorio.deleteById(idFuncion);
    }

    // --- Nuevo método recomendado para buscar por 'dia' ---
    public Funcion obtenerFuncionPorDia(String dia) {
        return funcionRepositorio.findByDia(dia).orElse(null);
    }
}