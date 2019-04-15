package com.lbs.bddworkshop.dao.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "useer")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;

    public User(){

    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
