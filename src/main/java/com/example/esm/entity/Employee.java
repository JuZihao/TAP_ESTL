package com.example.esm.entity;

import java.io.Serializable;

/**
 * Employee model
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = -42689494847190913L;

    private String id;

    private String login;

    private String name;

    private Double salary;

    public Employee() {
    }

    public Employee(String id, String login, String name, Double salary) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}

