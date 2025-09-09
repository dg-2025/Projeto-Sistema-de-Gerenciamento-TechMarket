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
    private final PagamentoService pagamento;

    public PagamentoController(PagamentoService service){
        this.pagamento = service;

    }
    @GetMapping
    public ResponseEntity<List<Pagamento>> listarPagamentos(){
        List<Pagamento> pagamentos = pagamento.listarPagamentos();
        return ResponseEntity.ok(pagamentos);
    }
    @PostMapping
    public ResponseEntity<Pagamento> salvarPagamento(@RequestBody Pagamento pg){
        pagamento.NovoPagamento(pg);
        return ResponseEntity.status(HttpStatus.CREATED).body(pg);
    }

}
