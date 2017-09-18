package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.mareksowa.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class DungeonController implements Initializable {

    @FXML
    TextArea txtDungeonPrompt;

    @FXML
    Button btnBack;

    @FXML
    Button btnGoNext;

    @FXML
    Text txtlevel;

    @FXML
    Button btnInv;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerButtonGoDown();
        registerButtonGetBack();
        updatePrompt();
        registerButtonShowInventory();
    }

    private void registerButtonGoDown(){
        btnGoNext.setOnMouseClicked(e->{
          Stage fightStage = (javafx.stage.Stage) btnGoNext.getScene().getWindow();
            Utils.getInstance().sceneChange(fightStage, "fight.fxml");
        });
    }

    private void registerButtonGetBack(){
        btnBack.setOnMouseClicked(e->{
            Stage mapStage = (javafx.stage.Stage) btnBack.getScene().getWindow();
            Utils.getInstance().sceneChange(mapStage, "map.fxml");
        });
    }

    private void updatePrompt(){
        txtlevel.setText("Level " + String.valueOf(MapController.dungeonLevel));
        if (MapController.dungeonLevel==1){
            txtDungeonPrompt.setText("You enter the dungeon.. seems like a great opportunity to howl");
        } else {
            txtDungeonPrompt.setText("You go deeper and deeper..");
        }

    }

    private void registerButtonShowInventory(){
        btnInv.setOnMouseClicked(e->{
            Utils.getInstance().setBackStage("dungeon.fxml");
            Stage mapStage = (Stage) btnInv.getScene().getWindow();
            Utils.getInstance().sceneChange(mapStage, "inventory.fxml");
        });
//        Utils.getInstance().setBackStage("dungeon.fxml");
//        btnInv.setOnMouseClicked(e-> Utils.getInstance().showInventory(btnInv));
    }

}
