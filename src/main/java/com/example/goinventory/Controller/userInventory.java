package com.example.goinventory.Controller;

public class userInventory {
    private double amount;
    private int productId;
    private String date;

    public userInventory(double amount, int productId, String date) {
        this.amount = amount;
        this.productId = productId;
        this.date = date;
    }

    public double getAmount() { return amount; }
    public int getProductId() { return productId; }
    public String getDate() { return date; }
}
