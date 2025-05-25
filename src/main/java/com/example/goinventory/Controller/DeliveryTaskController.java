package com.example.goinventory.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class DeliveryTaskController {
@FXML private TableView<DeliveryManTable> Del_table;
@FXML private TableColumn<DeliveryManTable, String> Customer_name;
@FXML private TableColumn<DeliveryManTable, String> number;
@FXML private TableColumn<DeliveryManTable, String> Location;
@FXML private TableColumn<DeliveryManTable, String> ProductName;
@FXML private TableColumn<DeliveryManTable, Double> Quantity;
@FXML private TableColumn<DeliveryManTable, Double> amount;
@FXML private TableColumn<DeliveryManTable, String> status;
@FXML private TableColumn<DeliveryManTable, String> Due_Date;
@FXML private TableColumn<DeliveryManTable, Integer> Invoice_no;

 private Connection connection;


@FXML
public void initialize() {

    try {
            connection = DB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    Customer_name.setCellValueFactory(new PropertyValueFactory<>("customerName"));
    number.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    Location.setCellValueFactory(new PropertyValueFactory<>("district"));
    ProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
    Quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    amount.setCellValueFactory(new PropertyValueFactory<>("invoiceAmount"));
    status.setCellValueFactory(new PropertyValueFactory<>("status"));
    Due_Date.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
    Invoice_no.setCellValueFactory(new PropertyValueFactory<>("invoiceId"));

    loadTableData();
}


private void loadTableData() {
    ObservableList<DeliveryManTable> list = FXCollections.observableArrayList();
    int currentUserId = IdStore.getloginId();

    String query = """
        SELECT ui.invoice_id, ui.customer_name, ui.phone_number, ui.address,
               ui.district, ui.quintity, ui.status, ui.cod_amount, ui.due_date,
               p.name
        FROM user_inventory ui
        JOIN productinventory p ON ui.product_id = p.id
        WHERE ui.deliverymanId = ? AND ui.status = 'Pending'
    """;

    try (PreparedStatement ps = connection.prepareStatement(query)) {
        ps.setInt(1, currentUserId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new DeliveryManTable(
                rs.getInt("invoice_id"),
                rs.getString("customer_name"),
                rs.getString("phone_number"),
                rs.getString("address"),
                rs.getString("district"),
                rs.getDouble("quintity"),
                rs.getString("status"),
                rs.getDouble("cod_amount"),
                rs.getString("due_date"),
                rs.getString("name")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    Del_table.setItems(list);
}


   @FXML
    void Deliverd(ActionEvent event) {
    DeliveryManTable selectedItem = Del_table.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
        String updateQuery = "UPDATE user_inventory SET status = ? WHERE invoice_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            ps.setString(1, "delivered");
            ps.setInt(2, selectedItem.getInvoiceId());
            ps.executeUpdate();
            loadTableData(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


    @FXML
    void cancel(ActionEvent event) {
        DeliveryManTable selectedItem = Del_table.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
        String updateQuery = "UPDATE user_inventory SET status = ? WHERE invoice_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            ps.setString(1, "Pending");
            ps.setInt(2, selectedItem.getInvoiceId());
            ps.executeUpdate();
            loadTableData(); 
        } catch (SQLException e) {
            e.printStackTrace();
      
    }
}

}
}
