package br.sc.senai.dao;

import br.sc.senai.model.Phone;
import br.sc.senai.model.User;

import javax.persistence.*;

public class PhoneDAOTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("users-db");

        entityManager = factory.createEntityManager();

//        insert();

        entityManager.close();
        factory.close();
    }

    public static void insert() {
        entityManager.getTransaction().begin();

        Phone phone = new Phone();
        phone.setNumber("48 932145678");

        User user = entityManager.find(User.class, 4);
        phone.setUser(user);

        entityManager.persist(phone);

        entityManager.getTransaction().commit();
    }
}
