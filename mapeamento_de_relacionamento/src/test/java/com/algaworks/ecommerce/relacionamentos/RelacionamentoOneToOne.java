package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.PagamentoCartao;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPagamento;
import org.junit.Assert;
import org.junit.Test;

public class RelacionamentoOneToOne extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoOneToOne(){
        Pedido pedido = entityManager.find(Pedido.class, 1);

        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setPedido(pedido);
        pagamentoCartao.setNumero("10");
        pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);

        entityManager.getTransaction().begin();
        entityManager.persist(pagamentoCartao);
        entityManager.getTransaction().commit();

        entityManager.clear();
        PagamentoCartao verificaPagamentocartao =  entityManager.find(PagamentoCartao.class, 1 );
        Assert.assertNotNull( verificaPagamentocartao.getPedido() );

    }



}
