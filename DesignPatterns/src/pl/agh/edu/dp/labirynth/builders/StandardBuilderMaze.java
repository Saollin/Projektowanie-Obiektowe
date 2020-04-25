package pl.agh.edu.dp.labirynth.builders;

import pl.agh.edu.dp.labirynth.*;

public class StandardBuilderMaze implements MazeBuilder {
    private Maze currentMaze;
    private int roomCounter;

    public StandardBuilderMaze() {
        this.currentMaze = new Maze();
        this.roomCounter = 0;
    }

    @Override
    public void resetMaze() {
        this.currentMaze = new Maze();
    }

    @Override
    public void addRoom(Room newRoom) {
        for(Direction direction:Direction.values()) {
            newRoom.setSide(direction, new Wall());
        }
        this.currentMaze.addRoom(newRoom);
    }

    @Override
    public void setDoor(Room first, Room second) {
        Direction commonWallDirection = commonWall(first, second);
        if(commonWallDirection == null) {
            System.out.println("No common wall between these rooms");
            return;
        }
        Door newDoor = new Door(first, second);
        first.setSide(commonWallDirection, newDoor);
        second.setSide(Direction.oppositeSite(commonWallDirection), newDoor);
    }

    @Override
    public void setCommonWall(Room first, Room second, Direction directionInFirst) {
        if(first.getSide(directionInFirst) == null) {
            first.setSide(directionInFirst, new Wall());
        }
        second.setSide(Direction.oppositeSite(directionInFirst), first.getSide(directionInFirst));
    }

    private Direction commonWall(Room first, Room second) {
        for(Direction direction : Direction.values()) {
            if(first.getSide(direction) == second.getSide(Direction.oppositeSite(direction)))
                return direction;
        }
        return null;
    }

    public Maze getCurrentMaze() {
        return currentMaze;
    }
}
