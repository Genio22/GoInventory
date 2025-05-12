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
                case "Manage_Products" -> admin_parent.setCenter(Model.getInstance().getViewFactory().getManage_product());
                case "View_Order" -> admin_parent.setCenter(Model.getInstance().getViewFactory().getViewOrderView());
                case "Invoice" -> admin_parent.setCenter(Model.getInstance().getViewFactory().getInvoiceView());
                default -> admin_parent.setCenter(Model.getInstance().getViewFactory().getDashboardview());
            }


        });
    }
}
