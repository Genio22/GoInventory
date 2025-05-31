package com.example.goinventory.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class AdminDeliveryAssignedController {

    @FXML
    private AnchorPane AssignDeliveryView;

    @FXML
    private TableView<DeliveryManAssign> AssignTable;

    @FXML
    private ComboBox<DeliveryManCombobox> DeliveryManAssign_combox;

    @FXML
    private TextField Invoice_no_search;

    @FXML
    private TextField Last_date_textField;

    @FXML
    private TableColumn<DeliveryManAssign, String> assignCustomer_name;

    @FXML
    private TableColumn<DeliveryManAssign, String> assignDeliverdBy;

    @FXML
    private TableColumn<DeliveryManAssign, String> assignDueDate;

    @FXML
    private TableColumn<DeliveryManAssign, Integer> assignId;

    @FXML
    private TableColumn<DeliveryManAssign, Integer> assignInvoiceId;

    @FXML
    private TableColumn<DeliveryManAssign, String> assignNumber;

    @FXML
    private TableColumn<DeliveryManAssign, String> assignProductName;

    @FXML
    private TableColumn<DeliveryManAssign, Double> assignQuantity;
    @FXML
      private TableColumn<DeliveryManAssign, Double> assign_Cod;

 

 

    private Connection connection;





     @FXML
    public void initialize() throws ClassNotFoundException {
        try {
            connection = DB.getConnection();
        } catch (SQLException e) {
             e.getMessage();
            return;
        }
        assignId.setCellValueFactory(new PropertyValueFactory<>("id"));
        assignInvoiceId.setCellValueFactory(new PropertyValueFactory<>("invoiceId"));
        assignCustomer_name.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        assignNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        assignDeliverdBy.setCellValueFactory(new PropertyValueFactory<>("deliverdBy"));
        assignDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        assignProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        assignQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        assign_Cod.setCellValueFactory(new PropertyValueFactory<>("codAmount"));

        tableload();
        loadDeliveryMen();
    }









public void tableload() {
    ObservableList<DeliveryManAssign> assignOrderList = FXCollections.observableArrayList();
 String query = "SELECT ui.invoice_id, ui.customer_name, ui.phone_number, ui.deliverdby, ui.due_date, ui.quintity, ui.userId, ui.product_id, ui.invoice_id, ui.invoice_id,ui.cod_amount, ui.invoice_id, pi.name " +
                   "FROM user_inventory ui LEFT JOIN productInventory pi ON ui.product_id = pi.id";


    try (Connection connection = DB.getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            assignOrderList.add(new DeliveryManAssign(
                    rs.getInt("invoice_id"),
                    rs.getInt("invoice_id"), 
                    rs.getString("customer_name"),
                    rs.getString("phone_number"),
                    rs.getString("deliverdby"),
                    rs.getString("due_date"),
                    rs.getString("name"),
                    rs.getDouble("quintity"),
                    rs.getDouble("cod_amount")
                    
            ));
        }

        AssignTable.setItems(assignOrderList);
      

    } catch (SQLException e) {
        e.printStackTrace();
    }
}




private void loadDeliveryMen() {
    ObservableList<DeliveryManCombobox> deliveryMenList = FXCollections.observableArrayList();

    String query = "SELECT name, id FROM role_login WHERE role = 'Delivary '";

    try (PreparedStatement pstmt = connection.prepareStatement(query);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            String name = rs.getString("name");
            int id = rs.getInt("id");
            deliveryMenList.add(new DeliveryManCombobox(id, name));
        }

    } catch (SQLException e) {
        e.printStackTrace();
        return;
    }

    DeliveryManAssign_combox.setItems(deliveryMenList);
}









@FXML
void assignbtn(ActionEvent event) {
    DeliveryManAssign selected = AssignTable.getSelectionModel().getSelectedItem();
    String newDueDate = Last_date_textField.getText();
    DeliveryManCombobox selectedDeliveryMan = DeliveryManAssign_combox.getValue();

    if (selected != null && !newDueDate.isEmpty() && selectedDeliveryMan != null) {
        String deliveryManName = selectedDeliveryMan.getName();
        int deliveryManId = selectedDeliveryMan.getId();

        String query = "UPDATE user_inventory SET due_date = ?, deliverdby = ?, deliverymanId = ? WHERE invoice_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, newDueDate);
            pstmt.setString(2, deliveryManName);
            pstmt.setInt(3, deliveryManId);
            pstmt.setInt(4, selected.getInvoiceId());

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Due date and deliveryman assigned.");
                tableload();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


    @FXML
    void assignReset(ActionEvent event) {
      
        Last_date_textField.clear();
        DeliveryManAssign_combox.getSelectionModel().clearSelection();
        tableload();
    }

}