package pl.agh.edu.dp.labirynth.factories;

import pl.agh.edu.dp.labirynth.elements.*;

public class EnchantedMazeFactory implements MazeFactory {
    @Override
    public Room createRoom(int n) {
        return new EnchantedRoom(n);
    }

    @Override
    public Wall createWall() {
        return new EnchantedWall();
    }

    @Override
    public Door createDoor(Room first, Room second) {
        return new EnchantedDoor(first, second);
    }
}
