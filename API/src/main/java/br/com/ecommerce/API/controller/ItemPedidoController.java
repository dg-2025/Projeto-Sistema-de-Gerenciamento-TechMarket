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

    @GetMapping("/{id}")
    public ResponseEntity<?> BuscarItemPedidoPorId(@PathVariable int id){
        ItemPedido itemPedido = itemPedidosService.BuscarItemPedidoPorId(id);
        if (itemPedido == null){
            return ResponseEntity.badRequest().body("id não encontrado");
        }
        return ResponseEntity.ok(itemPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> AtualizarItemPedidoPorId(@PathVariable int id, @RequestBody ItemPedido itemPedido){
        ItemPedido itemDoPedido = itemPedidosService.AtualizarItemPedido(id, itemPedido);
        if (itemDoPedido == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(itemDoPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> RemoverItemPedidoPorId(@PathVariable int id){
        ItemPedido itemDoPedido =  itemPedidosService.excluirItemPedido(id);
        if (itemDoPedido == null){
            return ResponseEntity.badRequest().body("id ão encrontrado");

        }
        return ResponseEntity.ok(itemDoPedido);
    }

}
