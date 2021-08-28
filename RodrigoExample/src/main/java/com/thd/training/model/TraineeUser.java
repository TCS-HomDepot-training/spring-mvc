package com.thd.training.model;

import javax.persistence.*;

@Entity
@Table(name = "trainee_user", schema = "trainee_schema")
public class TraineeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;

    public TraineeUser() {
    }

    public int getId() {
        return id;
    }

    public TraineeUser setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public TraineeUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getName() {
        return name;
    }

    public TraineeUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public TraineeUser setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
}
