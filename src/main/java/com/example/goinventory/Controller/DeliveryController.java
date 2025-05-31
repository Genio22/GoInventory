package com.example.goinventory.Controller;

import com.example.goinventory.Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DeliveryController {
    @FXML
    private Button logout_button;


    public void onlogout_button(ActionEvent event) {
        Stage stage = (Stage) logout_button.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindows();
    }
}