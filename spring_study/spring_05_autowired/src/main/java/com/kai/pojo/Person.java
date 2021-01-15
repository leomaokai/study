package com.kai.pojo;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
public class Person {

    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;

    private String name;

    public Person() {
    }

    public Person(Cat cat, Dog dog, String name) {
        this.cat = cat;
        this.dog = dog;
        this.name = name;
    }
}
