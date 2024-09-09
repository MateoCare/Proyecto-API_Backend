package com.uade.api.ecommerce.ecommerce.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String imagen;
    @Column
    private Double precio;

    @OneToMany
    private List<StockProducto> stockProductos;
}
