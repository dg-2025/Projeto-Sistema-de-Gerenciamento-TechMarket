package br.com.ecommerce.API.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "endereco_entrega", schema = "techmarket")
public class EnderecoEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

    @Column(name = "logradouro", nullable = false, length = Integer.MAX_VALUE)
    private String logradouro;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "complemento", length = Integer.MAX_VALUE)
    private String complemento;

    @Column(name = "bairro", nullable = false, length = Integer.MAX_VALUE)
    private String bairro;

    @Column(name = "cidade", nullable = false, length = Integer.MAX_VALUE)
    private String cidade;

    @Column(name = "estado", nullable = false, length = Integer.MAX_VALUE)
    private String estado;

    @Column(name = "cep", nullable = false, length = Integer.MAX_VALUE)
    private String cep;

}