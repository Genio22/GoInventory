package com.example.goinventory.Controller;

import com.example.goinventory.Model.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public BorderPane admin_parent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observable, oldValue, newValue) -> {
            switch (newValue){
                case "Manage_Role" -> admin_parent.setCenter(Model.getInstance().getViewFactory().getManageRoleView());
                case "View_Order" -> admin_parent.setCenter(Model.getInstance().getViewFactory().getViewOrderView());
                default -> admin_parent.setCenter(Model.getInstance().getViewFactory().getDashboardview());
            }


        });
    }
}
