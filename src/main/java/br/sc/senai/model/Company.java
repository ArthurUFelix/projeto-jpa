package br.sc.senai.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@NamedQueries({
        @NamedQuery(name="Company.listAll", query="select c from Company c"),
        @NamedQuery(name="Company.listAllOrderByName", query="select c from Company c order by c.name"),
})
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<User> Users;

    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(List<User> users) {
        Users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
