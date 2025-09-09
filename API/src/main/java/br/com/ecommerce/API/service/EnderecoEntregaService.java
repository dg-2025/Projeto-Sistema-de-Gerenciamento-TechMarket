package br.com.ecommerce.API.service;

import br.com.ecommerce.API.model.EnderecoEntrega;
import br.com.ecommerce.API.repository.EnderecoEntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoEntregaService {
    private final EnderecoEntregaRepository enderecoEntregaRepository;
    
    public EnderecoEntregaService (EnderecoEntregaRepository repo) {
        this.enderecoEntregaRepository = repo;
        
    }
    public List<EnderecoEntrega> ListarEnderecos(){
        return this.enderecoEntregaRepository.findAll();
        
    }
    public EnderecoEntrega NovoEndereco(EnderecoEntrega endereco){
        return enderecoEntregaRepository.save(endereco);
    }
}
