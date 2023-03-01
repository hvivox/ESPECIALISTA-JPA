package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.modelo.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoInserirPrimeiroObjeto extends EntityManagerTest {

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

        //O persist joga o objeto para memoria, o clear limpa a memoria
        // Quando a memoria é limpa, o select é impresso na tela no console
        // se tirar o clear não irá mostrar o select porque a consulta do banco não é feita no banco
        entityManager.clear();

        Produto produtoConsultaVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull( produtoConsultaVerificacao );


    }
}
