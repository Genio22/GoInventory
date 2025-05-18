<<<<<<< Updated upstream
package com.example.goinventory.Model;

import java.sql.*;

public class Database {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/inventory";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "admin123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
                System.out.println("✅ Connected to database.");

                String query = "SELECT * FROM users";

                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(query)) {

                    System.out.println("🧾 Data from 'users' table:");
                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("user_id"));
                        System.out.println("Username: " + rs.getString("username"));
                        System.out.println("Password: " + rs.getString("password"));
                        System.out.println("Role: " + rs.getString("role"));
                        System.out.println("--------------------------------------------------");
                    }

                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Error connecting to database.");
            e.printStackTrace();
        }
    }
}
=======
// package com.example.goinventory.Model;

// import java.sql.*;

// public class Database {

//     static final String JDBC_URL = "jdbc:mysql://localhost:3306/inventory";
//     static final String DB_USER = "root";
//     static final String DB_PASSWORD = "Project123";

//     public static void main(String[] args) {
//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");

//             try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
//                 System.out.println(" Connected to database.");

//                 String query = "SELECT * FROM role_login";

//                 try (Statement stmt = conn.createStatement();
//                      ResultSet rs = stmt.executeQuery(query)) {

//                     System.out.println("🧾 Data from 'users' table:");
//                     while (rs.next()) {
//                         System.out.println("ID: " + rs.getInt("user_id"));
//                         System.out.println("Username: " + rs.getString("username"));
//                         System.out.println("Password: " + rs.getString("password"));
//                         System.out.println("Role: " + rs.getString("role"));
//                         System.out.println("--------------------------------------------------");
//                     }

//                 }
//             }
//         } catch (ClassNotFoundException | SQLException e) {
//             System.out.println(" Error connecting to database.");
//             e.printStackTrace();
//         }
//     }
// }
>>>>>>> Stashed changes
