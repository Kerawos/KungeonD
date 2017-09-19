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
        HeroCreatorController.player.addInventory(new Potion());
        txtLore.setText(HeroCreatorController.player.getNickname() + " grew up near the village of Kazimierz, " +
                "\nnot too far from the capitol. He’s fairly educated and came from a good family, " +
                "\nalthough he’s had a taste for getting himself in over his head as a child. " +
                "\nHis Uncle Krak told him stories of adventures and such, which got him “curious” \n" +
                "about seeking fame and fortune. " +
                "\n\nAs a young adventurer you start your journey with '"
                + HeroCreatorController.player.getWeapon().getName() +"', " +
                "\nand '" + HeroCreatorController.player.getInventory().get(0).getName()+"'." );
    }

    private void registerEnterMapButton(){
        btnEnter.setOnMouseClicked(event -> {
            Stage mapStage = (Stage) btnEnter.getScene().getWindow();
            Utils.getInstance().sceneChange(mapStage, "map.fxml");
        });
    }


}
