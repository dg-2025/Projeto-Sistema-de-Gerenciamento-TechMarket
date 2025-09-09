package br.com.ecommerce.API.service;

import br.com.ecommerce.API.model.ItemPedido;
import br.com.ecommerce.API.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;
    public ItemPedidoService(ItemPedidoRepository Repo) {

        this.itemPedidoRepository = Repo;
    }

    public List<ItemPedido> ListarTodos(){

        return this.itemPedidoRepository.findAll();
    }
    public ItemPedido NovoItemPedido(ItemPedido itemPedido){
        return itemPedidoRepository.save(itemPedido);
    }
}
