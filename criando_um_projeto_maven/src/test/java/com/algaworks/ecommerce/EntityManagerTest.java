package com.algaworks.ecommerce;

import com.algaworks.ecommerce.modelo.Produto;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest {

    protected static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    @BeforeClass //antes de iniciar a classe
    public static void setupBeforeClass(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");


    }

    @AfterClass //após finalizar a classe
    public static void tearDownAfterClass(){
        entityManagerFactory.close();
    }

    @Before // antes de iniciar o metodo
    public void setUp(){
        entityManager = entityManagerFactory.createEntityManager();
    }



    @After // após iniciar o metodo
    public void tearDownAfter(){
        entityManager.close();
    }






}
