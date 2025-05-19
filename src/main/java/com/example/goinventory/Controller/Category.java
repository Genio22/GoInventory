package com.example.goinventory.Controller;

public class Category {
    private int id;
    private String category;

    public Category(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public int getId() { return id; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return category; 
    }
}
