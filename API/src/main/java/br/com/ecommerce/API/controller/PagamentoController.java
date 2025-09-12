package br.com.ecommerce.API.controller;

import br.com.ecommerce.API.model.Pagamento;
import br.com.ecommerce.API.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService service){
        this.pagamentoService = service;
    }
    @GetMapping
    public ResponseEntity<List<Pagamento>> listarPagamentos(){
        List<Pagamento> pagamentos = pagamentoService.listarPagamentos();
        return ResponseEntity.ok(pagamentos);
    }

    @PostMapping
    public ResponseEntity<Pagamento> salvarPagamento(@RequestBody Pagamento pg){
        pagamentoService.NovoPagamento(pg);
        return ResponseEntity.status(HttpStatus.CREATED).body(pg);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPagamentoPorId(@PathVariable int id){
        Pagamento pagamento = pagamentoService.buscarPagamentoPorId(id);
        if (pagamento == null){
            return ResponseEntity.badRequest().body("id não encontrado");
        }
        return ResponseEntity.ok(pagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPagamento(@PathVariable int id, @RequestBody Pagamento pg){
        Pagamento pagamento = pagamentoService.editarPagamento(id, pg);
        if (pagamento == null){
            return null;
        }
        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPagamento(@PathVariable int id){
        Pagamento pagamento = pagamentoService.excluirPagamento(id);
        if (pagamento == null){
            return null;
        }
        return ResponseEntity.ok(pagamento);
    }


}
