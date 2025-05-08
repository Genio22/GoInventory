module com.example.goinventory {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires de.jensd.fx.glyphs.fontawesome;


    opens com.example.goinventory to javafx.fxml;
    exports com.example.goinventory;
    exports com.example.goinventory.Controller;
    exports com.example.goinventory.Model;
    exports com.example.goinventory.View;

    opens com.example.goinventory.Controller to javafx.fxml;



    opens login to javafx.fxml;
    exports login;

    opens Dashboard to javafx.fxml;
    exports Dashboard;


}