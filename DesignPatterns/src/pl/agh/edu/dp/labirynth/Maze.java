package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.elements.Room;

import java.util.Vector;

public class Maze {
    private Vector<Room> rooms;
    private Room startRoom;
    private Room finishRoom;

    public Maze() {
        this.rooms = new Vector<>();
    }

    public Room getStartRoom() {
        return startRoom;
    }

    public void setStartRoom(Room startRoom) {
        this.startRoom = startRoom;
    }

    public Room getFinishRoom() {
        return finishRoom;
    }

    public void setFinishRoom(Room finishRoom) {
        this.finishRoom = finishRoom;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public int getRoomNumbers()
    {
        return rooms.size();
    }
}
