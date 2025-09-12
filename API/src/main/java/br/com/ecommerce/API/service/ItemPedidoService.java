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
    //Listar
    public List<ItemPedido> ListarTodos(){
        return this.itemPedidoRepository.findAll();
    }
    //Adicionar
    public ItemPedido NovoItemPedido(ItemPedido itemPedido){
        return itemPedidoRepository.save(itemPedido);
    }
    //Buscar
    public ItemPedido BuscarItemPedidoPorId(int id){
        return itemPedidoRepository.findById(id).orElse(null);
    }

    //Atualizar
    public ItemPedido AtualizarItemPedido(int id, ItemPedido itemPedido){
        ItemPedido BuscarItemPedidoPorId = BuscarItemPedidoPorId(id);
        if (BuscarItemPedidoPorId == null){
            return null;
        }
        BuscarItemPedidoPorId.setQuantidade(itemPedido.getQuantidade());
        return itemPedidoRepository.save(itemPedido);
    }

    //Excluir
    public ItemPedido excluirItemPedido(int id){
        ItemPedido BuscarItemPedidoPorId = BuscarItemPedidoPorId(id);
        if (BuscarItemPedidoPorId == null){
            return null;
        }
        itemPedidoRepository.delete(BuscarItemPedidoPorId);
        return BuscarItemPedidoPorId;
    }
}
