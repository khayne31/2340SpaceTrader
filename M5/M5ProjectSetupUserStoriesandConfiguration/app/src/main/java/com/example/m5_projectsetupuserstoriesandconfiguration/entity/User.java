package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

public class User {

    private String name;
    private int points;
    private int credits;
    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}