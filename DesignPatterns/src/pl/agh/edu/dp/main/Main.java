package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.builders.CountMazeBuilder;
import pl.agh.edu.dp.labirynth.builders.StandardBuilderMaze;
import pl.agh.edu.dp.labirynth.factories.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factories.MazeFactory;

public class Main {

    public static void main(String[] args) {

        MazeGame mazeGame = new MazeGame();
        MazeFactory factory = BombedMazeFactory.getInstance();
        MazeFactory factory2 = BombedMazeFactory.getInstance();
        if(factory == factory2) {
            System.out.println("The same objects");
        }
        else {
            System.out.println("Not the same objects");
        }
    }
}



