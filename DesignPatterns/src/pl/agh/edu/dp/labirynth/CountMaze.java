package pl.agh.edu.dp.labirynth;

public class CountMaze {

    private int roomCounter;
    private int doorCounter;
    private int wallCounter;

    public CountMaze() {
        this.roomCounter = 0;
        this.doorCounter = 0;
        this.wallCounter = 0;
    }

    public int getRoomCounter() {
        return roomCounter;
    }

    public void addRooms(int rooms) {
        this.roomCounter += rooms;
    }

    public void deleteRooms(int roomsNumber) {
        if(roomsNumber < this.roomCounter)
            this.roomCounter -= roomsNumber;
    }

    public int getDoorCounter() {
        return doorCounter;
    }

    public void addDoors(int doorsNumber) {
        this.doorCounter += doorsNumber;
    }

    public void deleteDoors(int doorsNumber) {
        if(doorsNumber < this.doorCounter)
            this.doorCounter -= doorsNumber;
    }

    public int getWallCounter() {
        return wallCounter;
    }

    public void addWalls(int wallsNumber) {
        this.wallCounter += wallsNumber;
    }

    public void deleteWalls(int wallsNumber) {
        if(wallsNumber < this.wallCounter)
            this.wallCounter -= wallsNumber;
    }
}
