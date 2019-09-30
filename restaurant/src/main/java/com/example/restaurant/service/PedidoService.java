package com.example.restaurant.service;

import com.example.restaurant.model.Item;
import com.example.restaurant.model.Pedido;
import com.example.restaurant.repository.ItemRepository;
import com.example.restaurant.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemService itemService;

    public List<Pedido> listAll() {
        return pedidoRepository.findAll();
    }

    public void save(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido saveAndGetPedido(Pedido pedido) {
        if (pedidoRepository.count() == 0) pedido.setIdPedido(1L);
        else pedido.setIdPedido(pedidoRepository.count() + 1L);
        pedidoRepository.save(pedido);

        return pedido;
    }

    public List<Item> getAllItens(Long id) {
        List<Item> itens = new ArrayList<>();
        List<Long> aux = pedidoRepository.getAllItensIds(id);
        for (Long itemId : pedidoRepository.getAllItensIds(id))
            if (itemService.existsById(itemId))
                itens.add(itemService.findById(itemId));
        return itens;
    }


    public void addItens(Long id, List<Item> itens) {
        for (Item item: itens) {
            Long idItem = item.getIdItem();
            pedidoRepository.addItem(id, item.getIdItem());
        }
    }

    public Long getPrecoTotal(Long id) {
        Long precoTotal = 0L;
        List<Item> listaItens = this.getAllItens(id);
        for (Item item: listaItens) {
            precoTotal += item.getPreco();
        }
        return precoTotal;
    }

    public void updatePrecoTotal(Pedido pedido) {
        pedidoRepository.updatePrecoTotal(pedido.getIdPedido(), pedido.getPrecoTotal());
    }
}
