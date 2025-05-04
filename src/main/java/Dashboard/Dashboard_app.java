package Dashboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard_app extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
        Image logo = new Image("file:/F:/Project java/GoInventory/src/main/resources/Logo/icon.png");
        primaryStage.setTitle("Dashboard");
        primaryStage.setMinHeight(scene.getHeight());
        primaryStage.setMinWidth(scene.getWidth());
        primaryStage.getIcons().add(logo);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
