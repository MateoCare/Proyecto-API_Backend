package com.uade.api.ecommerce.ecommerce.controllers;


import com.uade.api.ecommerce.ecommerce.models.Producto;
import com.uade.api.ecommerce.ecommerce.repository.ProductoRepository;
import com.uade.api.ecommerce.ecommerce.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StockController
{
    @Autowired
    private StockService stockService;

    @Autowired
    private ProductoRepository productoRepository;

   /** @DeleteMapping("/bajaStock")
    public void bajaProducto(@RequestBody ProductoDTO productoDTO){

    }

    @PutMapping("/aumentoStock")
    public void aumentoStock(@RequestBody ProductoDTO productoDTO){

    }**/


}