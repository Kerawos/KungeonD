package pl.mareksowa.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.mareksowa.Utils;
import pl.mareksowa.items.Item;
import pl.mareksowa.models.MonsterModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FightController implements Initializable {

    private MonsterModel monster = generateMonster();

    @FXML
    Text txtPlayer;

    @FXML
    Text txtMonster;

    @FXML
    Button btnAttack;

    @FXML
    Button btnRun;

    @FXML
    TextArea txtFight;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateFight();
        registerButtonRun();
        registerButtonAttack();
        fireRun();

    }

    private MonsterModel generateMonster(){
        return new MonsterModel();
    }

    private void updatePlayer(){
        txtPlayer.setText(HeroCreatorController.player.toString());
    }

    private void updateMonster(){
        txtMonster.setText(monster.toString());
    }

    private void registerButtonRun(){
        btnRun.setOnMouseClicked(e-> {
            System.out.println("Button RUN klikniety");
            Stage dungeonStage = (Stage) btnRun.getScene().getWindow();
            Utils.getInstance().sceneChange(dungeonStage, "dungeon.fxml");
                }
        );
    }

    private void registerButtonAttack(){
        btnAttack.setOnMouseClicked(e-> {
            if (HeroCreatorController.player.getWeapon()!=null){
                monster.setHp(monster.getHp()- HeroCreatorController.player.getStr()
                        - HeroCreatorController.player.getWeapon().getDamage());
            } else {
                monster.setHp(monster.getHp()- HeroCreatorController.player.getStr());
            }

            if (monster.getHp()>0){
                int dmgDone;
                if (HeroCreatorController.player.getArmor()!=null){
                    if (monster.getStr()>HeroCreatorController.player.getArmor().getDef()) {
                        dmgDone = monster.getStr() - HeroCreatorController.player.getArmor().getDef();
                    } else {
                        dmgDone = 1;
                    }
                    HeroCreatorController.player.setHp(HeroCreatorController.player.getHp()-dmgDone);
                } else {
                    HeroCreatorController.player.setHp(HeroCreatorController.player.getHp()-monster.getStr());
                }


                if (HeroCreatorController.player.getHp()<=0){
                    playerWin(false);
                }
            } else {
                MapController.dungeonLevel++;
                HeroCreatorController.player.setExp(HeroCreatorController.player.getExp()+monster.getStr());
                HeroCreatorController.player.setGold(HeroCreatorController.player.getGold()+monster.getMaxHp());
                playerWin(true);
            }
            updateFight();
                }
        );
    }

    private void updateFight(){
        txtFight.setText("Wild '" + monster.getName() + "' appear!");
        updatePlayer();
        updateMonster();
    }

    private void playerWin(boolean result){
        if (result){
            boolean getItem = false;
            if (HeroCreatorController.player.getInventory().size()<4){
                HeroCreatorController.player.addInventory(Item.itemGenerator());
                getItem = true;
            }
            if (getItem){
                Utils.getInstance().showInformationDialog("You won", "You succesfully win this battle! \n" +
                        "You earn " + monster.getStr() + " exp\n and " + monster.getMaxHp() + " gold.. and "
                        + HeroCreatorController.player.getInventory().get(HeroCreatorController.player.getInventory().size()-1));
            } else {
                Utils.getInstance().showInformationDialog("You won", "You succesfully win this battle! \n" +
                        "You earn " + monster.getStr() + " exp\n and " + monster.getMaxHp() + " gold.. and ");
            }
            btnRun.fire();
        } else {
            Utils.getInstance().showInformationDialog("You die!", " you have been killed by "
                    + monster.getName() + " .. Rest in pease brave " + HeroCreatorController.player.getNickname());
            Utils.gameClose();
            //System.exit(1);
        }
    }

    private void fireRun(){
        btnRun.setOnAction(e->{
            Stage dungeonStage = (Stage) btnRun.getScene().getWindow();
            Utils.getInstance().sceneChange(dungeonStage, "dungeon.fxml");
        });
    }





}
