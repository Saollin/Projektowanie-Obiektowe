package pl.agh.edu.dp.labirynth.builders;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.elements.Room;

public interface MazeBuilder {

    void resetMaze();
    void addRoom(Room newRoom);
    void setDoor(Room first, Room second);
    void setCommonWall(Room first, Room second, Direction directionOfFirst);

}
