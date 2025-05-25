package com.example.goinventory.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


import com.example.goinventory.Model.Employee;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminManageRole_Controller {
   
    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, Integer> ID;
    @FXML
    private TableColumn<Employee, String> Name;
    @FXML
    private TableColumn<Employee, String> MobileNumber;
    @FXML
    private TableColumn<Employee, String> Email;
    @FXML
    private TableColumn<Employee, String>  username;
   

    @FXML
    private TextField name_textField, mobileNumber_textField, Email_textField, salary_textField,username_textFild;
    @FXML
    private ComboBox<String> location_comboBox, workingStatus_comboBox, Role_comboBox;
    @FXML
    private Button save, update, reset, close;
 
    private final ObservableList<Employee> employeeList = FXCollections.observableArrayList();
    private Connection connection;
    private int selectedEmployeeId = -1;

    @FXML
    public void initialize() throws ClassNotFoundException {
        try {
            connection = DB.getConnection();
        } catch (SQLException e) {
             e.getMessage();
            return;
        }

        setupTable();
        loadEmployees();

        location_comboBox.getItems().addAll("Danmondhi", "Narangang", "cumilla", "Dhaka", "Sylhet");
        workingStatus_comboBox.getItems().addAll("Active", "Inactive", "On Leave");
        Role_comboBox.getItems().addAll("admin", "user", "Delivary ");
        
    }

   

    private void setupTable() {
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        MobileNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        employeeTable.setItems(employeeList);
    }

    private void loadEmployees() {
        employeeList.clear();
        String query = "SELECT * FROM Role_login";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                employeeList.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("mobile_number"),
                        rs.getString("email"),
                        rs.getString("location"),
                        rs.getString("status"),
                        rs.getDouble("salary")
                ));
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    @FXML
void handleClose(ActionEvent event) {
    Stage stage = (Stage) close.getScene().getWindow();
    stage.close();
}


    @FXML
void handleReset(ActionEvent event) {
    resetForm();
}

private void resetForm() {
    name_textField.clear();
    mobileNumber_textField.clear();
    Email_textField.clear();
    username_textFild.clear();
    salary_textField.clear();
    location_comboBox.getSelectionModel().clearSelection();
    workingStatus_comboBox.getSelectionModel().clearSelection();
}


    @FXML
void handleSave(ActionEvent event) {
    String name = name_textField.getText();
    String mobile = mobileNumber_textField.getText();
    String email = Email_textField.getText();
    String role = Role_comboBox.getValue();
    String username = username_textFild.getText();
    String location = location_comboBox.getValue();
    String status = workingStatus_comboBox.getValue();
    double salary = Double.parseDouble(salary_textField.getText());

   
    String checkQuery = "SELECT COUNT(*) FROM Role_login WHERE username = ?";
    try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
        checkStmt.setString(1, username);
        ResultSet rs = checkStmt.executeQuery();
        rs.next();
        if (rs.getInt(1) > 0) {
            showAlert("Username already exists. Please choose a different one.");
            return;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return;
    }

   
    String query = "INSERT INTO Role_login (name, mobile_number, email, role, username, location, status, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        pstmt.setString(1, name);
        pstmt.setString(2, mobile);
        pstmt.setString(3, email);
        pstmt.setString(4, role);
        pstmt.setString(5, username);
        pstmt.setString(6, location);
        pstmt.setString(7, status);
        pstmt.setDouble(8, salary);
        pstmt.executeUpdate();

        loadEmployees();
        resetForm();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


   @FXML
void handleUpdate(ActionEvent event) {
    Employee selected = employeeTable.getSelectionModel().getSelectedItem();
    if (selected == null) return;

    String username = username_textFild.getText();

    
    String checkQuery = "SELECT COUNT(*) FROM Role_login WHERE username = ? AND id != ?";
    try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
        checkStmt.setString(1, username);
        checkStmt.setInt(2, selected.getId());
        ResultSet rs = checkStmt.executeQuery();
        rs.next();
        if (rs.getInt(1) > 0) {
            showAlert("Username already exists.");
            return;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return;
    }

   
    String query = "UPDATE Role_login SET name = ?, mobile_number = ?, email = ?, username = ?, role = ?, location = ?, status = ?, salary = ? WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        pstmt.setString(1, name_textField.getText());
        pstmt.setString(2, mobileNumber_textField.getText());
        pstmt.setString(3, Email_textField.getText());
        pstmt.setString(4, username);
        pstmt.setString(5, Role_comboBox.getValue());
        pstmt.setString(6, location_comboBox.getValue());
        pstmt.setString(7, workingStatus_comboBox.getValue());
        pstmt.setDouble(8, Double.parseDouble(salary_textField.getText()));
        pstmt.setInt(9, selected.getId());

        pstmt.executeUpdate();
        loadEmployees();
        resetForm();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void showAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Validation Error");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}


    
}
