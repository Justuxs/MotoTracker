package com.example.mototracker_2.models;

import lombok.Data;

@Data
public class User {
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private String email;
    private String password;
}
