package com.example.goinventory.Controller;

public class ProductInventory {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private Category category;
    private int invoiceId;
    
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

   

    public String getName() {
        return name;
    }

    

    public int getQuantity() {
        return quantity;
    }

   

    public double getPrice() {
        return price;
    }

    

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public int getInvoiceId() {
    return invoiceId;
}
    
}

