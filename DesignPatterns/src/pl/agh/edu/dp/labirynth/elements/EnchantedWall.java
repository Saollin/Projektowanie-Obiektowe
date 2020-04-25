package pl.agh.edu.dp.labirynth.elements;

public class EnchantedWall extends Wall {

    @Override
    public void Enter() {
        System.out.println("You've hit enchanted wall!");
    }
}
