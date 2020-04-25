package pl.agh.edu.dp.labirynth.builders;

import pl.agh.edu.dp.labirynth.CountMaze;
import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.elements.Room;

public class CountMazeBuilder implements MazeBuilder
{
    private CountMaze currentMaze;

    public CountMazeBuilder() {
        this.currentMaze = new CountMaze();
    }

    @Override
    public void resetMaze() {
        this.currentMaze = new CountMaze();
    }

    @Override
    public void addRoom(Room newRoom) {
        this.currentMaze.addRooms(1);
        this.currentMaze.addWalls(4);
    }

    @Override
    public void setDoor(Room room1, Room room2) {
        this.currentMaze.addDoors(1);
        this.currentMaze.deleteWalls(1);
    }

    @Override
    public void setCommonWall(Room room1, Room room2, Direction direction) {
        this.currentMaze.deleteWalls(1);
    }

    public CountMaze getCurrentMaze() {
        return currentMaze;
    }
}
