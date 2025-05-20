module com.example.goinventory {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.desktop;
    requires org.apache.logging.log4j;


    opens com.example.goinventory to javafx.fxml;
    exports com.example.goinventory;
    exports com.example.goinventory.Controller;
    exports com.example.goinventory.Model;
    exports com.example.goinventory.View;

    opens com.example.goinventory.Controller to javafx.fxml;
    opens com.example.goinventory.Model to javafx.fxml;
}