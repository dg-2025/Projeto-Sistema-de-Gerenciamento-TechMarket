package br.com.ecommerce.API.service;

import br.com.ecommerce.API.model.Pedido;
import br.com.ecommerce.API.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    public PedidoService(PedidoRepository repo) {
        this.pedidoRepository = repo;
    }
    //listar
    public List<Pedido> ListarTodos() {
        return pedidoRepository.findAll();
    }
    //Cadastrar
    public Pedido cadastrarPedido(Pedido pdd){
        return pedidoRepository.save(pdd);
    }
    //Procurar por ID
    public Pedido buscarPedidoPorId(int id){
        return pedidoRepository.findById(id).orElse(null);
    }

    //Atualizar pedido
    public Pedido atualizarPedido(int id, Pedido upPdd){
        Pedido pedidoExistente = buscarPedidoPorId(id);
        if(pedidoExistente == null){
            return null;
        }
        pedidoExistente.setStatus(upPdd.getStatus());
        return pedidoRepository.save(pedidoExistente);
    }

    //Apagar pedido
    public Pedido removerPedido(int id){
        Pedido pedidoExistente = buscarPedidoPorId(id);
        if(pedidoExistente == null){
            return null;
        }
        pedidoRepository.delete(pedidoExistente);
        return pedidoExistente;
    }

}
