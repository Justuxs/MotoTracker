package com.example.mototracker_2.models;

import java.util.UUID;

import lombok.Data;
import lombok.Getter;

@Data
public class User {
    public User(String id,String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    public User(String email, String password) {
        this.id = UUID.randomUUID().toString();;
        this.email = email;
        this.password = password;
    }

    private String id;
    private String email;
    private String password;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
