package com.spring.springboot.resttemplate.model;

public class User {

    private Long id;

    private String name;

    private String lastName;

    private Byte age;

    public User(Long id,String name, String lastName, Byte age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
    public Long getId() { return id; }

    public String getName() { return name; }

    public String getLastName() { return lastName; }

    public Byte getAge() { return age; }

    public void setName(String name) { this.name = name; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setAge(Byte age) { this.age = age; }

    public void setId(Long id) { this.id = id; }

}
