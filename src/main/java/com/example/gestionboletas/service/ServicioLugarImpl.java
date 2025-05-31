package com.example.gestionboletas.service;

import com.example.gestionboletas.model.Lugar;
import com.example.gestionboletas.repository.LugarRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioLugarImpl implements ServicioLugar {

    @Autowired
    private LugarRepositorio lugarRepositorio;

    @Override
    public Lugar obtenerLugarPorId(Long idLugar) {
        return lugarRepositorio.findById(idLugar).orElse(null);
    }

    @Override
    public List<Lugar> obtenerTodosLosLugares() {
        return lugarRepositorio.findAll();
    }

    @Override
    public Lugar guardarLugar(Lugar lugar) {
        return lugarRepositorio.save(lugar);
    }

    @Override
    public void eliminarLugar(Long idLugar) {
        lugarRepositorio.deleteById(idLugar);
    }
}