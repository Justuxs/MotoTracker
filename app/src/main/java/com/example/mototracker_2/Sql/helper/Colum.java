package com.example.mototracker_2.Sql.helper;

import lombok.Data;

@Data
public class Colum {

    private String name;

    private Type type;

    private boolean primaryKey;

    public Colum(String name, Type type, boolean primaryKey) {
        this.name = name;
        this.type = type;
        this.primaryKey = primaryKey;
    }

    public enum Type {
        NULL,
        INTEGER,
        REAL,
        TEXT,
        BLOB
    }

    @Override
    public String toString() {
        if(primaryKey)return name+" "+type+" "+"PRIMARY KEY";
        return name+" "+type;
    }

    public String getName() {
        return name;
    }
}
