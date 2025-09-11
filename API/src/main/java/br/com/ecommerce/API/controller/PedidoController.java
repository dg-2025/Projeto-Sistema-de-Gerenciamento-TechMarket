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

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPedidoPorId(@PathVariable int id) {
        Pedido pedido = pedidoService.buscarPedidoPorId(id);
        if (pedido == null) {
            return ResponseEntity.badRequest().body("Pedido não encontrado");
        }
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPedido(@PathVariable int id, @RequestBody Pedido pdd) {
        Pedido pedido = pedidoService.atualizarPedido(id, pdd);
        if (pedido == null) {
            return ResponseEntity.badRequest().body("pedido nao encontrado");
        }
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerPedido(@PathVariable int id) {
        Pedido pedido = pedidoService.removerPedido(id);
        if (pedido == null) {
            return ResponseEntity.badRequest().body("pedido nao encontrado");
        }
        return ResponseEntity.ok(pedido);
    }
}
