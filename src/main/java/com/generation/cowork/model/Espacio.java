package com.generation.cowork.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "espacios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Espacio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private int capacidad;
    @Column(name = "precio_hora", nullable = false)
    private double precioHora;
    @Column(nullable = false)
    private String descripcion;
    @Column(name = "nombre_categoria", nullable = false)
    private String nombreCategoria;
    @Column(name = "nombre_sede", nullable = false)
    private String nombreSede;
}


