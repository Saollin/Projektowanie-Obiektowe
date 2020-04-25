package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;

    public static Direction oppositeSite(Direction direction) {
        switch(direction) {
            case East:
                return West;
            case South:
                return North;
            case West:
                return East;
            case North:
                return South;
            default:
                return null;
        }
    }
}