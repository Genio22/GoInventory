package com.example.goinventory.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {

    @FXML
    private PieChart pieChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pieChart.getData().addAll(
                new PieChart.Data("Electronics", 40),
                new PieChart.Data("Groceries", 30),
                new PieChart.Data("Clothing", 20),
                new PieChart.Data("Others", 10)
        );

        pieChart.setTitle("Inventory Overview");
        pieChart.setLabelsVisible(true);
        pieChart.setLegendVisible(true);
    }
}
