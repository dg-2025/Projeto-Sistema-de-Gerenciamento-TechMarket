package br.com.ecommerce.API.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categoria", schema = "ecommerce")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id", nullable = false)
    private Integer id;

    @Column(name = "nome_categoria", nullable = false, length = Integer.MAX_VALUE)
    private String nomeCategoria;

    @Column(name = "descricao", nullable = false, length = Integer.MAX_VALUE)
    private String descricao;

}