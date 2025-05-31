package com.example.goinventory.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.scene.control.Label;

public class DeliveryMenuController implements Initializable {

    @FXML private Label email;
    @FXML private Label id;
    @FXML private Label location;
    @FXML private Text name;
    @FXML private ImageView profileImages;
    @FXML private Label role;
    @FXML private Label user_name;
  

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadUserData();
    }

    private void loadUserData() {
        int currentUserId = IdStore.getloginId();
        String query = "SELECT * FROM role_login WHERE id = ?";

        try (Connection connection = DB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, currentUserId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                id.setText(String.valueOf(rs.getInt("id")));
                name.setText(rs.getString("name"));
                user_name.setText(rs.getString("username"));
                email.setText(rs.getString("email"));
                location.setText(rs.getString("location"));
                role.setText(rs.getString("role"));

                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
