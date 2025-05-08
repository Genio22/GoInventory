package com.example.goinventory.View;

import com.example.goinventory.Controller.AdminController;
import com.example.goinventory.Controller.AdminMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Scanner;


public class ViewFactory {
    private AnchorPane dashboardview;

    public ViewFactory(){

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

    public void showLoginWindows(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/login.fxml" ));
        CreateStage(loader);
    }
    public void showAdminWindows(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Admin/Admin.fxml" ));
        AdminController admin = new AdminController();
        loader.setController(admin);
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
        stage.setTitle("Login");
        stage.getIcons().add(i);
        stage.show();
    }


}
