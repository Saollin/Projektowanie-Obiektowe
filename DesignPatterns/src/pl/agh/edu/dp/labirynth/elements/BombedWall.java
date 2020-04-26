package pl.agh.edu.dp.labirynth.elements;

import pl.agh.edu.dp.visualisation.MazeGameController;

public class BombedWall extends Wall {
    private int damage;

    public BombedWall() {
        this.damage = 5;
    }
    @Override
    public void Enter() {
        MazeGameController.getInstance().changePlayerLife(damage);
        MazeGameController.getInstance().setMessage("Uderzyłeś w ścianę! Tracisz 5 punktów życia.");
    }
}
