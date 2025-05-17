package com.example.goinventory.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.goinventory.Database.DB;
import com.example.goinventory.Model.Employee;

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

    public ComboBox username_comboBox;
    public ComboBox Role_comboBox;
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
    private TextField name_textField, mobileNumber_textField, Email_textField, salary_textField;
    @FXML
    private ComboBox<String> location_comboBox, workingStatus_comboBox;
    @FXML
    private Button save, update, reset, close;

    private final ObservableList<Employee> employeeList = FXCollections.observableArrayList();
    private Connection connection;
    private int selectedEmployeeId = -1;

    @FXML
    public void initialize() {
        try {
            connection = DB.getConnection();
        } catch (SQLException e) {
            showAlert("Database Error", e.getMessage());
            return;
        }

        setupTable();
        loadEmployees();
        location_comboBox.getItems().addAll("New York", "Los Angeles", "Chicago", "Dhaka", "Sylhet");
        workingStatus_comboBox.getItems().addAll("Active", "Inactive", "On Leave");

        employeeTable.setOnMouseClicked(e -> populateFields());
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
        String query = "SELECT * FROM employees";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                employeeList.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("mobile_number"),
                        rs.getString("email"),
                        rs.getString("location"),
                        rs.getString("working_status"),
                        rs.getDouble("salary")
                ));
            }
        } catch (SQLException e) {
            showAlert("Load Error", e.getMessage());
        }
    }

    @FXML
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
