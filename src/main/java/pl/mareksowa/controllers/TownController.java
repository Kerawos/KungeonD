package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.mareksowa.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class TownController implements Initializable {

    @FXML
    private Button btnInventory;

    @FXML
    private Button btnStore;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnTawern;

    @FXML
    private Button btnCath;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerButtonInventory();
        registerButtonToMap();
        registerButtonRestTavern();
        registerButtonRestCathedral();
        registerButtonStore();
    }

    private void registerButtonInventory(){
        btnInventory.setOnMouseClicked(e->{
            Utils.getInstance().setBackStage("town.fxml");
            Stage mapStage = (Stage) btnInventory.getScene().getWindow();
            Utils.getInstance().sceneChange(mapStage, "inventory.fxml");
        });
    }

    private void registerButtonToMap(){
        btnBack.setOnMouseClicked(e->{
            Stage mapStage = (Stage) btnBack.getScene().getWindow();
            Utils.getInstance().sceneChange(mapStage, "map.fxml");
        });
    }

    private void registerButtonStore(){
        btnStore.setOnMouseClicked(e->{
            Stage mapStage = (Stage) btnStore.getScene().getWindow();
            Utils.getInstance().sceneChange(mapStage, "store.fxml");
        });
    }


    private void registerButtonRestTavern(){
        btnTawern.setOnMouseClicked(e->{
            if (HeroCreatorController.player.getGold()>25){
                if (HeroCreatorController.player.getHp()<HeroCreatorController.player.getMaxHp()){
                    HeroCreatorController.player.setGold(HeroCreatorController.player.getGold()-25);
                    HeroCreatorController.player.setHp(HeroCreatorController.player.getHp()
                            + HeroCreatorController.player.getLevel());
                    if (HeroCreatorController.player.getHp()>HeroCreatorController.player.getMaxHp()){
                        HeroCreatorController.player.setHp(HeroCreatorController.player.getMaxHp());
                    }
                    Utils.getInstance().showInformationDialog("Rest in tavern",
                            "You rest poor.. but is always something you have "
                                    + HeroCreatorController.player.getHp());
                }
            }else {
                Utils.getInstance().showInformationDialog("Rest in tavern",
                        "You have not enough gold");
            }
        });
    }

    private void registerButtonRestCathedral(){
        btnCath.setOnMouseClicked(e->{
            if (HeroCreatorController.player.getGold()>250){
                if (HeroCreatorController.player.getHp()<HeroCreatorController.player.getMaxHp()){
                    HeroCreatorController.player.setHp(HeroCreatorController.player.getMaxHp());
                    Utils.getInstance().showInformationDialog("Visited Cathedral",
                            "You got bless from heavens, you revive completely");
                }
            } else {
                Utils.getInstance().showInformationDialog("Visited Cathedral",
                        "You have not enough gold");
            }
        });
    }


}
