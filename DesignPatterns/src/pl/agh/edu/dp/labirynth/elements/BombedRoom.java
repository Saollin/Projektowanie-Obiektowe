package pl.agh.edu.dp.labirynth.elements;

public class BombedRoom extends Room {
    public BombedRoom(int number) {
        super(number);
    }

    @Override
    public void Enter() {
        System.out.println("You're in bombed room");
    }

    @Override
    public String toString() {
        return String.valueOf(getRoomNumber());
    }
}
