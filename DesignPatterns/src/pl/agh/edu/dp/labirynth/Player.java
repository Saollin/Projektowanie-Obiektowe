package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.elements.Room;

public class Player {
    private Room playerRoom;
    Direction playerDirection;
    private int lifeValue;

    public Player(int startLifeValue, Room startRoom, Direction startDirection) {
        this.lifeValue = startLifeValue;
        this.playerDirection = startDirection;
        this.playerRoom = startRoom;
    }

    public Room getPlayerRoom() {
        return playerRoom;
    }

    public void setPlayerRoom(Room playerRoom) {
        this.playerRoom = playerRoom;
    }

    public void moveRight() {
        this.playerDirection = Direction.nextSite(this.playerDirection);
    }

    public void moveLeft() {
        this.playerDirection = Direction.prevSite(this.playerDirection);
    }

    public void moveForward() {
        playerRoom.getSide(playerDirection).Enter();
    }

    public void moveBackward() {
        playerRoom.getSide(Direction.oppositeSite(playerDirection)).Enter();
    }

    public void decrementLiveValue(int value) {
        this.lifeValue -= value;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public Direction getPlayerDirection() {
        return playerDirection;
    }
}
