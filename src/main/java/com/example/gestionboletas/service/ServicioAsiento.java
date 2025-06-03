package com.example.gestionboletas.service;





import com.example.gestionboletas.model.Asiento;
import com.example.gestionboletas.model.Funcion;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ServicioAsiento {
    List<Asiento> obtenerTodosLosAsientos();
    List<Asiento> obtenerAsientosDisponibles(Funcion funcion);
    Asiento obtenerAsientoPorId(String idAsiento);
    Asiento guardarAsiento(Asiento asiento);
    void eliminarAsiento(String idAsiento);
    void marcarAsientoComoVendido(Asiento asiento);

    @Transactional

    void registrarAsiento(Asiento asiento);
}