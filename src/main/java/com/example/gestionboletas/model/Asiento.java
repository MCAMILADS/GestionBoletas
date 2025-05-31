package com.example.gestionboletas.model;

import com.example.gestionboletas.enums.EstadoAsiento;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;



@Entity
@Data
@AllArgsConstructor


public class Asiento {

    @Id
    private String idAsiento;
    private String ubicacion;
    private Double precio;
    private EstadoAsiento estado;

    @ManyToOne
    @JoinColumn(name = "lugar_id")
    private Lugar lugar;
    public Asiento(String idAsiento, String ubicacion, Double precio) {
        this.idAsiento = idAsiento;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.estado = EstadoAsiento.DISPONIBLE;
        this.lugar = lugar;

    }

    public Asiento() {
        this.estado = EstadoAsiento.DISPONIBLE;
    }
}

