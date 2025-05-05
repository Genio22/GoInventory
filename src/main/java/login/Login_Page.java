package login;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.io.IOException;

public class Login_Page extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Login_Page.class.getResource("/FXML/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Image image = new Image("file:/C:/Users/ahnaf/Documents - Copy/GoInventory/src/main/resources/login/icon.png");
        stage.setTitle("Login");
        //stage.setFullScreen(true);
        stage.setMinHeight(scene.getHeight());
        stage.setMinWidth(scene.getWidth());
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }
}