package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.builders.MazeBuilder;

public class MazeGame {
    public void createMaze(MazeBuilder mazeBuilder){
        Room room1 = new Room(1);
        Room room2 = new Room(2);
        Room room3 = new Room(3);
        Room room4 = new Room(4);
        Room room5 = new Room(5);

        mazeBuilder.addRoom(room1);
        mazeBuilder.addRoom(room2);
        mazeBuilder.addRoom(room3);
        mazeBuilder.addRoom(room4);
        mazeBuilder.addRoom(room5);
        /*  ___
           | 5 |___
           | 2 | 3 |
           |_1___4_|
         */
        mazeBuilder.setCommonWall(room1, room2, Direction.North);
        mazeBuilder.setCommonWall(room2, room3, Direction.East);
        mazeBuilder.setCommonWall(room3, room4, Direction.South);
        mazeBuilder.setCommonWall(room4, room1, Direction.West);
        mazeBuilder.setCommonWall(room2, room5, Direction.North);

        mazeBuilder.setDoor(room1, room2);
        mazeBuilder.setDoor(room2, room5);
        mazeBuilder.setDoor(room3, room4);
        mazeBuilder.setDoor(room4, room1);
    }
}
