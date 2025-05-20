package com.example.goinventory.Controller;

public class ProductInventory {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private Category category;

    
    public ProductInventory(int id, String name, int quantity, double price, Category category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    public ProductInventory(String name, int quantity, double price, Category category) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

   
    public int getId() {
        return id;
    }

    // public void setId(int id) {
    //     this.id = id;
    // }

    public String getName() {
        return name;
    }

    // public void setName(String name) {
    //     this.name = name;
    // }

    public int getQuantity() {
        return quantity;
    }

    // public void setQuantity(int quantity) {
    //     this.quantity = quantity;
    // }

    public double getPrice() {
        return price;
    }

    // public void setPrice(double price) {
    //     this.price = price;
    // }

    public Category getCategory() {
        return category;
    }

    // public void setCategory(Category category) {
    //     this.category = category;
    // }
}

