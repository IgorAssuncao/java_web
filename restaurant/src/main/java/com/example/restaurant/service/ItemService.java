package com.example.restaurant.service;

import com.example.restaurant.model.Item;
import com.example.restaurant.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> listAll() {
        return itemRepository.findAll();
    }

    public void save(Item item) {
        itemRepository.save(item);
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> listAllByIdPedido(Long id) {
        return itemRepository.findAllByPedidoId(id);
    }

    public Item findById(Long id) {
        return itemRepository.findById(id).get();
    }

    public boolean existsById(Long itemId) {
        return itemRepository.existsById(itemId);
    }
}
