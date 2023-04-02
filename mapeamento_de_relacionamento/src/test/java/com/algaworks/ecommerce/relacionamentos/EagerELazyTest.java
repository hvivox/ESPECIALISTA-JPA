package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;
import org.junit.Test;

public class EagerELazyTest extends EntityManagerTest {

    @Test
    public void verificarComportamentoEagerLazy(){
        Pedido pedido = entityManager.find( Pedido.class, 1);

        //System.out.println( pedido.getItemPedidoList() );

    }


}
