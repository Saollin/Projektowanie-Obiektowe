package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.builders.CountMazeBuilder;
import pl.agh.edu.dp.labirynth.builders.StandardBuilderMaze;

public class Main {

    public static void main(String[] args) {

        MazeGame mazeGame = new MazeGame();
        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze();
        mazeGame.createMaze(standardBuilderMaze);
        Maze maze = standardBuilderMaze.getCurrentMaze();

        CountMazeBuilder countMazeBuilder = new CountMazeBuilder();
        mazeGame.createMaze(countMazeBuilder);
        CountMaze counter = countMazeBuilder.getCurrentMaze();
        System.out.println("Pokoje: " + counter.getRoomCounter());
        System.out.println("Ściany: " + counter.getWallCounter());
        System.out.println("Drzwi: " + counter.getDoorCounter());
    }
}



