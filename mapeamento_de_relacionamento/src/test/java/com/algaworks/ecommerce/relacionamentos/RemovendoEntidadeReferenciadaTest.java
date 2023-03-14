package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

public class RemovendoEntidadeReferenciadaTest extends EntityManagerTest {

    @Test
    public void removerEntidadeRelacionada(){
        Pedido pedido = entityManager.find(Pedido.class, 1 );

        Assert.assertFalse(pedido.getItemPedidoList().isEmpty());

        entityManager.getTransaction().begin();
        pedido.getItemPedidoList().forEach(i -> entityManager.remove(i));
        entityManager.remove(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();
        Assert.assertFalse(pedido.getItemPedidoList().isEmpty());

    }

}
