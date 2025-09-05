package br.com.ecommerce.API.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categoria", schema = "techmarket")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria", nullable = false)
    private Integer id;

    @Column(name = "nome_categoria", nullable = false, length = Integer.MAX_VALUE)
    private String nomeCategoria;

    @Column(name = "descricao", length = Integer.MAX_VALUE)
    private String descricao;

}