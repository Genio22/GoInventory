package com.example.goinventory.Controller;


public class DeliveryManAssign {
     private int id;
    private int invoiceId;
    private String customerName;
    private String phoneNumber;
    private String deliverdBy;
    private String dueDate;
    private String productName;
    private double quantity;
    private double codAmount;

    public DeliveryManAssign(int id, int invoiceId, String customerName, String phoneNumber, String deliverdBy, String dueDate, String productName, double quantity, double codAmount) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.deliverdBy = deliverdBy;
        this.dueDate = dueDate;
        this.productName = productName;
        this.quantity = quantity;
        this.codAmount =codAmount;
    }

    public int getId() { return id; }
    public int getInvoiceId() { return invoiceId; }
    public String getCustomerName() { return customerName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getDeliverdBy() { return deliverdBy; }
    public String getDueDate() { return dueDate; }
    public String getProductName() { return productName; }
    public double getQuantity() { return quantity; }
    public double getCodAmount() { return codAmount; }

}
