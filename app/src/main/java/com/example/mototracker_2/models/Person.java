package com.example.mototracker_2.models;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class Person extends User{

    private String name;
    private String phoneNumber;


    public Person(String id,String email, String password,String name, String phoneNumber) {
        super(id,email, password);
        this.name=name;
        this.phoneNumber= phoneNumber;
    }
    public Person(String email, String password,String name, String phoneNumber) {
        super(email, password);
        this.name=name;
        this.phoneNumber= phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getId() {
        return super.getId();
    }

    public String getEmail() {
        return  super.getEmail();
    }

    public String getPassword() {
        return  super.getPassword();
    }

    @Override
    public String toString() {
        return "Person{" +
                super.toString()+
                " name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
