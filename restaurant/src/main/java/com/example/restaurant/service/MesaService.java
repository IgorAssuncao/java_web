package com.example.restaurant.service;

import com.example.restaurant.model.Mesa;
import com.example.restaurant.model.Pedido;
import com.example.restaurant.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MesaService {
    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> listAll() {
        return mesaRepository.findAll();
    }

    public void save(Mesa mesa) {
        mesaRepository.save(mesa);
    }

    public void delete(Long id) {
        mesaRepository.deleteById(id);
    }

    public Mesa getOneById(Long id) {
        return mesaRepository.getOne(id);
    }

    public void addPedido(Mesa mesa, Pedido pedido) {
        Long idMesa = mesa.getIdMesa();
        Long idPedido = pedido.getIdPedido();
        mesaRepository.addPedido(idMesa, idPedido);
    }
}
