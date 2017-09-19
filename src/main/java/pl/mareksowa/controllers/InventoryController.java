package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.mareksowa.Utils;
import pl.mareksowa.items.Item;
import pl.mareksowa.items.Weapon;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable{


    @FXML
    Button btnSlot1;

    @FXML
    Button btnSlot2;

    @FXML
    Button btnSlot3;

    @FXML
    Button btnSlot4;

    @FXML
    Button btnSlot5;

    @FXML
    Button btnSlot6;

    @FXML
    Button btnSlot7;

    @FXML
    Button btnSlot8;

    @FXML
    Button btnWeapon;

    @FXML
    Button btnArmor;

    @FXML
    Text txtGold;

    @FXML
    Button btnBack;

    @FXML
    Text txtPlayerInfo;

    @FXML
    Text txtDmgDone;

    @FXML
    Text txtArmorHave;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerButtonBack();
        updatePlayer();
        registerButtonChangeInventory();
    }

    private void updatePlayer(){
        btnSlot1.setVisible(false);
        btnSlot2.setVisible(false);
        btnSlot3.setVisible(false);
        btnSlot4.setVisible(false);
        btnSlot5.setVisible(false);
        btnSlot6.setVisible(false);
        btnSlot7.setVisible(false);
        btnSlot8.setVisible(false);
        btnArmor.setVisible(false);
        btnWeapon.setVisible(false);

        if (HeroCreatorController.player.getWeapon()!=null){
            txtDmgDone.setText("DMG: " + String.valueOf(HeroCreatorController.player.getStr()
                    + HeroCreatorController.player.getWeapon().getDamage()));
        } else {
            txtDmgDone.setText("DMG: " + HeroCreatorController.player.getStr());
        }

        if (HeroCreatorController.player.getArmor()!=null){
            txtArmorHave.setText("ARMOR: " + HeroCreatorController.player.getArmor().getDef());
        } else {
            txtArmorHave.setText("ARMOR: 0");
        }


        txtPlayerInfo.setText(HeroCreatorController.player.toString());

        if (HeroCreatorController.player.getWeapon()!=null){
            btnWeapon.setVisible(true);
            btnWeapon.setText(HeroCreatorController.player.getWeapon().toString());
        }

        if (HeroCreatorController.player.getArmor()!=null){
            btnArmor.setVisible(true);
            btnArmor.setText(HeroCreatorController.player.getArmor().toString());
        }

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
        txtGold.setText("Gold: " + HeroCreatorController.player.getGold());
        System.out.println("player up[date");
    }

    private void registerButtonBack(){
        btnBack.setOnMouseClicked(e->{
            Stage backStage = (Stage) btnBack.getScene().getWindow();
            Utils.getInstance().sceneChange(backStage, Utils.getInstance().getBackStage());
        });
    }
    private void registerButtonChangeInventory(){
        btnWeapon.setOnMouseClicked(e->{
            if (HeroCreatorController.player.getInventory().size()<8){
                HeroCreatorController.player.addInventory(HeroCreatorController.player.getWeapon());
                HeroCreatorController.player.setWeapon(null);
                updatePlayer();
            }
                }
        );
        btnArmor.setOnMouseClicked(e->{
            if (HeroCreatorController.player.getInventory().size()<8){
                HeroCreatorController.player.addInventory(HeroCreatorController.player.getArmor());
                HeroCreatorController.player.setArmor(null);
                updatePlayer();
            }
        }
        );
        btnSlot1.setOnMouseClicked(e->manageInv(0));
        btnSlot2.setOnMouseClicked(e->manageInv(1));
        btnSlot3.setOnMouseClicked(e->manageInv(2));
        btnSlot4.setOnMouseClicked(e->manageInv(3));
        btnSlot5.setOnMouseClicked(e->manageInv(4));
        btnSlot6.setOnMouseClicked(e->manageInv(5));
        btnSlot7.setOnMouseClicked(e->manageInv(6));
        btnSlot8.setOnMouseClicked(e->manageInv(7));

    }

    private void manageInv(int invIndex){
        if (HeroCreatorController.player.getInventory().get(invIndex).getClass().getSimpleName().equals("Weapon")){
            System.out.println("kliklem weapon");
            if (HeroCreatorController.player.getWeapon()!=null){
                Item tempWeapon = HeroCreatorController.player.getWeapon();
                HeroCreatorController.player.setWeapon(HeroCreatorController.player.getInventory().get(invIndex));
                HeroCreatorController.player.getInventory().set(invIndex, tempWeapon);
            } else {
                HeroCreatorController.player.setWeapon(HeroCreatorController.player.getInventory().get(invIndex));
                HeroCreatorController.player.removeInventory(HeroCreatorController.player.getInventory().get(invIndex));
            }
        } else if (HeroCreatorController.player.getInventory().get(invIndex).getClass().getSimpleName().equals("Armor")){
            System.out.println("kliklem armor");
            if (HeroCreatorController.player.getArmor()!=null){
                Item tempWeapon = HeroCreatorController.player.getArmor();
                HeroCreatorController.player.setArmor(HeroCreatorController.player.getInventory().get(invIndex));
                HeroCreatorController.player.getInventory().set(invIndex, tempWeapon);
            } else {
                HeroCreatorController.player.setArmor(HeroCreatorController.player.getInventory().get(invIndex));
                HeroCreatorController.player.removeInventory(HeroCreatorController.player.getInventory().get(invIndex));
            }
        } else {
            System.out.println("kliklem potiona");
            if (HeroCreatorController.player.getHp()<HeroCreatorController.player.getMaxHp()){
                if (HeroCreatorController.player.getInventory().get(invIndex).getName().equals("Healing potion")){
                    HeroCreatorController.player.setHp(HeroCreatorController.player.getMaxHp());
                } else {
                    HeroCreatorController.player.setHp(HeroCreatorController.player.getHp()
                            + (HeroCreatorController.player.getMaxHp()/2));
                    if (HeroCreatorController.player.getHp()>HeroCreatorController.player.getMaxHp()){
                        HeroCreatorController.player.setHp(HeroCreatorController.player.getMaxHp());

                    }

                }
                HeroCreatorController.player.removeInventory(HeroCreatorController.player.getInventory().get(invIndex));
            }
        }
        updatePlayer();
    }


}
