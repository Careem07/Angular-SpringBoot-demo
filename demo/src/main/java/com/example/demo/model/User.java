package com.example.demo.model;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@NamedQuery(name = "User.getAllUsers", query = "select u from User u")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String salary;


    public User(int id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public User() {
        System.out.println("User.User");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
