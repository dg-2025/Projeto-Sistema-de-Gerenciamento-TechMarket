package br.com.ecommerce.API.controller;

import br.com.ecommerce.API.model.Cliente;
import br.com.ecommerce.API.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
