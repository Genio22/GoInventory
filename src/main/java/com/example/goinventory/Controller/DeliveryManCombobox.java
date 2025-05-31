package com.example.goinventory.Controller;

public class DeliveryManCombobox {
    private int id;
    private String name;

    public DeliveryManCombobox(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
