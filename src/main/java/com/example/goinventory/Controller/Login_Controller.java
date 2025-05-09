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
    public Label error_handel;
    @FXML
    private Button signin_button;

    @FXML
    private PasswordField pass_text;

    @FXML
    private TextField user_text;

    @FXML
    private AnchorPane sidePanel;

    private String username, password;

    public void pass_logic(){
        username = user_text.getText();
        password = pass_text.getText();

        if ("Admin".equals(username) && "admin".equals(password)) {
            System.out.println("Login Successful");
            System.out.println("Username: " + username + " Password: " + password);
            System.out.println("Welcome Admin");

            // Open admin window
            //Model.getInstance().getViewFactory().showAdminWindows();//we are accesing viewfactory through static model
            clickLogin();

        } else {
            error_handel.setText("Wrong Username or Password");
            System.out.println("Invalid credentials. Access denied.");
            System.out.println("Username: " + username + " Password: " + password);
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

    //it work when we click
    @FXML
    void signin_click(MouseEvent event) {
        pass_logic();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void clickLogin() {
        Stage loginWindow= (Stage) signin_button.getScene().getWindow();// this help to get the stage as javafx do allow it to do
        Model.getInstance().getViewFactory().closeStage(loginWindow);// close the login
        Model.getInstance().getViewFactory().showAdminWindows();
    }

}
