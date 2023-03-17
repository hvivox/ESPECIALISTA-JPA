package com.algaworks.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @OneToOne(optional = false)
    @JoinColumn( name = "pepido_id")
    private Pedido pedido;

    private String xml;

    @Column(name = "data_emissao")
    private Date dataEmissao;



}
