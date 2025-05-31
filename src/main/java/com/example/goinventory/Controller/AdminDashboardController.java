package com.example.goinventory.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdminDashboardController  {

    @FXML
    private Text ActiveDelivery;

    @FXML
    private Text AssignDelivery;

    @FXML
    private Text Deliverd;

    @FXML
    private Text notAssign;

    @FXML
    private PieChart pieChart;

    private Connection connection;

 

    @FXML
    public void initialize() throws SQLException {
         try {
            connection = DB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadDashboardData();
    }

    private void loadDashboardData() throws SQLException {
        

            // Delivered  count
            String deliveredQuery = "SELECT COUNT(*) FROM user_inventory WHERE status = 'delivered'";
            int deliveredCount = getCount(connection, deliveredQuery);

            // Assigned deliveries
            String assignedQuery = "SELECT COUNT(*) FROM user_inventory WHERE deliverdby IS NOT NULL AND deliverdby <> ''";
            int assignedCount = getCount(connection, assignedQuery);

            // Not assigned deliveries
            String notAssignedQuery = "SELECT COUNT(*) FROM user_inventory WHERE deliverdby IS NULL OR deliverdby = ''";
            int notAssignedCount = getCount(connection, notAssignedQuery);

            // Active delivery man
            String activeDeliveryQuery = "SELECT COUNT(*) FROM role_login WHERE status = 'Active' AND role = 'Delivary '";
            int activeDeliveryCount = getCount(connection, activeDeliveryQuery);

            // Pending deliveries
            String pendingQuery = "SELECT COUNT(*) FROM user_inventory WHERE status = 'Pending'";
            int pendingCount = getCount(connection, pendingQuery);

            // Update ui
            AssignDelivery.setText(String.valueOf(assignedCount));
            notAssign.setText(String.valueOf(notAssignedCount));
            Deliverd.setText(String.valueOf(deliveredCount));
            ActiveDelivery.setText(String.valueOf(activeDeliveryCount));

            pieChart.getData().clear();
            pieChart.getData().add(new PieChart.Data("Delivered", deliveredCount));
            pieChart.getData().add(new PieChart.Data("Pending", pendingCount));

        
    }

    private int getCount(Connection conn, String query) throws SQLException {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            return rs.next() ? rs.getInt(1) : 0;
        }
    }
}
