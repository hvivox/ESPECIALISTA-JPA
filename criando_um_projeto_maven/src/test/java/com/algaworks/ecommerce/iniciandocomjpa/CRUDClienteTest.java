package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.modelo.Cliente;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;

public class CRUDClienteTest extends EntityManagerTest {

    @Test
    public void inserirCliente(){
        Cliente cliente = new Cliente();
        cliente.setId(3);
        cliente.setNome( "Roberto" );

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        //System.out.println( "<<<<<<<<<<<<<<<<<<<<<<<"+cliente.getNome() );

       entityManager.clear();
       Cliente verificaCliente = entityManager.find(Cliente.class, 1);
        Assert.assertEquals("Roberto", cliente.getNome());
       Assert.assertNotNull(verificaCliente);
    }

    @Test
    public void buscaClientePorId(){
        Cliente clienteEncontrado = entityManager.find(Cliente.class, 1);
        Assert.assertEquals("Godolfredo", clienteEncontrado.getNome() );
    }


    @Test
    public void atualizaCliente(){
        Cliente cliente = new Cliente();
        cliente.setId(3);
        cliente.setNome( "Roberto Atualizado" );

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        //System.out.println( "<<<<<<<<<<<<<<<<<<<<<<<"+cliente.getNome() );

        entityManager.clear();
        Cliente verificaCliente = entityManager.find(Cliente.class, 3);
        Assert.assertEquals("Roberto Atualizado", cliente.getNome());
        //Assert.assertNotNull(verificaCliente);
    }


    @Test
    public void removeCliente(){
        Cliente clienteEncontrado = entityManager.find(Cliente.class, 1);

        entityManager.getTransaction().begin();
        entityManager.remove(clienteEncontrado);
        entityManager.getTransaction().commit();

        Assert.assertNotNull(clienteEncontrado);
    }



}
