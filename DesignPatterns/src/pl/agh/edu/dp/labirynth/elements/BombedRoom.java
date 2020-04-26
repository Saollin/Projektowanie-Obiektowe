package pl.agh.edu.dp.labirynth.elements;

import pl.agh.edu.dp.visualisation.MazeGameController;

public class BombedRoom extends Room {
    public BombedRoom(int number) {
        super(number);
    }

    @Override
    public void Enter() {
        MazeGameController.getInstance().setMessage("Jesteś w kolejnym pokoju. Chyba zbliżasz się do celu :)");
    }

    @Override
    public String toString() {
        return String.valueOf(getRoomNumber());
    }
}
