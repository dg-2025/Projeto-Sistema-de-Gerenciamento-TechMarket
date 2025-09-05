package br.com.ecommerce.API.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item_pedido", schema = "techmarket")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido idPedido;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto idProduto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

}