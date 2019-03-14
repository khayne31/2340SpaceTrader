package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

public class Item {

    private GoodType type;
    private String name;
    private int quantity;
    private int price;

    public Item(GoodType type, String name, int quantity, int price) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public GoodType getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice(){
        return price;
    }

}
