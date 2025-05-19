package com.example.goinventory.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/inventory";
    private static final String USER = "root";
    private static final String PASS = "admin123";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();

        }
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

}
