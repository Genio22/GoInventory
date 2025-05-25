package com.example.goinventory.Controller;

public class DeliveryManTable {
    private String customerName;
    private String phoneNumber;
    private String address;
    private String district;
    private String thana;
    private String note;
    private double codAmount;
    private double invoiceAmount;
    private double quantity;
    private String status;
    private String date;
    private String dueDate;
    private int invoiceId;
    private String productName; // join with product table if needed

    // Constructor
    public DeliveryManTable(int invoiceId, String customerName, String phoneNumber, String address, String district, double quantity, String status, double invoiceAmount, String dueDate, String productName) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.district = district;
        this.quantity = quantity;
        this.status = status;
        this.invoiceAmount = invoiceAmount;
        this.dueDate = dueDate;
        this.productName = productName;
    }

    // Getters
    public int getInvoiceId() { return invoiceId; }
    public String getCustomerName() { return customerName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public String getDistrict() { return district; }
    public double getQuantity() { return quantity; }
    public String getStatus() { return status; }
    public double getInvoiceAmount() { return invoiceAmount; }
    public String getDueDate() { return dueDate; }
    public String getProductName() { return productName; }
}
