package br.com.ecommerce.API.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "produto", schema = "ecommerce")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @Column(name = "descricao", nullable = false, length = Integer.MAX_VALUE)
    private String descricao;

    @Column(name = "preco", precision = 10, scale = 4)
    private BigDecimal preco;

    @Column(name = "estoque_disponivel", nullable = false)
    private Integer estoqueDisponivel;

    @Column(name = "imagem_url", length = Integer.MAX_VALUE)
    private String imagemUrl;

    @Column(name = "nome_produto", nullable = false, length = Integer.MAX_VALUE)
    private String nomeProduto;

}