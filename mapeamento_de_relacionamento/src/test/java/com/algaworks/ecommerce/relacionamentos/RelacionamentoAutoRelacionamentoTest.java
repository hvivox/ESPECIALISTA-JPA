package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;
import org.junit.Assert;
import org.junit.Test;

public class RelacionamentoAutoRelacionamentoTest extends EntityManagerTest {


    @Test
    public void verificarAutoRelacionamento() {
        //entityManager.find(Cliente.class, 1);


        Categoria categoriaPai = new Categoria();
        categoriaPai.setNome("Eletrônico");

        Categoria categoria = new Categoria();
        categoria.setNome("Celular");
        categoria.setCategoriaPai(categoriaPai);

        entityManager.getTransaction().begin();

        entityManager.persist(categoriaPai);
        entityManager.persist(categoria);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find( Categoria.class, categoria.getId() );
        System.out.println(">>>>>>>>>>>>>>>>>>>"+categoriaVerificacao.getNome());
        Assert.assertNotNull(categoriaVerificacao.getNome());

    }
}
