package br.com.ecommerce.API.repository;

import br.com.ecommerce.API.model.EnderecoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoEntregaRepository extends JpaRepository<EnderecoEntrega, Integer> {
}
