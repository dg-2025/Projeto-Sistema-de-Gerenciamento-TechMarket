package br.com.ecommerce.API.repository;

import br.com.ecommerce.API.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
