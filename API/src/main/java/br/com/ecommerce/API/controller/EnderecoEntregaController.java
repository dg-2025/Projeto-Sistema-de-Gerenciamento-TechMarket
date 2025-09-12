package br.com.ecommerce.API.controller;

import br.com.ecommerce.API.model.EnderecoEntrega;
import br.com.ecommerce.API.service.EnderecoEntregaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/EnderecoEntregas")
public class EnderecoEntregaController {
    private final EnderecoEntregaService enderecoEntregaService;

    public EnderecoEntregaController(EnderecoEntregaService service) {
        this.enderecoEntregaService = service;
    }



    @GetMapping
    public ResponseEntity<List<EnderecoEntrega>> getEnderecoEntregas(){
        List<EnderecoEntrega> EnderecosEntregas = enderecoEntregaService.ListarEnderecos();
        return ResponseEntity.ok(EnderecosEntregas);
    }

    @PostMapping
    public ResponseEntity<EnderecoEntrega>  AdicionarEndereco(@RequestBody EnderecoEntrega endereco){
        enderecoEntregaService.NovoEndereco(endereco);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarEnderecoPorId(@PathVariable int id){
        EnderecoEntrega idEndereco = enderecoEntregaService.buscarEnderecoPorId(id);
        if (idEndereco == null){
            return ResponseEntity.badRequest().body("id não encontrado");

        }
        return ResponseEntity.ok(idEndereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarEndereco(@PathVariable int id, @RequestBody EnderecoEntrega endereco){
        EnderecoEntrega idEndereco = enderecoEntregaService.atualizarEndereco(id, endereco);
        if (idEndereco == null){
            return ResponseEntity.badRequest().body("id não encontrado");
        }
        return ResponseEntity.ok(idEndereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerEnderecoPorId(@PathVariable int id){
        EnderecoEntrega idEndereco = enderecoEntregaService.excluirEndereco(id);
        if (idEndereco == null){
            return ResponseEntity.badRequest().body("id não encontrado");
        }
        return ResponseEntity.ok(idEndereco);
    }

}
