package br.sc.senai.dao;

import br.sc.senai.model.Company;
import br.sc.senai.model.User;

import javax.persistence.*;
import java.util.List;

public class CompanyDAOTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("users-db");

        entityManager = factory.createEntityManager();

//        insert();

//        listUsers();

        listCompanies();

        entityManager.close();
        factory.close();
    }

    public static void insert() {
        entityManager.getTransaction().begin();

        Company company = new Company();
        company.setName("Dot");

        entityManager.persist(company);

        entityManager.getTransaction().commit();
    }

    public static void listUsers() {
        entityManager.getTransaction().begin();

        Company company = entityManager.find(Company.class, 1);

        List<User> users = company.getUsers();

        for (User user : users) {
            System.out.println("------------");
            System.out.println(user.getFullname());
            System.out.println(user.getEmail());
        }

        entityManager.getTransaction().commit();
    }

    public static void listCompanies() {
        Query query = entityManager.createNamedQuery("Company.listAll");
        List<Company> companies = query.getResultList();

        for (Company company : companies) {
            System.out.println("------------");
            System.out.println(company.getName());
        }
    }
}
