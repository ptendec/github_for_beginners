package com.company;

public class Sneakers {
    private int id;
    private String brand;
    private String name;
    private double price;
    private int size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Sneakers(int id, String brand, String name, double price, int size) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.size = size;
    }
    @Override
    public String toString() {
        return "|"+id + " | " + brand + " | " + name + " | " + price + " | " + size + " | " + "\n";
    }
}
