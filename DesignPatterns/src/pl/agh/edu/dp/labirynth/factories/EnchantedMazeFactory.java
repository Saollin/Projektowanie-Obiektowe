package pl.agh.edu.dp.labirynth.factories;

import pl.agh.edu.dp.labirynth.elements.*;

import java.util.Map;

public class EnchantedMazeFactory implements MazeFactory {
    private static EnchantedMazeFactory instance;

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

    public static EnchantedMazeFactory getInstance() {
        if(instance == null) {
            instance = new EnchantedMazeFactory();
        }
        return instance;
    }
}
