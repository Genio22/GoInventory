// package com.example.goinventory.Controller;
// import java.sql.SQLException;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;

// import com.example.goinventory.Database.DB;
// import com.example.goinventory.Model.Model;
// import javafx.fxml.FXML;
// import javafx.scene.control.Button;
// import javafx.scene.control.TextArea;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.AnchorPane;
// import javafx.scene.layout.Pane;
// import javafx.event.ActionEvent;
// import javafx.stage.Stage;







// public class User_addParcel_controller {
    
    
//     @FXML
//     private TextField address_textField;

//     @FXML
//     private TextField codAmount_textField;

//     @FXML
//     private TextField district_textField;

//     @FXML
//     private TextField invoiceAmout_textField;

//     @FXML
//     private TextField name_textField;

//     @FXML
//     private TextArea note_textField;

//     @FXML
//     private TextField phone_textField;

//     @FXML
//     private TextField thana_textField;

//     @FXML
//     private TextField weight_textField;

//     private Connection connection;


//     @FXML
//     public void initialize() throws ClassNotFoundException {
//         try {
//              connection = DB.getConnection();
//         } catch (SQLException e) {
//              e.getMessage();
//             return;
//         }


        
//     }
//     @FXML
// public void Submit_button(ActionEvent event) {
//     String insertQuery = "INSERT INTO Invoice (customer_name, phone_number, address, district, thana, note, cod_amount, invoice_amount, weight, status) " +
//                          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

//     try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {

       
//         String name = name_textField.getText();
//         String phone = phone_textField.getText();
//         String address = address_textField.getText();
//         String district = district_textField.getText();
//         String thana = thana_textField.getText();
//         String note = note_textField.getText();

//         double codAmount = Double.parseDouble(codAmount_textField.getText());
//         double invoiceAmount = Double.parseDouble(invoiceAmout_textField.getText());
//         double weight = Double.parseDouble(weight_textField.getText());
//         String status = "Pending"; 

        
//         pstmt.setString(1, name);
//         pstmt.setString(2, phone);
//         pstmt.setString(3, address);
//         pstmt.setString(4, district);
//         pstmt.setString(5, thana);
//         pstmt.setString(6, note);
//         pstmt.setDouble(7, codAmount);
//         pstmt.setDouble(8, invoiceAmount);
//         pstmt.setDouble(9, weight);
//         pstmt.setString(10, status);

//         int rowsInserted = pstmt.executeUpdate();
//         if (rowsInserted > 0) {
//             System.out.println(" Invoice added successfully!");
//             // clearForm(); 
//         }

//     } catch (SQLException e) {
//         e.printStackTrace();
//     } catch (NumberFormatException e) {
//         System.err.println(" Please enter valid numeric values for COD, invoice amount, and weight.");
//     }
// }

// }
