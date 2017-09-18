package pl.mareksowa;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.mareksowa.models.PlayerModel;

import java.io.IOException;

public class Utils {
    private static Utils ourInstance = new Utils();

    public static Utils getInstance() {
        return ourInstance;
    }

    private Utils() {
    }

    public String backStage = null;

    public String getBackStage() {
        return backStage;
    }

    public void setBackStage(String backStage) {
        this.backStage = backStage;
    }

    public static void gameClose(){
        Platform.exit();
        System.exit(1);
    }


    public void sceneChange(Stage stageName, String sceneName){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(sceneName));
            stageName.setScene(new Scene(root, 800, 640));
            stageName.setOnCloseRequest(e2-> Utils.gameClose());
            stageName.setResizable(false);
            stageName.show();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public void showInformationDialog(String title, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }



}
