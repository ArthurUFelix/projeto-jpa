package br.sc.senai.dao;

import br.sc.senai.model.Empresa;
import br.sc.senai.model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaDAOTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("users-db");

        entityManager = factory.createEntityManager();

//        insert();

        find();

        entityManager.close();
        factory.close();
    }

    public static void insert() {
        entityManager.getTransaction().begin();

        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome("Arthur");
        novaPessoa.setSobrenome("Felix");
        novaPessoa.setCpf("02365478912");

        Empresa empresa = entityManager.find(Empresa.class, 1);
        novaPessoa.setEmpresa(empresa);

        entityManager.persist(novaPessoa);

        entityManager.getTransaction().commit();
    }

    public static void find() {
        entityManager.getTransaction().begin();

        Pessoa pessoa = entityManager.find(Pessoa.class, 2);

        System.out.println("Pessoa: " + pessoa.getNome() + " " + pessoa.getSobrenome());
        System.out.println("Empresa: " + pessoa.getEmpresa().getNome());

        entityManager.getTransaction().commit();
    }
}
