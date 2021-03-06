package pl.agh.edu.dp.labirynth;

public enum Direction {
    North(0), East(1), South(2), West(3);

    private int value;

    Direction(int value) {
        this.value = value;
    }

    public static Direction oppositeSite(Direction direction) { return fromInt((direction.value + 2) % 4); }

    public static Direction nextSite(Direction direction) {
        return fromInt((direction.value + 1) % 4);
    }

    public static Direction prevSite(Direction direction) {
        return fromInt((direction.value + 3) % 4);
    }

    static Direction fromInt(int value) {
        for(Direction direction : values()) {
            if(direction.value == value){
                return direction;
            }
        }
        return null;
    }
}