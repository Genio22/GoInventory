package com.example.goinventory.Controller;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.goinventory.Model.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class AdminViewOrder_controler {

    @FXML
    private TableView<Role_login> customer_Table;

    @FXML
    private TableColumn<Role_login, Integer> cId;
    @FXML
    private TableColumn<Role_login, String> cname;
    @FXML
    private TableColumn<Role_login, String> cEmail;
    @FXML
    private TableColumn<Role_login, String> cNumber;

    @FXML
    private TableView<userInventory> Product_Table;

    @FXML
    private TableColumn<userInventory, Double> pAmount;
    @FXML
    private TableColumn<userInventory, Integer> Pproduct_Id;
    @FXML
    private TableColumn<userInventory, String> Date;

    private Connection connection;

    public void initialize() {
        try {
            connection = DB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cname.setCellValueFactory(new PropertyValueFactory<>("name"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));

        pAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        Pproduct_Id.setCellValueFactory(new PropertyValueFactory<>("productId"));
        Date.setCellValueFactory(new PropertyValueFactory<>("date"));

        loadUsers();

        customer_Table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                loadUserInventory(newSelection.getId());
            }
        });
    }

    private void loadUsers() {
        ObservableList<Role_login> users = FXCollections.observableArrayList();
        String query = "SELECT id, name, email, mobile_number FROM role_login WHERE role = 'user'";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(new Role_login(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("mobile_number")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        customer_Table.setItems(users);
    }

    private void loadUserInventory(int userId) {
        ObservableList<userInventory> inventories = FXCollections.observableArrayList();
        String query = "SELECT invoice_amount, product_id, date FROM user_inventory WHERE userId = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                inventories.add(new userInventory(
                    rs.getDouble("invoice_amount"),
                    rs.getInt("product_id"),
                    rs.getString("date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Product_Table.setItems(inventories);
    }

    
}
