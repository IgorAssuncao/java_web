package com.example.restaurant.controller;

import com.example.restaurant.model.Item;
import com.example.restaurant.model.Mesa;
import com.example.restaurant.model.Pedido;
import com.example.restaurant.service.ItemService;
import com.example.restaurant.service.MesaService;
import com.example.restaurant.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    private MesaService mesaService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/")
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("mesa", new Mesa());
        HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("itens", itemService.listAll());
        attributes.put("mesas", mesaService.listAll());
        model.addAllAttributes(attributes);
        return modelAndView;
    }

    @PostMapping("/mesa")
    public ModelAndView mesa(@ModelAttribute(name = "mesa") Mesa mesa) {
        ModelAndView modelAndView = new ModelAndView("redirect:/mesa/" + mesa.getIdMesa() + "/cardapio");
        modelAndView.addObject("mesa", mesa);
        return modelAndView;
    }

    @GetMapping("/mesa/{idMesa}/cardapio")
    public ModelAndView cardapio(Model model, @ModelAttribute Mesa mesa) {
        HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("itens", itemService.listAll());
        attributes.put("mesa", mesa);
        model.addAllAttributes(attributes);
        return new ModelAndView("cardapio");
    }

    @PostMapping("/mesa/{idMesa}/pedido/novoPedido")
    public ModelAndView novoPedido(Model model, @ModelAttribute(name = "mesa") Mesa mesa) {
        HashMap<String, Object> attributes = new HashMap<>();
        Pedido pedido = new Pedido(mesa);
        pedido = pedidoService.saveAndGetPedido(pedido);
        attributes.put("itens", itemService.listAll());
        attributes.put("mesa", mesa);
        attributes.put("pedido", pedido);
        model.addAllAttributes(attributes);
        return new ModelAndView("novoPedido");
    }

    @GetMapping("/mesa/{idMesa}/pedido/{idPedido}")
    public ModelAndView statusPedido(Model model, @ModelAttribute(name = "mesa") Mesa mesa, @ModelAttribute(name = "pedido") Pedido pedido) {
        List<Item> itensExistentesPedido = itemService.listAllByIdPedido(pedido.getIdPedido());
        pedido.setItens(itensExistentesPedido);
        pedido.setPrecoTotal(pedidoService.getPrecoTotal(pedido.getIdPedido()));
        HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("mesa", mesa);
        attributes.put("pedido", pedido);
        attributes.put("itensPedido", pedidoService.getAllItens(pedido.getIdPedido()));
        model.addAllAttributes(attributes);
        return new ModelAndView("statusPedido");
    }

    @GetMapping("/mesa/{idMesa}/pedido/{idPedido}/selecionarItens")
    public ModelAndView selecionarItens(Model model, @ModelAttribute(name = "mesa") Mesa mesa, @ModelAttribute(name = "pedido") Pedido pedido) {
        HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("mesa", mesa);
        attributes.put("pedido", pedido);
        attributes.put("itens", itemService.listAll());
        model.addAllAttributes(attributes);
        return new ModelAndView("selecionarItens");
    }

    @PostMapping("/mesa/{idMesa}/pedido/{idPedido}/addItens")
    public ModelAndView addItens(@ModelAttribute(name = "mesa") Mesa mesa, @ModelAttribute(name = "pedido") Pedido pedido) {
        pedidoService.addItens(pedido.getIdPedido(), pedido.getItens());
        pedido.setItens(itemService.listAllByIdPedido(pedido.getIdPedido()));
        pedido.setPrecoTotal(pedidoService.getPrecoTotal(pedido.getIdPedido()));
        pedidoService.updatePrecoTotal(pedido);
        ModelAndView modelAndView = new ModelAndView("redirect:/mesa/" + mesa.getIdMesa() + "/pedido/" + pedido.getIdPedido());
        HashMap<String, Object> objects = new HashMap<>();
        objects.put("mesa", mesa);
        objects.put("pedido", pedido);
        modelAndView.addAllObjects(objects);
        return modelAndView;
    }

    @PostMapping("mesa/{idMesa}/pedido/{idPedido}/fecharPedido")
    public ModelAndView fecharPedido(Model model, @ModelAttribute(name = "mesa") Mesa mesa, @ModelAttribute(name = "pedido") Pedido pedido) {
        mesa.addPedido(pedido);
        mesaService.addPedido(mesa, pedido);
        pedido.setItens(itemService.listAllByIdPedido(pedido.getIdPedido()));
        pedido.setPrecoTotal(pedidoService.getPrecoTotal(pedido.getIdPedido()));
        pedidoService.updatePrecoTotal(pedido);
        HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("mesa", mesa);
        attributes.put("pedido", pedido);
        model.addAllAttributes(attributes);
        return new ModelAndView("fecharPedido");
    }
}
