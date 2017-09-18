package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.mareksowa.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class MapController implements Initializable {

    @FXML
    private Text lblNickname;

    @FXML
    private Text lblMapHp;

    @FXML
    private Text lblMapStr;

    @FXML
    Button btnToTown;

    @FXML
    Button btnToDungeon;

    @FXML
    Button btnInv;

    public static int dungeonLevel = 0;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblNickname.setText(HeroCreatorController.player.getNickname()+":");
        lblMapHp.setText(String.valueOf(HeroCreatorController.player.getHp()) + "/" + String.valueOf(HeroCreatorController.player.getMaxHp()));
        lblMapStr.setText(String.valueOf(HeroCreatorController.player.getStr()));
        registerButtonToDungeon();
        registerButtonToTheTown();
        registerButtonInventory();
    }

    private void registerButtonToDungeon(){
        btnToDungeon.setOnMouseClicked(e-> {
            dungeonLevel = 1;
            Stage mapStage = (Stage) btnToDungeon.getScene().getWindow();
            Utils.getInstance().sceneChange(mapStage, "dungeon.fxml");
        });
    }

    private void registerButtonToTheTown(){

    }

    private void registerButtonInventory(){
        btnInv.setOnMouseClicked(e->{
            Utils.getInstance().setBackStage("map.fxml");
            Stage mapStage = (Stage) btnInv.getScene().getWindow();
            Utils.getInstance().sceneChange(mapStage, "inventory.fxml");
                });
//        Utils.getInstance().setBackStage("map.fxml");
//        btnInv.setOnMouseClicked(e->Utils.getInstance().showInventory(btnInv));
    }

}
