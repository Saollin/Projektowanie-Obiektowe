package pl.agh.edu.dp.visualisation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.MazeGame;
import pl.agh.edu.dp.labirynth.builders.StandardBuilderMaze;
import pl.agh.edu.dp.labirynth.elements.BombedWall;
import pl.agh.edu.dp.labirynth.elements.Room;
import pl.agh.edu.dp.labirynth.elements.Wall;
import pl.agh.edu.dp.labirynth.factories.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factories.MazeFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MazeGameController {

    @FXML
    private Label lifeValue;

    @FXML
    private Label message;

    @FXML
    private AnchorPane mazePane;

    private static Room startRoom;
    private static Room finishRoom;

    private int rows;
    private int columns;
    private List<Room> rooms;

    private int widthOfRoom = 50;
    private int heightOfRoom = 50;

    public MazeGameController() {
        MazeGame game = new MazeGame();
        MazeFactory factory = BombedMazeFactory.getInstance();
        StandardBuilderMaze sbm = new StandardBuilderMaze(factory);
        game.createMaze(sbm, factory);
        this.rows = game.getRows();
        this.columns = game.getColumns();
        this.rooms = game.getRooms();
        this.startRoom = rooms.get(0);
    }

    public void initialize() {
        drawMaze();
    }

    private void drawMaze() {
        for(int i = 0; i < columns; i++) {
            for(int j = 0; j < rows; j++) {
                Room room = rooms.get(rows * i + j);
                RoomNode roomNode = new RoomNode(j * widthOfRoom, i * heightOfRoom, widthOfRoom, heightOfRoom, room);
                mazePane.getChildren().add(roomNode);
            }
        }
    }

    public static class RoomNode extends StackPane {

        public RoomNode(double x, double y, double width, double height, Room room) {

            // create rectangle
            Rectangle interior = new Rectangle(width, height);
            interior.setStroke(Color.BLACK);
            interior.setStrokeWidth(5);
            interior.setStrokeType(StrokeType.INSIDE);

            double borderWidth = width - 10;
            double borderHeight = 12;
            if(room == startRoom) {
                interior.setFill(Color.GREEN);
            }
            else if(room == finishRoom) {
                interior.setFill(Color.RED);
            }
            else {
                interior.setFill(Color.WHITE);
            }
            ArrayList<DoorNode> doors = new ArrayList<>();
            for(Direction direction:Direction.values()) {
                if(!(room.getSide(direction) instanceof BombedWall)){
                    DoorNode door;
                    switch (direction) {
                        case East:
                            door = new DoorNode(width / 2, 0, borderHeight, borderWidth);
                            doors.add(door);
                            break;
                        case South:
                            door = new DoorNode(0, height/2, borderWidth, borderHeight);
                            doors.add(door);
                            break;
                        case West:
                            door = new DoorNode(-width / 2, 0, borderHeight, borderWidth);
                            doors.add(door);
                            break;
                        case North:
                            System.out.println(height);
                            door = new DoorNode(0, -height / 2, borderWidth, borderHeight);
                            doors.add(door);
                            break;
                    }
                }
            }

            // set position
            setTranslateX(x);
            setTranslateY(y);

            // create interior
            getChildren().addAll(interior);
            for(DoorNode doorNode : doors) {
                getChildren().add(doorNode);
            }
        }

        public static class DoorNode extends StackPane {

            public DoorNode(double x, double y, double width, double height) {

                // create rectangle
                Rectangle wall = new Rectangle(width, height);
                wall.setFill(Color.WHITE);
                wall.setStroke(Color.WHITE);
                wall.setStrokeWidth(0);

                // set position
                setTranslateX(x);
                setTranslateY(y);

                // create interior
                getChildren().addAll(wall);
            }
        }
    }
    public static class PlayerNode extends StackPane {

        public PlayerNode(double x, double y, double width, double height, Color color) {
            double radius = Math.min(width, height);
            Circle circle = new Circle(radius,color);

            setTranslateX(x + width/2);
            setTranslateY(y + height/2);

            getChildren().addAll(circle);
        }
    }
}
