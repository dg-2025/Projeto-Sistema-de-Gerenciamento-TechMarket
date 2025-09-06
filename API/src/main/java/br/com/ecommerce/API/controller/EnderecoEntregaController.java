package br.com.ecommerce.API.controller;

import br.com.ecommerce.API.model.EnderecoEntrega;
import br.com.ecommerce.API.service.EnderecoEntregaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
