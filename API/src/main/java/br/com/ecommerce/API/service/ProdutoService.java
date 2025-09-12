package br.com.ecommerce.API.service;

import br.com.ecommerce.API.model.Produto;
import br.com.ecommerce.API.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository Repo) {
        this.produtoRepository = Repo;
    }

    //listar todos
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    //adicionar
    public Produto cadastrarProduto(Produto prod){
        return produtoRepository.save(prod);
    }

    //Buscar
    public Produto buscarProduto(int id){
        return produtoRepository.findById(id).orElse(null);
    }

    //Atulizar
    public Produto atualizarProduto(int id, Produto autualizarProduto){
        Produto produtoExistente = buscarProduto(id);
        if(produtoExistente == null) {
            return null;
        }

        produtoExistente.setNomeProduto(autualizarProduto.getNomeProduto());
        return produtoRepository.save(produtoExistente);
    }

    //Excluir
    public Produto excluirProduto(int id){
        Produto produtoExistente = buscarProduto(id);
        if(produtoExistente == null) {
            return null;
        }
        produtoRepository.delete(produtoExistente);
        return produtoExistente;
    }

}
