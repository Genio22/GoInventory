package com.example.goinventory.Controller;

import com.example.goinventory.Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Login_Controller implements Initializable {
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

        if ("Admin".equals(username) && "admin".equals(password)) {
            System.out.println("Login Successful");
            System.out.println("Username: " + username + " Password: " + password);
            System.out.println("Welcome Admin");

            // Open admin window
            Adminview();
        }else if("user".equals(username) && "123".equals(password)){
            System.out.println("Login Successful");
            System.out.println("Username: " + username + " Password: " + password);
            System.out.println("Welcome user");

            // Open user window
            UserView();
        } 
        else {
            System.out.println("Invalid credentials. Access denied.");
            System.out.println("Username: " + username + " Password: " + password);
            error_alert.setText("Invalid credentials. Access denied.");
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
}
