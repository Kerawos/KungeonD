package pl.mareksowa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameStarter extends Application {

    @Override
    public void start(Stage startStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("start.fxml"));
        startStage.setTitle("KungeonD a0.5");
        startStage.setScene(new Scene(root, 800, 640));
        startStage.setResizable(false);
        startStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
