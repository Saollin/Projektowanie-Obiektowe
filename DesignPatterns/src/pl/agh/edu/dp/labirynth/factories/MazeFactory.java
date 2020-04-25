package pl.agh.edu.dp.labirynth.factories;

import pl.agh.edu.dp.labirynth.elements.Door;
import pl.agh.edu.dp.labirynth.elements.Room;
import pl.agh.edu.dp.labirynth.elements.Wall;

public interface MazeFactory {
    Room createRoom(int n);
    Wall createWall();
    Door createDoor(Room first, Room second);
}
