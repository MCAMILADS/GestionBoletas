package com.example.gestionboletas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.example.gestionboletas.enums.EstadoAsiento;

@Data
@AllArgsConstructor
@Entity

public class Asiento {
    @Id
    private String idAsiento;
    private String ubicacion;
    private Double precio;
    private EstadoAsiento estado;

    public Asiento(String idAsiento, String localidad, Double precio) {
        this.idAsiento = idAsiento;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.estado = EstadoAsiento.DISPONIBLE;
    }
    public Asiento() {
        this.estado = EstadoAsiento.DISPONIBLE;
    }
}

