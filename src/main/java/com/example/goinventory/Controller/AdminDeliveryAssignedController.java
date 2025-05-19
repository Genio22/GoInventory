package com.example.goinventory.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AdminDeliveryAssignedController {

    @FXML
    private AnchorPane AssignDeliveryFrame;

    @FXML
    private TableColumn<?, ?> Amount_to_recevied;

    @FXML
    private TableColumn<?, ?> Customer_name;

    @FXML
    private TableColumn<?, ?> Deliver_By;

    @FXML
    private ComboBox<?> DeliveryManAssign_combox;

    @FXML
    private TableColumn<?, ?> Due_Date;

    @FXML
    private TableColumn<?, ?> Invoice_no;

    @FXML
    private TextField Last_date_textField;

    @FXML
    private TableColumn<?, ?> No;

    @FXML
    private TableColumn<?, ?> ProductName;

    @FXML
    private TableColumn<?, ?> Quantity;

    @FXML
    private Button reset;

    @FXML
    private Button save;

    @FXML
    private Button update;

}
