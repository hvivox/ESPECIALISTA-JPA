package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoOneToMany extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoItemOneToManyPedido() {
        Cliente cliente = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);
        pedido.setCliente(cliente);


        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(2);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);



        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido verificarPedido = entityManager.find( Pedido.class, pedido.getId() );
        System.out.println(">>>>>>>>>>>>"+verificarPedido.getItemPedidoList().size());
        Assert.assertNotNull(verificarPedido);
    }




    @Test
    public void verificarRelacionamentoOneToManyCliente(){
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

        Cliente clienteVerificacao = entityManager.find( Cliente.class, 1 );
        System.out.println(">>>>>>>>>>>>"+clienteVerificacao.getPedidos().size());
        Assert.assertFalse(clienteVerificacao.getPedidos().isEmpty());


    }

}
