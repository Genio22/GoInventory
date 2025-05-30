package com.example.goinventory.Controller;

import com.example.goinventory.Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Login_Controller implements Initializable {
    public Hyperlink singup_hyperlink;
    @FXML
    private Label error_alert;
    @FXML
    private Button signin_button;
    @FXML
    private PasswordField pass_text;
    @FXML
    private TextField user_text;
    @FXML
    private AnchorPane sidePanel;

    private String username, password;



    @FXML
    void signin_click(MouseEvent event) {
        username = user_text.getText();
        password = pass_text.getText();
        
        String sql = "SELECT * FROM Role_login WHERE username = ? AND password = ? ";

        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
         
             stmt.setString(1, username);
            stmt.setString(2, password); 
        

           
            ResultSet rs = stmt.executeQuery();


            if (rs.next()) {
                 int userId = rs.getInt("id"); 
                 IdStore.setloginId(userId);

            String role = rs.getString("role");
            if ("admin".equalsIgnoreCase(role)) {
                Adminview();
            } else if ("user".equalsIgnoreCase(role)) {
                UserView();
                
            } else if ("Delivary ".equalsIgnoreCase(role)) {
                DeliveryView();
            } else {
                System.out.println("Unknown role: " + role);
            }
        } else {
            System.out.println("Invalid username or password.");
        }

        } catch (Exception e) {
            e.printStackTrace();
       
        }
        
       
    }

    @FXML
    void username(ActionEvent event) {
        this.username = user_text.getText();
    }

    @FXML
    void password(ActionEvent event) {
        this.password = pass_text.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void Adminview(){
        Stage stage = (Stage) signin_button.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showAdminWindows();
    }

    public void UserView(){
        Stage stage = (Stage) signin_button.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showUserWindows();
    }

    public void DeliveryView(){
        Stage stage = (Stage) signin_button.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showDeliveryWindows();
    }

    public void singup_hyper_act(ActionEvent event) {
        Stage stage = (Stage) signin_button.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showRegistrationWindows();
    }
}