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
    //Listar todos
    public List<EnderecoEntrega> ListarEnderecos(){
        return this.enderecoEntregaRepository.findAll();

    }

    //Adicionar Endereco
    public EnderecoEntrega NovoEndereco(EnderecoEntrega endereco){
        return enderecoEntregaRepository.save(endereco);
    }

    //Buscar
    public EnderecoEntrega buscarEnderecoPorId(int id){
        return this.enderecoEntregaRepository.findById(id).orElse(null);
    }

    //Atualizar
    public EnderecoEntrega atualizarEndereco(int id, EnderecoEntrega endereco){
        EnderecoEntrega idEndereco = this.buscarEnderecoPorId(id);
        if (idEndereco == null){
            return null;
        }
        idEndereco.setCep(endereco.getCep());
        return enderecoEntregaRepository.save(endereco);
    }

    //Excluir
    public EnderecoEntrega excluirEndereco(int id){
        EnderecoEntrega idEndereco = this.buscarEnderecoPorId(id);
        if (idEndereco == null){
            return null;
        }
        enderecoEntregaRepository.delete(idEndereco);
        return idEndereco;
    }




}
