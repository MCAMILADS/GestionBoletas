package com.example.gestionboletas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Asiento {

    @Id
    private String idAsiento;
    private String ubicacion;
    private Double precio;
}

