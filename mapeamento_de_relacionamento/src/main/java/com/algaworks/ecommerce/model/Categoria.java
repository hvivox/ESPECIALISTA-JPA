package com.algaworks.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "categoria")
public class Categoria {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    //@Column(name = "categoria_pai_id")
    @ManyToOne
    @JoinColumn(name = "categoria_pai_id")
    private Categoria categoriaPai;

    @OneToMany(mappedBy = "categoriaPai")
    private List<Categoria> categoriaList;


    // categoriaList é o atributo que está na classe produto
    @ManyToMany(mappedBy = "categoriaList")
    private List<Produto> produtos;
}
