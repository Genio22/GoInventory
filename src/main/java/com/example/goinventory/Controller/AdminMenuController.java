package com.example.goinventory.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.goinventory.Model.Model;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AdminMenuController implements Initializable {

    public Button report_button;
    public Button Dashboard_button;
    public Button Manage_Users_Role_button;
    public Button Product_Inventory_button;
    public Button View_Order_button;
    public Button Invoices_button;
    public Button AssignDelivery_button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Dashboard_button.setOnAction(event -> onDashboard());
        Product_Inventory_button.setOnAction(event -> onManageProduct());
        Manage_Users_Role_button.setOnAction(event -> onManage_Users_Role());
        View_Order_button.setOnAction(event -> onView_Order());
//        Invoices_button.setOnAction(event -> onInvoice());
        AssignDelivery_button.setOnAction(event -> onAssignDelivery());
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("Dashboard");
    }

    private void onManageProduct() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("Manage_Products");
    }

    private void onManage_Users_Role() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("Manage_Role");
    }

    private void onInvoice() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("Invoice");
    }

    private void onView_Order() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("View_Order");
    }

    private void onAssignDelivery() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("Assign_Delivery");
    }
}
