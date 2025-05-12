package com.example.goinventory.Controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

public class User_Controller {
    @FXML
    private AnchorPane Dashbordfarme;
    @FXML
    private AnchorPane AddParcelframe;
@FXML
    private AnchorPane Deliverdframe;
@FXML
    private AnchorPane paindingframe;
@FXML
    private Button dashbtn;
@FXML
    private Button addparcelbtn;
@FXML
    private Button deliverdbtn;
@FXML
    private Button paindingbtn;

    @SuppressWarnings("exports")
    public void buttonAction(ActionEvent e){
        if(e.getSource() == dashbtn){
            Dashbordfarme.setVisible(true);
            AddParcelframe.setVisible(false);
            Deliverdframe.setVisible(false);
            paindingframe.setVisible(false);
            
        }
        else if(e.getSource() == addparcelbtn){
            Dashbordfarme.setVisible(false);
            AddParcelframe.setVisible(true);
            Deliverdframe.setVisible(false);
            paindingframe.setVisible(false);
        }
        else if(e.getSource() == deliverdbtn){
            Dashbordfarme.setVisible(false);
            AddParcelframe.setVisible(false);
            Deliverdframe.setVisible(true);
            paindingframe.setVisible(false);
        }
        else if(e.getSource() == paindingbtn){
            Dashbordfarme.setVisible(false);
            AddParcelframe.setVisible(false);
            Deliverdframe.setVisible(false);
            paindingframe.setVisible(true);
        }
    }
}
