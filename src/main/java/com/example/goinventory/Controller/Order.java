package com.example.goinventory.Controller;
public class Order {
    private int invoiceId;
    private String customerName;
    private String phoneNumber;
    private final String address;
    private final String district;
    private final String note;
    private final double amount;
    private final double weight;
    private final String date; 

    public Order(int invoiceId, String customerName, String phoneNumber, String address,
                 String district, String note, double amount, double weight, String date) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.district = district;
        this.note = note;
        this.amount = amount;
        this.weight = weight;
        this.date = date;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() { return address; }
    public String getDistrict() { return district; }
    public String getNote() { return note; }
    public double getAmount() { return amount; }
    public double getWeight() { return weight; }
    public String getDate() { return date; } 
}
