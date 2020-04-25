package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.builders.MazeBuilder;
import pl.agh.edu.dp.labirynth.elements.Room;
import pl.agh.edu.dp.labirynth.factories.MazeFactory;

import java.util.ArrayList;
import java.util.List;

public class MazeGame {
    public void createMaze(MazeBuilder mazeBuilder, MazeFactory mazeFactory){
        List<Room> rooms = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            Room newRoom = mazeFactory.createRoom(i);
            rooms.add(newRoom);
            mazeBuilder.addRoom(newRoom);
        }
        /*  ___
           | 5 |___
           | 2 | 3 |
           |_1___4_|
         */
        mazeBuilder.setCommonWall(rooms.get(0), rooms.get(1), Direction.North);
        mazeBuilder.setCommonWall(rooms.get(1), rooms.get(2), Direction.East);
        mazeBuilder.setCommonWall(rooms.get(2), rooms.get(3), Direction.South);
        mazeBuilder.setCommonWall(rooms.get(3), rooms.get(0), Direction.West);
        mazeBuilder.setCommonWall(rooms.get(1), rooms.get(4), Direction.North);

        mazeBuilder.setDoor(rooms.get(0), rooms.get(1));
        mazeBuilder.setDoor(rooms.get(1), rooms.get(4));
        mazeBuilder.setDoor(rooms.get(2), rooms.get(3));
        mazeBuilder.setDoor(rooms.get(3), rooms.get(0));
    }
}
