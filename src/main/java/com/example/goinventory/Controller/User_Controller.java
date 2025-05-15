package com.example.goinventory.Controller;


import com.example.goinventory.Model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class User_Controller {
    public Button logout_user;
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
    public void onlogout_user(ActionEvent e){
        Stage stage = (Stage) logout_user.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindows();
    }
}
