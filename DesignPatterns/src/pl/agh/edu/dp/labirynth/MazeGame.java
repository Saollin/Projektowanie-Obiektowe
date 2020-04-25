package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.builders.MazeBuilder;
import pl.agh.edu.dp.labirynth.elements.Room;
import pl.agh.edu.dp.labirynth.factories.MazeFactory;

import java.util.ArrayList;
import java.util.List;

public class MazeGame {
    private int rows = 9;
    private int columns = 10;
    private List<Room> rooms = new ArrayList<>();

    public void createMaze(MazeBuilder mazeBuilder, MazeFactory mazeFactory){
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                Room newRoom = mazeFactory.createRoom(columns * i + j);
                rooms.add(newRoom);
                mazeBuilder.addRoom(newRoom);
            }
        }
        /*  ___
           | 5 |___
           | 2 | 3 |
           |_1___4_|
         */
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(j == columns - 1) {
                    continue;
                }
                mazeBuilder.setCommonWall(rooms.get((columns * i) + j), rooms.get((columns * i) + j + 1), Direction.East);
            }
        }

        for(int i = 0; i < rows; i++) {
            if(i == rows - 1) {
                continue;
            }
            for(int j = 0; j < columns; j++) {
                mazeBuilder.setCommonWall(rooms.get(columns * i + j), rooms.get(columns * i + columns + j), Direction.South);
            }
        }

        mazeBuilder.setDoor(rooms.get(0), rooms.get(1));
        mazeBuilder.setDoor(rooms.get(1), rooms.get(2));
        mazeBuilder.setDoor(rooms.get(2), rooms.get(3));
        mazeBuilder.setDoor(rooms.get(0), rooms.get(10));
        mazeBuilder.setDoor(rooms.get(70), rooms.get(80));
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
