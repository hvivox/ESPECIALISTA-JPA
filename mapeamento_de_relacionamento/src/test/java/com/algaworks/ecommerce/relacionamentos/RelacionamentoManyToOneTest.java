package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.*;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoManyToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoItemPedido() {
        Cliente cliente = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);
        pedido.setCliente(cliente);


        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(2);
        itemPedido.setPrecoProduto(BigDecimal.valueOf(20.22));
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);



        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        ItemPedido verificarItemPedido = entityManager.find( ItemPedido.class, 1 );
        System.out.println(">>>>>>>>>>>>"+itemPedido.getProduto().getNome());
        System.out.println(">>>>>>>>>>>>"+itemPedido.getPedido().getStatus());
        Assert.assertNotNull(verificarItemPedido.getPrecoProduto());
    }

    @Test
    public void verificarRelacionamento() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);

        pedido.setCliente(cliente);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getCliente());
    }
}
