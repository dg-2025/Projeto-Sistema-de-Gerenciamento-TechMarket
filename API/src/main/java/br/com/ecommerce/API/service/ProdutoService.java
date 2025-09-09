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

    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    public Produto cadastrarProduto(Produto prod){
        return produtoRepository.save(prod);
    }
}
