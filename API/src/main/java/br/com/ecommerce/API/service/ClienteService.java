package br.com.ecommerce.API.service;

import br.com.ecommerce.API.model.Cliente;
import br.com.ecommerce.API.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    // injeção de dependencia
    // Falar que Service depende de alguém
    private final ClienteRepository clienteRepository;


    public ClienteService (ClienteRepository repo) {
       clienteRepository = repo;

    }

    //listar
    public List<Cliente> ListarTodos(){
        return clienteRepository.findAll();
    }
}
