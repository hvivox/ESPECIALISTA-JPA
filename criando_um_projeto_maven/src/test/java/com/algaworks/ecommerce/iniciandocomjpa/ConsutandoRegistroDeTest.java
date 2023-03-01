package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.modelo.Produto;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsutandoRegistroDeTest extends EntityManagerTest {



    @Test
    public void buscarPorIdentificador(){
         Produto produto = entityManager.find(Produto.class, 1);

        //realiza a consulta apenas se uma propriedade do objeto for chamada
        //Produto produto = entityManager.getReference(Produto.class, 1);
        //System.out.println(">>>> "+ produto.getNome());
        Assert.assertNotNull( produto );
       Assert.assertEquals("Kindle", produto.getNome());

    }

    @Test //alterando o nome do produto
    public void atualizarReferencia(){
        Produto produto = entityManager.find(Produto.class, 1);

        produto.setNome("Celular A13");
        entityManager.refresh(produto);

        Assert.assertEquals("Kindle", produto.getNome());
    }



}
