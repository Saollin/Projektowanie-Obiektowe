package pl.agh.edu.dp.labirynth.factories;

import pl.agh.edu.dp.labirynth.elements.*;

public class BombedMazeFactory implements MazeFactory
{
    @Override
    public Room createRoom(int n) {
        return new BombedRoom(n);
    }

    @Override
    public Wall createWall() {
        return new BombedWall();
    }

    @Override
    public Door createDoor(Room first, Room second) {
        return new Door(first, second);
    }
}
