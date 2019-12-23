package com.test.demo.user.model;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String name;

    private String pass;

    private Integer age;

    private String sex;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
}