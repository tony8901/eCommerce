package com.ecommerce.backend.entities;

import com.ecommerce.backend.security.entities.User;
import jakarta.persistence.*;

@Entity
@Table(name = "CLIENTS")
public class Client implements AppUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false, length = 32)
    private String surname;

    @Column(nullable = false, length = 32)
    private String secondSurname;

    @Column
    private String personalAddress;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    User user;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getPersonalAddress() {
        return personalAddress;
    }

    public void setPersonalAddress(String personalAddress) {
        this.personalAddress = personalAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

}
