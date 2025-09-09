package br.com.ecommerce.API.controller;

import br.com.ecommerce.API.model.Cliente;
import br.com.ecommerce.API.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService service) {
        this.clienteService = service;
    }
    //listar Todos
    @GetMapping
    public ResponseEntity<List<Cliente>> ListarClientes() {
            List<Cliente> clientes = clienteService.ListarTodos();
        return ResponseEntity.ok(clientes);

    }
    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente novoCliente){
        // 1. tentar cadastrar cliente
        clienteService.cadastrarCliente(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
        //Codigo 201 - CREATE
    }

}
