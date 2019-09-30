package com.example.restaurant.repository;

import com.example.restaurant.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
    @Query(value = "SELECT * FROM mesas WHERE id_mesa = :id;", nativeQuery = true)
    Mesa findOneById(Long id);

    @Modifying
    @Query(value = "INSERT INTO mesas_pedidos (mesa_id_mesa, pedidos_id_pedido) VALUES (:idMesa, :idPedido)", nativeQuery = true)
    void addPedido(@Param("idMesa") Long idMesa, @Param("idPedido") Long idPedido);
}
