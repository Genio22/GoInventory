package com.example.goinventory.Controller;

<<<<<<< Updated upstream
import com.example.goinventory.Model.Employee;
import com.example.goinventory.Database.DB;
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.example.goinventory.Database.DB;
import com.example.goinventory.Model.Employee;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
>>>>>>> Stashed changes
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
<<<<<<< Updated upstream
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;

public class AdminManageRole_Controller {

    @FXML private TableView<Employee> employeeTable;
    @FXML private TableColumn<Employee, Integer> ID;
    @FXML private TableColumn<Employee, String> Name;
    @FXML private TableColumn<Employee, String> MobileNumber;
    @FXML private TableColumn<Employee, String> Email;

    @FXML private TextField name_textField, mobileNumber_textField, Email_textField, salary_textField;
    @FXML private ComboBox<String> location_comboBox, workingStatus_comboBox;
    @FXML private Button save, update, reset, close;

=======
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
 
>>>>>>> Stashed changes
    private final ObservableList<Employee> employeeList = FXCollections.observableArrayList();
    private Connection connection;
    private int selectedEmployeeId = -1;

    @FXML
<<<<<<< Updated upstream
    public void initialize() {
        try {
            connection = DB.getConnection();
        } catch (SQLException e) {
            showAlert("Database Error", e.getMessage());
=======
    public void initialize() throws ClassNotFoundException {
        try {
            connection = DB.getConnection();
        } catch (SQLException e) {
             e.getMessage();
>>>>>>> Stashed changes
            return;
        }

        setupTable();
        loadEmployees();
<<<<<<< Updated upstream
        location_comboBox.getItems().addAll("New York", "Los Angeles", "Chicago", "Dhaka", "Sylhet");
        workingStatus_comboBox.getItems().addAll("Active", "Inactive", "On Leave");

        employeeTable.setOnMouseClicked(e -> populateFields());
    }

=======

        location_comboBox.getItems().addAll("Danmondhi", "Narangang", "cumilla", "Dhaka", "Sylhet");
        workingStatus_comboBox.getItems().addAll("Active", "Inactive", "On Leave");
        Role_comboBox.getItems().addAll("admin", "user", "aka","tas");
        
    }

   

>>>>>>> Stashed changes
    private void setupTable() {
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        MobileNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        employeeTable.setItems(employeeList);
    }

    private void loadEmployees() {
        employeeList.clear();
<<<<<<< Updated upstream
        String query = "SELECT * FROM employees";
=======
        String query = "SELECT * FROM Role_login";
>>>>>>> Stashed changes
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                employeeList.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("mobile_number"),
                        rs.getString("email"),
                        rs.getString("location"),
<<<<<<< Updated upstream
                        rs.getString("working_status"),
=======
                        rs.getString("status"),
>>>>>>> Stashed changes
                        rs.getDouble("salary")
                ));
            }
        } catch (SQLException e) {
<<<<<<< Updated upstream
            showAlert("Load Error", e.getMessage());
=======
           e.printStackTrace();
>>>>>>> Stashed changes
        }
    }

    @FXML
<<<<<<< Updated upstream
    private void handleSave(ActionEvent event) {
        String query = "INSERT INTO employees (name, mobile_number, email, location, working_status, salary) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, name_textField.getText());
            ps.setString(2, mobileNumber_textField.getText());
            ps.setString(3, Email_textField.getText());
            ps.setString(4, location_comboBox.getValue());
            ps.setString(5, workingStatus_comboBox.getValue());
            ps.setDouble(6, Double.parseDouble(salary_textField.getText()));
            ps.executeUpdate();

            showAlert("Success", "Employee added successfully.");
            loadEmployees();
            clearFields();
        } catch (SQLException e) {
            showAlert("Insert Error", e.getMessage());
        }
    }

    @FXML
    private void handleUpdate(ActionEvent event) {
        if (selectedEmployeeId == -1) {
            showAlert("No Selection", "Please select an employee to update.");
            return;
        }

        String query = "UPDATE employees SET name=?, mobile_number=?, email=?, location=?, working_status=?, salary=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, name_textField.getText());
            ps.setString(2, mobileNumber_textField.getText());
            ps.setString(3, Email_textField.getText());
            ps.setString(4, location_comboBox.getValue());
            ps.setString(5, workingStatus_comboBox.getValue());
            ps.setDouble(6, Double.parseDouble(salary_textField.getText()));
            ps.setInt(7, selectedEmployeeId);
            ps.executeUpdate();

            showAlert("Success", "Employee updated successfully.");
            loadEmployees();
            clearFields();
        } catch (SQLException e) {
            showAlert("Update Error", e.getMessage());
        }
    }

    @FXML
    private void handleReset(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void handleClose(ActionEvent event) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    private void populateFields() {
        Employee emp = employeeTable.getSelectionModel().getSelectedItem();
        if (emp != null) {
            selectedEmployeeId = emp.getId();
            name_textField.setText(emp.getName());
            mobileNumber_textField.setText(emp.getMobileNumber());
            Email_textField.setText(emp.getEmail());
            location_comboBox.setValue(emp.getLocation());
            workingStatus_comboBox.setValue(emp.getWorkingStatus());
            salary_textField.setText(String.valueOf(emp.getSalary()));
        }
    }

    private void clearFields() {
        selectedEmployeeId = -1;
        name_textField.clear();
        mobileNumber_textField.clear();
        Email_textField.clear();
        location_comboBox.getSelectionModel().clearSelection();
        workingStatus_comboBox.getSelectionModel().clearSelection();
        salary_textField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
=======
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
>>>>>>> Stashed changes
