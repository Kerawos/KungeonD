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
    private Button btnToTown;

    @FXML
    private Button btnToDungeon;

    @FXML
    private Button btnInv;

    public static int dungeonLevel = 0;

    @FXML
    private Text txtDmg;

    @FXML
    private Text txtDef;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblNickname.setText(HeroCreatorController.player.getNickname()+":");
        lblMapHp.setText(String.valueOf(HeroCreatorController.player.getHp()) + "/" + String.valueOf(HeroCreatorController.player.getMaxHp()));
        lblMapStr.setText(String.valueOf(HeroCreatorController.player.getStr()));
        if (HeroCreatorController.player.getWeapon()!=null){
            txtDmg.setText("Dmg= "+String.valueOf(HeroCreatorController.player.getStr()
                    +HeroCreatorController.player.getWeapon().getDamage()));
        } else {
            txtDmg.setText("Dmg= "+String.valueOf(HeroCreatorController.player.getStr()));
        }
        if (HeroCreatorController.player.getArmor()!=null){
            txtDef.setText("Def= "+String.valueOf(HeroCreatorController.player.getArmor().getDef()));
        } else {
            txtDef.setText("Def= 0");
        }
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
        btnToTown.setOnMouseClicked(e->{
            Stage mapTown = (Stage) btnToTown.getScene().getWindow();
            Utils.getInstance().sceneChange(mapTown, "town.fxml");
        });

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
