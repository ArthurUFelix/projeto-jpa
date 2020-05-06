package br.sc.senai.dao;

import br.sc.senai.model.Phone;
import br.sc.senai.model.User;

import javax.persistence.*;
import java.util.List;

public class PhoneDAOTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("users-db");

        entityManager = factory.createEntityManager();

//        insert();

        listPhones();

        entityManager.close();
        factory.close();
    }

    public static void insert() {
        entityManager.getTransaction().begin();

        Phone phone = new Phone();
        phone.setNumber("(34) 963241589");

        User user = entityManager.find(User.class, 4);
        phone.setUser(user);

        entityManager.persist(phone);

        entityManager.getTransaction().commit();
    }

    public static void listPhones() {
        Query query = entityManager.createNamedQuery("Company.listWhereDDD48");
        List<Phone> phones = query.getResultList();

        for (Phone phone : phones) {
            System.out.println("------------");
            System.out.println(phone.getNumber());
        }
    }
}
