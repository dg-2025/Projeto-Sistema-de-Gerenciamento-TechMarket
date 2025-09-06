package br.com.ecommerce.API.repository;

import br.com.ecommerce.API.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
