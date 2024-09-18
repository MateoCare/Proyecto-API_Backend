package com.uade.api.ecommerce.ecommerce.repository;

import com.uade.api.ecommerce.ecommerce.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    public List<Producto> findByStatusTrue();

    @Query("SELECT p FROM Producto p JOIN p.categoria pc WHERE pc.id IN :categorias and p.status = true GROUP BY p HAVING COUNT(pc.id) = :cantCategorias")
    public List<Producto> findByCategoriaFiltro(@Param("categorias") List<Long> categorias, @Param("cantCategorias") int cantCategorias);
}
