package com.example.goinventory.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.goinventory.Model.Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AdminController implements Initializable {

    private static final Logger log = LogManager.getLogger(AdminController.class);
    public BorderPane admin_parent;
    public Button logout_button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "Manage_Role" ->
                    admin_parent.setCenter(Model.getInstance().getViewFactory().getManageRoleView());
                case "Manage_Products" ->
                    admin_parent.setCenter(Model.getInstance().getViewFactory().getManage_product());
                case "Assign_Delivery" ->
                    admin_parent.setCenter(Model.getInstance().getViewFactory().getAssignDeliveryView());
                case "View_Order" ->
                    admin_parent.setCenter(Model.getInstance().getViewFactory().getViewOrderView());
                default ->
                    admin_parent.setCenter(Model.getInstance().getViewFactory().getDashboardview());
            }

        });
    }

    @FXML

    public void onlogout_button(ActionEvent event) {
        Stage stage = (Stage) logout_button.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindows();
    }
}