package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.builders.MazeBuilder;
import pl.agh.edu.dp.labirynth.builders.StandardBuilderMaze;
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
        mazeBuilder.setDoor(rooms.get(3), rooms.get(4));
        mazeBuilder.setDoor(rooms.get(4), rooms.get(5));
        mazeBuilder.setDoor(rooms.get(5), rooms.get(6));
        mazeBuilder.setDoor(rooms.get(6), rooms.get(7));
        mazeBuilder.setDoor(rooms.get(8), rooms.get(9));
        mazeBuilder.setDoor(rooms.get(11), rooms.get(12));
        mazeBuilder.setDoor(rooms.get(12), rooms.get(13));
        mazeBuilder.setDoor(rooms.get(13), rooms.get(14));
        mazeBuilder.setDoor(rooms.get(15), rooms.get(16));
        mazeBuilder.setDoor(rooms.get(21), rooms.get(22));
        mazeBuilder.setDoor(rooms.get(22), rooms.get(23));
        mazeBuilder.setDoor(rooms.get(26), rooms.get(27));
        mazeBuilder.setDoor(rooms.get(27), rooms.get(28));
        mazeBuilder.setDoor(rooms.get(28), rooms.get(29));
        mazeBuilder.setDoor(rooms.get(31), rooms.get(32));
        mazeBuilder.setDoor(rooms.get(35), rooms.get(36));
        mazeBuilder.setDoor(rooms.get(36), rooms.get(37));
        mazeBuilder.setDoor(rooms.get(37), rooms.get(38));
        mazeBuilder.setDoor(rooms.get(38), rooms.get(39));
        mazeBuilder.setDoor(rooms.get(40), rooms.get(41));
        mazeBuilder.setDoor(rooms.get(41), rooms.get(42));
        mazeBuilder.setDoor(rooms.get(42), rooms.get(43));
        mazeBuilder.setDoor(rooms.get(44), rooms.get(45));
        mazeBuilder.setDoor(rooms.get(45), rooms.get(46));
        mazeBuilder.setDoor(rooms.get(47), rooms.get(48));
        mazeBuilder.setDoor(rooms.get(48), rooms.get(49));
        mazeBuilder.setDoor(rooms.get(50), rooms.get(51));
        mazeBuilder.setDoor(rooms.get(51), rooms.get(52));
        mazeBuilder.setDoor(rooms.get(52), rooms.get(53));
        mazeBuilder.setDoor(rooms.get(54), rooms.get(55));
        mazeBuilder.setDoor(rooms.get(55), rooms.get(56));
        mazeBuilder.setDoor(rooms.get(56), rooms.get(57));
        mazeBuilder.setDoor(rooms.get(58), rooms.get(59));
        mazeBuilder.setDoor(rooms.get(61), rooms.get(62));
        mazeBuilder.setDoor(rooms.get(66), rooms.get(67));
        mazeBuilder.setDoor(rooms.get(67), rooms.get(68));
        mazeBuilder.setDoor(rooms.get(68), rooms.get(69));
        mazeBuilder.setDoor(rooms.get(76), rooms.get(77));
        mazeBuilder.setDoor(rooms.get(77), rooms.get(78));
        mazeBuilder.setDoor(rooms.get(78), rooms.get(79));
        mazeBuilder.setDoor(rooms.get(80), rooms.get(81));
        mazeBuilder.setDoor(rooms.get(81), rooms.get(82));
        mazeBuilder.setDoor(rooms.get(83), rooms.get(84));
        mazeBuilder.setDoor(rooms.get(85), rooms.get(86));
        mazeBuilder.setDoor(rooms.get(86), rooms.get(87));
        mazeBuilder.setDoor(rooms.get(87), rooms.get(88));
        mazeBuilder.setDoor(rooms.get(88), rooms.get(89));
        mazeBuilder.setDoor(rooms.get(0), rooms.get(10));
        mazeBuilder.setDoor(rooms.get(10), rooms.get(20));
        mazeBuilder.setDoor(rooms.get(20), rooms.get(30));
        mazeBuilder.setDoor(rooms.get(30), rooms.get(40));
        mazeBuilder.setDoor(rooms.get(50), rooms.get(60));
        mazeBuilder.setDoor(rooms.get(60), rooms.get(70));
        mazeBuilder.setDoor(rooms.get(70), rooms.get(80));
        mazeBuilder.setDoor(rooms.get(11), rooms.get(21));
        mazeBuilder.setDoor(rooms.get(61), rooms.get(71));
        mazeBuilder.setDoor(rooms.get(22), rooms.get(32));
        mazeBuilder.setDoor(rooms.get(62), rooms.get(72));
        mazeBuilder.setDoor(rooms.get(72), rooms.get(82));

        mazeBuilder.setDoor(rooms.get(23), rooms.get(33));
        mazeBuilder.setDoor(rooms.get(33), rooms.get(43));
        mazeBuilder.setDoor(rooms.get(53), rooms.get(63));
        mazeBuilder.setDoor(rooms.get(63), rooms.get(73));
        mazeBuilder.setDoor(rooms.get(73), rooms.get(83));

        mazeBuilder.setDoor(rooms.get(14), rooms.get(24));
        mazeBuilder.setDoor(rooms.get(24), rooms.get(34));
        mazeBuilder.setDoor(rooms.get(34), rooms.get(44));
        mazeBuilder.setDoor(rooms.get(54), rooms.get(64));
        mazeBuilder.setDoor(rooms.get(64), rooms.get(74));
        mazeBuilder.setDoor(rooms.get(74), rooms.get(84));

        mazeBuilder.setDoor(rooms.get(15), rooms.get(25));
        mazeBuilder.setDoor(rooms.get(25), rooms.get(35));
        mazeBuilder.setDoor(rooms.get(55), rooms.get(65));
        mazeBuilder.setDoor(rooms.get(65), rooms.get(75));
        mazeBuilder.setDoor(rooms.get(75), rooms.get(85));

        mazeBuilder.setDoor(rooms.get(16), rooms.get(26));
        mazeBuilder.setDoor(rooms.get(36), rooms.get(46));
        mazeBuilder.setDoor(rooms.get(66), rooms.get(76));

        mazeBuilder.setDoor(rooms.get(7), rooms.get(17));
        mazeBuilder.setDoor(rooms.get(47), rooms.get(57));

        mazeBuilder.setDoor(rooms.get(8), rooms.get(18));

        mazeBuilder.setDoor(rooms.get(9), rooms.get(19));
        mazeBuilder.setDoor(rooms.get(19), rooms.get(29));
        mazeBuilder.setDoor(rooms.get(39), rooms.get(49));
        mazeBuilder.setDoor(rooms.get(59), rooms.get(69));
        mazeBuilder.setDoor(rooms.get(79), rooms.get(89));

        ((StandardBuilderMaze) mazeBuilder).getCurrentMaze().setStartRoom(rooms.get(0));
        ((StandardBuilderMaze) mazeBuilder).getCurrentMaze().setFinishRoom(rooms.get(71));
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
