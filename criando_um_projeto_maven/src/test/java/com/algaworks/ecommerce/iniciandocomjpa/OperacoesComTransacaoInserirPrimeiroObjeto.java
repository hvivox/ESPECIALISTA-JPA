package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.modelo.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoInserirPrimeiroObjeto extends EntityManagerTest {



    @Test
    public void removerObjeto(){
        // são escluidas apenas objetos que estão na memoria, se não estiver na memoria o sistema informa que está desanexado
        // necessário fazer uma alternativa

        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();
            entityManager.remove(produto);
        entityManager.getTransaction().commit();
        entityManager.clear();//não é ncessário utilizar o clean para o remove
        Produto produtoVerificacao = entityManager.find(Produto.class, 3);
        Assert.assertNull(produtoVerificacao);

    }


    @Test
    public void inserirPrimeiroObjeto(){
        Produto produto = new Produto();
        produto.setId(2);
        produto.setNome("Camera Canon");
        produto.setDescricao("A melhor definição de fotos");
        produto.setPreco(new BigDecimal(5000));

        entityManager.getTransaction().begin();
            entityManager.persist(produto);
        entityManager.getTransaction().commit();

       // entityManager.persist(produto);
       // entityManager.flush();// tudo que estiver na memória é formado a ir para banco de dados

        //O persist joga o objeto para memoria, o clear limpa a memoria
        // Quando a memoria é limpa, o select é impresso na tela no console
        // se tirar o clear não irá mostrar o select porque a consulta do banco não é feita no banco
        entityManager.clear();

        Produto produtoConsultaVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull( produtoConsultaVerificacao );


    }
}
