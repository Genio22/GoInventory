package com.example.goinventory;

import com.example.goinventory.Model.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class GoInventory extends Application {

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Admin/Admin_Dashboard.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Image logo = new Image("file:/F:/Project java/GoInventory/src/main/resources/Image/Logo/icon.png");
//        primaryStage.setTitle("Dashboard");
//        System.out.println(getClass().getResource("/Image/Logo/icon.png"));
//        primaryStage.setMinHeight(scene.getHeight());
//        primaryStage.setMinWidth(scene.getWidth());
//        primaryStage.getIcons().add(logo);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//        ViewFactory viewFactory = new ViewFactory();
//        viewFactory.showLoginWindows();

        Model.getInstance().getViewFactory().showLoginWindows();

    }

}
