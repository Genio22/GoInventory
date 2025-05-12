package com.example.goinventory.Controller;

import com.example.goinventory.Model.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button report_button;
    public Button Dashboard_button;
    public Button Manage_Users_Role_button;
    public MenuButton Product_Inventory_button;
    public MenuItem View_Products_button;
    public MenuItem Edit_Product_button;
    public MenuItem Adjust_Stock_Level_button;
    public MenuItem View_Stock_Levels_Locations_button;
    public MenuButton Order_Management_button;
    public MenuItem View_Order_button;
    public MenuItem Update_Order_Status_button;
    public MenuItem O_Adjust_Stock_Levels_button;
    public Button Invoices_button;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Dashboard_button.setOnAction(event -> onDashboard());
        View_Products_button.setOnAction(event -> onManageProduct());
        Manage_Users_Role_button.setOnAction(event -> onManage_Users_Role());
        View_Order_button.setOnAction(event -> onView_Order());
        Invoices_button.setOnAction(event -> onInvoice());
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("Dashboard");
    }
    private void onManageProduct(){Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("Manage_Products");}
    private void onManage_Users_Role() {Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("Manage_Role");}
    private void onInvoice(){Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("Invoice");}
    private void onView_Order() {Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("View_Order");}

}
