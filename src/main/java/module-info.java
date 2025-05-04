module com.example.goinventory {
    requires javafx.controls;
    requires javafx.fxml;


    opens login to javafx.fxml;
    exports login;

    opens Dashboard to javafx.fxml;
    exports Dashboard;
}