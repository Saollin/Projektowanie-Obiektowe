package pl.agh.edu.dp.labirynth.elements;

public class BombedWall extends Wall {
    @Override
    public void Enter() {
        System.out.println("You've hit bombed wall!");
    }
}
