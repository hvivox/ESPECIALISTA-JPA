package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;
import org.junit.Test;

public class OpcionalTest extends EntityManagerTest {

    @Test
    public void verificaComportamentoOpcional(){
        // mapeamento do atributo cliente de Pedido
        Pedido pedido = entityManager.find(Pedido.class, 1);


    }
}
