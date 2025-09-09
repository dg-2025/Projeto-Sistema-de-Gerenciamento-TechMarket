package br.com.ecommerce.API.controller;

import br.com.ecommerce.API.model.Pedido;
import br.com.ecommerce.API.service.PedidoService;
import br.com.ecommerce.API.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService  pedidoService;

    public PedidoController(PedidoService service, ProdutoService produtoService) {
        this.pedidoService = service;
    }
    @GetMapping
    public ResponseEntity<List<Pedido>> ListarTodos() {
        List<Pedido> pedidos = pedidoService.ListarTodos();
        return ResponseEntity.ok(pedidos);
    }
    @PostMapping
    public ResponseEntity<Pedido> adicionarPedido(@RequestBody Pedido pdd) {
        pedidoService.cadastrarPedido(pdd);
        return ResponseEntity.status(HttpStatus.CREATED).body(pdd);
    }
}
