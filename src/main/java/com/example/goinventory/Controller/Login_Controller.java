package com.example.goinventory.Controller;

import com.example.goinventory.Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Login_Controller  implements Initializable {
    public Button signin_button;
    private String username, password;
        @FXML
        private PasswordField pass_text;

        @FXML
        private AnchorPane sidePanel;

        @FXML
        private TextField user_text;

    @FXML
    void signin_click(MouseEvent event) {

        this.username = user_text.getText();
        this.password = pass_text.getText();

        if ("Admin".equals(username) && "admin".equals(password)) {
            System.out.println("Login Successful");
            System.out.println(
                    "Username: " + username + " Password: " + password
            );
            System.out.println("Welcome Admin");
        } else {
            System.out.println("Invalid credentials. Access denied.");
            System.out.println(
                    "Username: " + username + " Password: " + password
            );
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


    /**
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signin_button.setOnMouseClicked(event -> Model.getInstance().getViewFactory().showAdminWindows());
    }
}
