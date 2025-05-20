package com.example.goinventory.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class DeliveryMenuController{
    public Button report_button;
    public ImageView profileImages;

    // Database theke data ta ai variable pass korle auto pic change hobe
    String imagepath = "file:/C:/Users/ahnaf/Documents/Lab7/Delivery_Task/src/main/resources/org/Image/Delivery/rider_profile_pic.png";
    void setProfileImages(String path){
        profileImages.setImage(new Image(path));

        Circle clip = new Circle(100, 100, 100); // centerX, centerY, radius
        profileImages.setClip(clip);
    }

    @FXML
    public void initialize() {
        setProfileImages(imagepath);
    }
}