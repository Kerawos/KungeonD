package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.mareksowa.Utils;
import pl.mareksowa.models.PlayerModel;

import java.net.URL;
import java.util.ResourceBundle;

public class HeroCreatorController implements Initializable {

    @FXML
    TextField txtNickname;

    @FXML
    private Text lblMaxHp;

    @FXML
    private Text lblStr;

    @FXML
    private Button btnHPplus;

    @FXML
    private Button btnHPminus;

    @FXML
    private Button btnSTRplus;

    @FXML
    private Button btnSTRminus;

    @FXML
    private Text lblPointsRem;

    @FXML
    Button btnBegin;

    //start stats
    int pointsRem = 8;
    int hp = 1;
    int str = 1;
    public static PlayerModel player;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateStats();
        registerAdjustingStats();
        registerBeginJourneyButton();
    }

    private void registerAdjustingStats(){
        btnHPplus.setOnMouseClicked(e->{
            if (pointsRem>0){
                adjustStats(-1, 1, 0);
                updateStats();
            }
        });

        btnHPminus.setOnMouseClicked(e->{
            if (hp>1){
                adjustStats(1, -1, 0);
                updateStats();
            }
        });

        btnSTRplus.setOnMouseClicked(event -> {
            if (pointsRem>0){
                adjustStats(-1, 0, 1);
                updateStats();
            }
        });

        btnSTRminus.setOnMouseClicked(event -> {
            if (str>1){
                adjustStats(1, 0, -1);
                updateStats();
            }
        });

    }

    private void adjustStats(int pRem, int pHp, int pStr){
        pointsRem = pointsRem + pRem;
        hp = hp + pHp;
        str = str + pStr;
    }

    private void updateStats(){
        lblPointsRem.setText(String.valueOf(pointsRem));
        lblMaxHp.setText(String.valueOf(hp));
        lblStr.setText(String.valueOf(str));
        if (isPointLeft()){
            lblPointsRem.setFill(Color.BLACK);
        }
    }

    private void registerBeginJourneyButton(){
        btnBegin.setOnMouseClicked(e->{
            if (!isPointLeft() && isNickCorect()){
                player = new PlayerModel(txtNickname.getText(), hp, str);
                player.setHp(player.getMaxHp());
                Stage stageBeginJourney = (Stage) btnBegin.getScene().getWindow();
                Utils.getInstance().sceneChange(stageBeginJourney, "beginJourney.fxml");
            }
        });

    }

    private boolean isPointLeft(){
        if (pointsRem>0){
            lblPointsRem.setFill(Color.RED);
            return true;
        }
        return false;
    }

    private boolean isNickCorect(){
        if (txtNickname.getText().length()<3 || txtNickname.getText().length()>10) {
            txtNickname.setText("min 3 letter, max 10");
            return false;
        }
        return true;
    }




}
