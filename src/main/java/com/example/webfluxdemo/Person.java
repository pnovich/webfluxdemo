package com.example.webfluxdemo;

public class Person {
    private String id;
    private String name;
    private int age;
    private int money;

    public Person(String id, String name, int age, int money) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public Person() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person && this.getId().equals(((Person) o).getId())) {
            return true;
        }
        return false;
    }
}
