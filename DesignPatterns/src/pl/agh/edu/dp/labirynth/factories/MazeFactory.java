package pl.agh.edu.dp.labirynth.factories;

import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

public interface MazeFactory {
    Room createRoom(int n);
    Wall createWall();
    Door createDoor(Room first, Room second);
}
