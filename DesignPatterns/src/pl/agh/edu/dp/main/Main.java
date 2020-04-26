package pl.agh.edu.dp.main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.factories.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factories.MazeFactory;
import pl.agh.edu.dp.visualisation.MazeGameController;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader mazeGameLoader = new FXMLLoader();
        mazeGameLoader.setLocation(getClass().getResource("/fxml/MazeGame.fxml"));
        MazeGameController mazeGameController = MazeGameController.getInstance();
        mazeGameLoader.setController(mazeGameController);
        Parent root = mazeGameLoader.load();
        root.setFocusTraversable(true);
        root.setOnKeyPressed(mazeGameController);
        root.requestFocus();
        primaryStage.setTitle("Maze Game");
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(mazeGameController);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}



