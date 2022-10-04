package com.cbaser.carmicroapi.model;

import java.io.Serializable;

public class Car implements Serializable {
    private String id;
    private String name;

    public Car(String name){
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

