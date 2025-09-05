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
    public List<Pedido> ListarTodos() {
        return pedidoRepository.findAll();
    }

}
