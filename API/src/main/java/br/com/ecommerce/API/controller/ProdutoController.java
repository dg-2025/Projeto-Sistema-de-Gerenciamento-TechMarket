package br.com.ecommerce.API.controller;

import br.com.ecommerce.API.model.Produto;
import br.com.ecommerce.API.repository.ProdutoRepository;
import br.com.ecommerce.API.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/{id}")
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto prod){
        produtoService.cadastrarProduto(prod);
        return ResponseEntity.ok(prod);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoid(@PathVariable int id){
        Produto produto = produtoService.buscarProduto(id);
        if (produto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable int id,@RequestBody Produto UPprod){
        Produto produtoAtualizado = produtoService.atualizarProduto(id, UPprod);
        if (produtoAtualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletarProduto(@PathVariable int id){
        Produto deletarProdduto = produtoService.excluirProduto(id);
        if (deletarProdduto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletarProdduto);
    }

}
