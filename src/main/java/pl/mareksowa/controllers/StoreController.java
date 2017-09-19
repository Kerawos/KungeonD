package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.mareksowa.Utils;
import pl.mareksowa.items.Item;
import pl.mareksowa.items.Weapon;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StoreController implements Initializable {

    @FXML
    private Button btnInv;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnSlot1;

    @FXML
    private Button btnSlot2;

    @FXML
    private Button btnSlot3;

    @FXML
    private Button btnSlot4;

    @FXML
    private Button btnSlot5;

    @FXML
    private Button btnSlot6;

    @FXML
    private Button btnSlot7;

    @FXML
    private Button btnSlot8;

    @FXML
    private Button btnStore1;

    @FXML
    private Button btnStore2;

    @FXML
    private Button btnStore3;

    @FXML
    private Button btnStore4;

    @FXML
    private Button btnStore5;

    @FXML
    private Button btnStore6;

    @FXML
    private Button btnStore7;

    @FXML
    private Button btnStore8;

    @FXML
    private Button btnStore9;

    @FXML
    private Button btnStore10;

    @FXML
    private Text txtGold;

    @FXML
    private TextArea txtInfo;

    List<Item> store = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        update();
        registerButtonInventory();
        registerButtonBackToTown();
        registerButtonStore();
        registerButtonSlot();

    }
    private void update(){
        updateStore();
        updateInventory();
        txtGold.setText("Your Gold: " + HeroCreatorController.player.getGold());
    }

    private void updateStore(){
        btnStore1.setVisible(false);
        btnStore2.setVisible(false);
        btnStore3.setVisible(false);
        btnStore4.setVisible(false);
        btnStore5.setVisible(false);
        btnStore6.setVisible(false);
        btnStore7.setVisible(false);
        btnStore8.setVisible(false);
        btnStore9.setVisible(false);
        btnStore10.setVisible(false);
        for (int i = 0; i < 10; i++) {
            store.add(Item.itemGenerator());
        }
        showStoreItem(0, btnStore1);
        showStoreItem(1, btnStore2);
        showStoreItem(2, btnStore3);
        showStoreItem(3, btnStore4);
        showStoreItem(4, btnStore5);
        showStoreItem(5, btnStore6);
        showStoreItem(6, btnStore7);
        showStoreItem(7, btnStore8);
        showStoreItem(8, btnStore9);
        showStoreItem(9, btnStore10);
    }

    private void updateInventory(){
        btnSlot1.setVisible(false);
        btnSlot2.setVisible(false);
        btnSlot3.setVisible(false);
        btnSlot4.setVisible(false);
        btnSlot5.setVisible(false);
        btnSlot6.setVisible(false);
        btnSlot7.setVisible(false);
        btnSlot8.setVisible(false);

        if (HeroCreatorController.player.getInventory().size()>0){
            btnSlot1.setVisible(true);
            btnSlot1.setText(HeroCreatorController.player.getInventory().get(0).toString());
        }
        if (HeroCreatorController.player.getInventory().size()>1){
            btnSlot2.setVisible(true);
            btnSlot2.setText(HeroCreatorController.player.getInventory().get(1).toString());
        }
        if (HeroCreatorController.player.getInventory().size()>2){
            btnSlot3.setVisible(true);
            btnSlot3.setText(HeroCreatorController.player.getInventory().get(2).toString());
        }
        if (HeroCreatorController.player.getInventory().size()>3){
            btnSlot4.setVisible(true);
            btnSlot4.setText(HeroCreatorController.player.getInventory().get(3).toString());
        }
        if (HeroCreatorController.player.getInventory().size()>4){
            btnSlot5.setVisible(true);
            btnSlot5.setText(HeroCreatorController.player.getInventory().get(4).toString());
        }
        if (HeroCreatorController.player.getInventory().size()>5){
            btnSlot6.setVisible(true);
            btnSlot6.setText(HeroCreatorController.player.getInventory().get(5).toString());
        }
        if (HeroCreatorController.player.getInventory().size()>6){
            btnSlot7.setVisible(true);
            btnSlot7.setText(HeroCreatorController.player.getInventory().get(6).toString());
        }
        if (HeroCreatorController.player.getInventory().size()>7){
            btnSlot8.setVisible(true);
            btnSlot8.setText(HeroCreatorController.player.getInventory().get(7).toString());
        }
    }

    private void showStoreItem(int index, Button buttonName){
        if (store.get(index).getClass().getSimpleName().equals("Weapon")){
            buttonName.setText(store.get(index).getName() + ", dmg= "+store.get(index).getDamage()
                    +", $=" + store.get(index).getPrice()*2);
        } else if (store.get(index).getClass().getSimpleName().equals("Armor")) {
            buttonName.setText(store.get(index).getName() + ", def= " + store.get(index).getDef()
                    + ", $=" + store.get(index).getPrice() * 2);
        } else {
            buttonName.setText(store.get(index).getName()+ ", $=" + store.get(index).getPrice() * 2);
        }
        buttonName.setVisible(true);
    }

    private void registerButtonInventory(){
        btnInv.setOnMouseClicked(e->{
            Utils.getInstance().setBackStage("store.fxml");
            Stage mapStage = (Stage) btnInv.getScene().getWindow();
            Utils.getInstance().sceneChange(mapStage, "inventory.fxml");
        });
    }

    private void registerButtonBackToTown(){
        btnBack.setOnMouseClicked(e->{
            Stage mapStage = (Stage) btnBack.getScene().getWindow();
            Utils.getInstance().sceneChange(mapStage, "town.fxml");
        });
    }

    private void buyItem(int index){
        if (HeroCreatorController.player.getInventory().size()<8
                && HeroCreatorController.player.getGold()>(store.get(index).getPrice()*2)){
            HeroCreatorController.player.setGold(HeroCreatorController.player.getGold()-(store.get(index).getPrice()*2));
            HeroCreatorController.player.addInventory(store.get(index));
            store.remove(index);
            update();
        } else {
            txtInfo.setText("You have not enough gold..");
        }
    }

    private void sellItem(int index){
        HeroCreatorController.player.setGold(HeroCreatorController.player.getGold()
                +HeroCreatorController.player.getInventory().get(index).getPrice());
        HeroCreatorController.player.removeInventory(HeroCreatorController.player.getInventory().get(index));

        update();
    }

    private void registerButtonStore(){
        btnStore1.setOnMouseClicked(e->buyItem(0));
        btnStore2.setOnMouseClicked(e->buyItem(1));
        btnStore3.setOnMouseClicked(e->buyItem(2));
        btnStore4.setOnMouseClicked(e->buyItem(3));
        btnStore5.setOnMouseClicked(e->buyItem(4));
        btnStore6.setOnMouseClicked(e->buyItem(5));
        btnStore7.setOnMouseClicked(e->buyItem(6));
        btnStore8.setOnMouseClicked(e->buyItem(7));
        btnStore9.setOnMouseClicked(e->buyItem(8));
        btnStore10.setOnMouseClicked(e->buyItem(9));
    }

    private void registerButtonSlot(){
        btnSlot1.setOnMouseClicked(e->sellItem(0));
        btnSlot2.setOnMouseClicked(e->sellItem(1));
        btnSlot3.setOnMouseClicked(e->sellItem(2));
        btnSlot4.setOnMouseClicked(e->sellItem(3));
        btnSlot5.setOnMouseClicked(e->sellItem(4));
        btnSlot6.setOnMouseClicked(e->sellItem(5));
        btnSlot7.setOnMouseClicked(e->sellItem(6));
        btnSlot8.setOnMouseClicked(e->sellItem(7));
    }



}
