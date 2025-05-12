package com.example.goinventory.View;

import com.example.goinventory.Controller.AdminController;
import com.example.goinventory.Controller.AdminMenuController;
import com.example.goinventory.Controller.User_Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Scanner;


public class ViewFactory {

    private final StringProperty adminSelectedMenuItem;
    private AnchorPane dashboardview;
    private AnchorPane ManageRoleView;
    private AnchorPane ViewOrderView;

    public ViewFactory(){
        this.adminSelectedMenuItem = new SimpleStringProperty("");
    }

    public StringProperty getAdminSelectedMenuItem() {
        return adminSelectedMenuItem;
    }

    public AnchorPane getDashboardview() {
        //return dashboardview;
        if (dashboardview == null) {
            try{
                dashboardview = new FXMLLoader(getClass().getResource("/FXML/Admin/Admin_dashboard.fxml" )).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dashboardview;
    }
    public AnchorPane getManageRoleView() {
        if (ManageRoleView == null) {
            try{
                ManageRoleView = new FXMLLoader(getClass().getResource("/FXML/Admin/Admin_Manage_Role.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return ManageRoleView;
    }
    public AnchorPane getViewOrderView() {
        if (ViewOrderView == null) {
            try{
                ViewOrderView = new FXMLLoader(getClass().getResource("/FXML/Admin/Admin_View_order.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return ViewOrderView;
    }

    public void showLoginWindows(){// User: Admin, Pass: admin
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/login.fxml" ));
        CreateStage(loader);
    }
    public void showAdminWindows(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Admin/Admin.fxml" ));
        AdminController admin = new AdminController();
        loader.setController(admin);
        CreateStage(loader);
    }
    public void showUserWindows(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/User/UserDashbord.fxml" ));
        User_Controller  user = new User_Controller();
        loader.setController(user);
        CreateStage(loader);
    }

    private void CreateStage(FXMLLoader loader) {
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        Image i = new Image("file:/F:/Project java/GoInventory/src/main/resources/Image/Logo/icon.png");
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("GoInventory");
        stage.getIcons().add(i);
        stage.show();
    }
    public void closeStage(Stage stage){
        stage.close();
    }

}
