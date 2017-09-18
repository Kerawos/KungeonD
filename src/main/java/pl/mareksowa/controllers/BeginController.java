package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.mareksowa.Utils;
import pl.mareksowa.items.Armor;
import pl.mareksowa.items.Potion;
import pl.mareksowa.items.Weapon;

import java.net.URL;
import java.util.ResourceBundle;

public class BeginController implements Initializable {

    @FXML
    Button btnEnter;

    @FXML
    Text txtLore;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerEnterMapButton();
        HeroCreatorController.player.setWeapon(new Weapon());
        HeroCreatorController.player.setArmor(new Armor());
        HeroCreatorController.player.addInventory(new Weapon());
        HeroCreatorController.player.addInventory(new Potion());
        txtLore.setText("As a child you ..." + HeroCreatorController.player.getWeapon().toString() +", "
                + HeroCreatorController.player.getArmor().toString() + ", "
                + HeroCreatorController.player.getInventory().get(0) );
    }

    private void registerEnterMapButton(){
        btnEnter.setOnMouseClicked(event -> {
            Stage mapStage = (Stage) btnEnter.getScene().getWindow();
            Utils.getInstance().sceneChange(mapStage, "map.fxml");
        });
    }


}
