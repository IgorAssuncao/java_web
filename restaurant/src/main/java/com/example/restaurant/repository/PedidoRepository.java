package com.example.restaurant.repository;

import com.example.restaurant.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query(value = "SELECT itens_id_item FROM pedidos_itens WHERE pedido_id_pedido = :id", nativeQuery = true)
    List<Long> getAllItensIds(@Param("id") Long id);

    @Modifying
    @Query(value = "INSERT INTO pedidos_itens (pedido_id_pedido, itens_id_item) VALUES (:id, :idItem)", nativeQuery = true)
    void addItem(@Param("id") Long id, @Param("idItem") Long idItem);

    @Modifying
    @Query(value = "UPDATE pedidos SET preco_total = :precoTotal WHERE id_pedido = :id", nativeQuery = true)
    void updatePrecoTotal(@Param("id") Long id, @Param("precoTotal") Long precoTotal);
}
