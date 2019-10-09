package com.example.restaurant.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "itens")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
//    @Column(nullable = false)
    private Long idItem;
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    private List<Pedido> pedidos;
    private String nome;
    private Long preco;

    public Item() {
    }

    public Item(Long idItem, String nome, Long preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Item(List<Pedido> pedidos, String nome, Long preco) {
        this.pedidos = pedidos;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedido(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (!(obj instanceof Item)) return false;

        return ((Item) obj).getIdItem().equals(this.idItem);
    }
}
