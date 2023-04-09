package com.example.javafx_groupwork;

public class Goods {
    private String name;
    private double price;
    private String index;
    private int number;


    public Goods() {
    }

    public Goods(String name, double price, String index, int number) {
        this.name = name;
        this.price = price;
        this.index = index;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }
}
