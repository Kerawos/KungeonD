package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.mareksowa.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable{

    @FXML
    Button btnStart;

    @FXML
    Button btnExit;


    public void initialize(URL location, ResourceBundle resources) {
        registerButtonStart();
        registerButtonExit();
    }


    //back to main window
    public void registerButtonStart(){
        btnStart.setOnMouseClicked(e-> {
                Stage stageCreateCharacter = (Stage) btnStart.getScene().getWindow();
            Utils.getInstance().sceneChange(stageCreateCharacter, "heroCreator.fxml");
    });
    }

    //exit game
    public void registerButtonExit(){
        btnExit.setOnMouseClicked(e->Utils.gameClose());
    }

}
