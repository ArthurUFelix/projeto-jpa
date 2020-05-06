package br.sc.senai.model;

import javax.persistence.*;

@Entity
@Table(name = "phone")
@NamedQueries({
        @NamedQuery(name="Company.listWhereDDD48", query="select p from Phone p where p.number like '(48)%'"),
})
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String number;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
