package com.example.restaurant.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "itens")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idItem;
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne
    private Pedido pedido;
    private String nome;
    private Long preco;

    public Item() {
    }

    public Item(Pedido pedido, String nome, Long preco) {
        this.pedido = pedido;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
