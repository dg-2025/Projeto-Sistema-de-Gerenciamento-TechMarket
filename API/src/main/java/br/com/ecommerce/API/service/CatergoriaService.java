package br.com.ecommerce.API.service;

import br.com.ecommerce.API.model.Categoria;
import br.com.ecommerce.API.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CatergoriaService {
    private final CategoriaRepository categoriaRepository;
    public CatergoriaService(CategoriaRepository repo) {
        categoriaRepository = repo;
    }
    public List<Categoria> ListarTodos() {
        return categoriaRepository.findAll();
    }
}
