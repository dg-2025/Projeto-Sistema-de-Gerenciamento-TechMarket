package br.com.ecommerce.API.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "pedido", schema = "techmarket")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_endereco")
    private EnderecoEntrega idEndereco;

    @ColumnDefault("now()")
    @Column(name = "data_pedido", nullable = false)
    private OffsetDateTime dataPedido;

    @Column(name = "valor_total", nullable = false, precision = 18, scale = 4)
    private BigDecimal valorTotal;

    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

}