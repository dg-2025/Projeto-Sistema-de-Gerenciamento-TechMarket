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

    //Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Integer id){
        Cliente cliente = clienteService.buscarClientePorId(id);
        if(cliente == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    // Cadastrar Novo Cliente
    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente novoCliente){
        // 1. tentar cadastrar cliente
        clienteService.cadastrarCliente(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
        //Codigo 201 - CREATE
    }
    //Atualizar um Produto
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Integer id, @RequestBody Cliente novoCliente){
        Cliente clienteAtualizado = clienteService.atualizarCliente(id, novoCliente);
        if(clienteAtualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteAtualizado);
    }

    //Deletar produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> removerCliente(@PathVariable Integer id){
        Cliente deletarCliente = clienteService.deletarCliente(id);
        if(deletarCliente == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletarCliente);
    }



}
