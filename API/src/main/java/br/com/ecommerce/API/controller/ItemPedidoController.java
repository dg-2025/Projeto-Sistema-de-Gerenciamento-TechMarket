package br.com.ecommerce.API.controller;


import br.com.ecommerce.API.model.ItemPedido;
import br.com.ecommerce.API.service.ItemPedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itemPedidos")
public class ItemPedidoController {
    private final ItemPedidoService itemPedidosService;

    public ItemPedidoController(ItemPedidoService service) {
        this.itemPedidosService = service;
    }
    @GetMapping
    public ResponseEntity<List<ItemPedido>> getItemPedidos(){
        List<ItemPedido> itemPedidos = itemPedidosService.ListarTodos();
        return ResponseEntity.ok(itemPedidos);
    }
    @PostMapping
    public ResponseEntity<ItemPedido> AdicionarItemPedido(@RequestBody ItemPedido itemPedido){
        itemPedidosService.NovoItemPedido(itemPedido);
        return ResponseEntity.ok(itemPedido);
    }

}
