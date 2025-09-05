package br.com.ecommerce.API.repository;
import br.com.ecommerce.API.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
