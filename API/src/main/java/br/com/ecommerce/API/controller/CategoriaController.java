package br.com.ecommerce.API.controller;

import br.com.ecommerce.API.model.Categoria;
import br.com.ecommerce.API.service.CatergoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Categoria")
public class CategoriaController {
    private final CatergoriaService catergoriaService;

    public CategoriaController(CatergoriaService Service) {
        this.catergoriaService = Service;
    }
    @GetMapping
    public ResponseEntity<List<Categoria>> ListarCategorias(){
        List<Categoria> categorias = catergoriaService.ListarTodos();
        return ResponseEntity.ok(categorias);
    }
    @PostMapping
    public ResponseEntity<Categoria> AdicionarCategoria(@RequestBody Categoria categoria){
        catergoriaService.NovoCategoria(categoria);
        return ResponseEntity.ok(categoria);
    }
}
