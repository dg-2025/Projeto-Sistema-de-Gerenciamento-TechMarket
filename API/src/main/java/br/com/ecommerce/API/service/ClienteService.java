package br.com.ecommerce.API.service;

import br.com.ecommerce.API.model.Cliente;
import br.com.ecommerce.API.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

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

    //Buscar por id
    public Cliente buscarClientePorId(Integer id){
        return clienteRepository.findById(id).orElse(null);
    }

    //Cadastrar Novo Cliente
    public Cliente cadastrarCliente(Cliente cl){
        cl.setDataCadastro(OffsetDateTime.now());
        return clienteRepository.save(cl);

    }

    //Atualizar cliente
    public Cliente atualizarCliente(Integer id, Cliente novoCliente){
        Cliente ClienteExistente = buscarClientePorId(id);

        if(ClienteExistente == null){
            return null;

        }
        ClienteExistente.setNomeCompleto(novoCliente.getNomeCompleto());
        return  clienteRepository.save(ClienteExistente);
    }

    //Deletar Cliente
    public Cliente deletarCliente(Integer id){
        Cliente cliente = buscarClientePorId(id);
        if(cliente == null){
            return null;
        }
        clienteRepository.delete(cliente);
        return cliente;
    }


}
