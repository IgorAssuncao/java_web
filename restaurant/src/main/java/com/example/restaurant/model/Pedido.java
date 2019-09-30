package com.example.restaurant.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idPedido;
    private Long precoTotal;
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany
    private List<Item> itens;
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne
    private Mesa mesa;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.precoTotal = 0L;
    }

    public Pedido(Mesa mesa) {
        this.setMesa(mesa);
        this.itens = new ArrayList<>();
        this.precoTotal = 0L;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Long precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
