package br.com.ecommerce.API.controller;

import br.com.ecommerce.API.model.Produto;
import br.com.ecommerce.API.repository.ProdutoRepository;
import br.com.ecommerce.API.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produto")


public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoRepository Serveci) {
        this.produtoService = new ProdutoService(Serveci);
    }
    @GetMapping
    public ResponseEntity<List<Produto>> ListarProdutos() {
        List<Produto> Produto = produtoService.listaProdutos();
        return ResponseEntity.ok(Produto);
    }
}
