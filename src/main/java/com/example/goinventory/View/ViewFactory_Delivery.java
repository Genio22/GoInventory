package com.example.goinventory.View;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory_Delivery{

//    private final StringProperty deliverySelectedMenuItem;
////    private AnchorPane dashboardview;
////    private AnchorPane InvoiceView;
////    private AnchorPane ManageRoleView;
////    private AnchorPane Manage_product;
////    private AnchorPane ViewOrderView;
////    private AnchorPane AssignDeliveryView;
//
//    public ViewFactory_Delivery() {
//        this.deliverySelectedMenuItem = new SimpleStringProperty("");
//    }
//
//    public StringProperty getAdminSelectedMenuItem() {
//        return deliverySelectedMenuItem;
//    }
//
//    public AnchorPane getDashboardview() {
//        //return dashboardview;
//        if (dashboardview == null) {
//            try {
//                dashboardview = new FXMLLoader(getClass().getResource("/FXML/Admin/Admin_dashboard.fxml")).load();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return dashboardview;
//    }
//
//    public AnchorPane getManageRoleView() {
//        if (ManageRoleView == null) {
//            try {
//                ManageRoleView = new FXMLLoader(getClass().getResource("/FXML/Admin/Admin_Manage_Role.fxml")).load();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return ManageRoleView;
//    }
//
//    public AnchorPane getManage_product() {
//        if (Manage_product == null) {
//            try {
//                Manage_product = new FXMLLoader(getClass().getResource("/FXML/Admin/Admin_ManageProduct_View.fxml")).load();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return Manage_product;
//    }
//
//    public AnchorPane getViewOrderView() {
//        if (ViewOrderView == null) {
//            try {
//                ViewOrderView = new FXMLLoader(getClass().getResource("/FXML/Admin/Admin_View_order.fxml")).load();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return ViewOrderView;
//    }
//
////    public AnchorPane getInvoiceView() {
////        if (InvoiceView == null) {
////            try {
////                InvoiceView = new FXMLLoader(getClass().getResource("/FXML/Admin/Admin_Invoice_View.fxml")).load();
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        }
////        return InvoiceView;
////    }
//
//    public AnchorPane getAssignDeliveryView() {
//        if (AssignDeliveryView == null) {
//            try {
//                AssignDeliveryView = new FXMLLoader(getClass().getResource("/FXML/Admin/Admin_Delivery_Assigned.fxml")).load();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return AssignDeliveryView;
//    }
//
//    public void showLoginWindows() {// User: Admin, Pass: admin
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/login.fxml"));
//            Scene scene = new Scene(loader.load());
//            Image i = new Image("file:/F:/Project java/GoInventory/src/main/resources/Image/Logo/icon.png");
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.setTitle("GoInventory");
//            stage.getIcons().add(i);
//            //stage.setMinWidth(1366);
//            //stage.setMinHeight(800);
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void showAdminWindows() {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Admin/Admin.fxml"));
////        if controller is not decleared in the fxml file
////        AdminController admin = new AdminController();
////        loader.setController(admin);
//        CreateStage(loader);
//    }
//
//    public void showUserWindows() {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/User/UserDashbord.fxml"));
////        User_Controller  user = new User_Controller();
////        loader.setController(user);
//        CreateStage(loader);
//    }
//
//    private void CreateStage(FXMLLoader loader) {
//        Scene scene = null;
//        try {
//            scene = new Scene(loader.load());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Image i = new Image("file:/F:/Project java/GoInventory/src/main/resources/Image/Logo/icon.png");
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.setTitle("GoInventory");
//        stage.getIcons().add(i);
//        stage.setMinWidth(1366);
//        stage.setMinHeight(800);
//        stage.show();
//    }
//
//    public void closeStage(Stage stage) {
//        stage.close();
//    }

}
