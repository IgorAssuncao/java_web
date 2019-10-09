package com.example.restaurant.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mesas")
public class Mesa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idMesa;
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany
    private List<Pedido> pedidos;

    public Mesa() {
        this.pedidos = new ArrayList<>();
    }

    public Mesa(Long idMesa) {
        this.idMesa = idMesa;
        this.pedidos = new ArrayList<>();
    }

    public Mesa(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public boolean addPedido(Pedido pedido) {
        return this.getPedidos().add(pedido);
    }
}
