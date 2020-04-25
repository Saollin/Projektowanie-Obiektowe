package pl.agh.edu.dp.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.factories.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factories.MazeFactory;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MazeGame.fxml"));
        root.requestFocus();
        primaryStage.setTitle("Maze Game");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}



