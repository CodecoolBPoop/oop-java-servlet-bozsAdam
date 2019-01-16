package com.codecool.servlet;

public class Item {
    private static int counter = 0;
    private Integer id;
    private String name;
    private double price;

    Item(String name,double price){
        Item.counter++;
        this.id = Item.counter;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
