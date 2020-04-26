package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.elements.Room;

public class Player {
    private Room room;
    Direction direction;
    private int lifeValue;

    public Player(int startLifeValue, Room startRoom, Direction startDirection) {
        this.lifeValue = startLifeValue;
        this.direction = startDirection;
        this.room = startRoom;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void moveRight() {
        this.direction = Direction.nextSite(this.direction);
    }

    public void moveLeft() {
        this.direction = Direction.prevSite(this.direction);
    }

    public void decrementLiveValue(int value) {
        this.lifeValue -= value;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public Direction getDirection() {
        return direction;
    }
}
