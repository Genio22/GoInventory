package com.example.goinventory.Controller;

import com.example.goinventory.Model.Model;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class registration_Controller {
    public TextField user_text;
    public PasswordField pass_text;
    public Button signup_button;
    public TextField name_field;
    public TextField email_field;
    public Hyperlink login_hyperlink;

    public void username(ActionEvent event) {
    }

    public void password(ActionEvent event) {
    }


    public void signup_click(MouseEvent mouseEvent) {
        String username = user_text.getText().trim();
        String password = pass_text.getText().trim();
        String name = name_field.getText().trim();
        String email = email_field.getText().trim();

        if (username.isEmpty() || password.isEmpty() || name.isEmpty() || email.isEmpty()) {
            System.out.println("Please fill all fields.");
            return;
        }

        String sql = "INSERT INTO Role_login (username, password, name, email, role) VALUES (?, ?, ?, ?, ?)"; // sql quari insert kore dis , amni akta dichi

        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, name);
            stmt.setString(4, email);
            stmt.setString(5, "user"); // default role

            int rowsInserted = stmt.executeUpdate(); // insert check kore
            if (rowsInserted > 0) {
                System.out.println("User registered successfully!");

                // Switch back korbe login window te
                Stage stage = (Stage) signup_button.getScene().getWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
                Model.getInstance().getViewFactory().showLoginWindows();
            } else {
                System.out.println("User registration failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void loginin_hyper_act(ActionEvent event) {
        Stage stage = (Stage) signup_button.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindows();
    }
}
