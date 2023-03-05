package com.example.mototracker_2.models;
import lombok.Data;

@Data
public class Person extends User{
    private String name;
    private String phoneNumber;


    public Person(String email, String password,String name, String phoneNumber) {
        super(email, password);
        this.name=name;
        this.phoneNumber= phoneNumber;
    }
}
