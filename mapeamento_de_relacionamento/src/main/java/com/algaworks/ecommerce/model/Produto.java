package com.algaworks.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "produto")
public class Produto {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String descricao;

    private BigDecimal preco;
    // nome da tabela a ser criada: @JoinTable( name="produto_categoria",
    // Pk de produto: joinColumns = @JoinColumn(name = "produto_id")
        // produto_id é uma descrição padrão para atriburo não mapeado com @Column
    // PK da tabela Categoria:   inverseJoinColumns = @JoinColumn(name = "categoria_id")
    @ManyToMany
    @JoinTable( name="produto_categoria",
    joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categoriaList;

 }
