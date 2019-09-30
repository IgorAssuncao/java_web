package com.example.restaurant.repository;

import com.example.restaurant.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT * FROM itens AS i INNER JOIN pedidos_itens AS pi ON pi.itens_id_item = i.id_item WHERE pi.pedido_id_pedido = :id", nativeQuery = true)
    List<Item> findAllByPedidoId(Long id);
}
