package pl.edu.agh.dronka.shop.model;

public enum MusicGenre {
    ROCK("Rock"), INDIE("Indie"), POP("Pop");

    private String name;

    MusicGenre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static MusicGenre fromString(String name) {
        for(MusicGenre mg : MusicGenre.values()) {
            if(mg.name.equalsIgnoreCase(name)) {
                return mg;
            }
        }
        return null;
    }

}
