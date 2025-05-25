package com.example.goinventory.Controller;

public class Role_login {
    private int id;
    private String name;
    private String email;
    private String mobileNumber;

    public Role_login(int id, String name, String email, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobileNumber() { return mobileNumber; }
}

