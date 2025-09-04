package br.com.ecommerce.API.repository;

import br.com.ecommerce.API.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // JpaRepository - CRUD

}
