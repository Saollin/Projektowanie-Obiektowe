package pl.agh.edu.dp.visualisation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.MazeGame;
import pl.agh.edu.dp.labirynth.Player;
import pl.agh.edu.dp.labirynth.builders.StandardBuilderMaze;
import pl.agh.edu.dp.labirynth.elements.BombedWall;
import pl.agh.edu.dp.labirynth.elements.Room;
import pl.agh.edu.dp.labirynth.factories.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factories.MazeFactory;

import java.awt.event.KeyEvent;
import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.List;

public class MazeGameController {

    @FXML
    private Label lifeValue;

    @FXML
    private Label message;

    @FXML
    private AnchorPane mazePane;

    private static MazeGameController instance;

    private Maze maze;
    private static Room startRoom;
    private static Room finishRoom;

    private int rows;
    private int columns;
    private List<Room> rooms;

    private int widthOfRoom = 50;
    private int heightOfRoom = 50;

    private Player player;

    public MazeGameController() {
        MazeGame game = new MazeGame();
        MazeFactory factory = BombedMazeFactory.getInstance();
        StandardBuilderMaze sbm = new StandardBuilderMaze(factory);
        game.createMaze(sbm, factory);
        this.maze = sbm.getCurrentMaze();
        this.startRoom = maze.getStartRoom();
        this.finishRoom = maze.getFinishRoom();

        this.rows = game.getRows();
        this.columns = game.getColumns();
        this.rooms = game.getRooms();

        this.player = new Player(30, startRoom, Direction.East);
    }

    public void initialize() {
        drawAll();

    }

    public void drawAll() {
        drawMaze();
        drawPlayer();
        setLifeValue();
    }

    private void drawMaze() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                Room room = rooms.get(columns * i + j);
                RoomNode roomNode = new RoomNode(j * widthOfRoom, i * heightOfRoom, widthOfRoom, heightOfRoom, room);
                mazePane.getChildren().add(roomNode);
            }
        }
    }

    private void drawPlayer() {
        Room roomOfPlayer = player.getRoom();
        int number = roomOfPlayer.getRoomNumber();
        int row = number % columns;
        int column = number / columns;
        System.out.println(column);
        PlayerNode node = new PlayerNode(row * widthOfRoom, column * heightOfRoom, player);
        mazePane.getChildren().add(node);
    }

    private void setLifeValue() {
        lifeValue.setText(String.valueOf(player.getLifeValue()));
    }

    public void movePlayer() {
        player.moveRight();
        drawAll();
    }

    public static class RoomNode extends StackPane {

        public RoomNode(double x, double y, double width, double height, Room room) {

            // create rectangle
            Rectangle interior = new Rectangle(width, height);
            interior.setStroke(Color.BLACK);
            interior.setStrokeWidth(6);
            interior.setStrokeType(StrokeType.INSIDE);

            double borderWidth = width - 13;
            double borderHeight = 14;
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
//    public static class PlayerNode extends StackPane {
//
//        public PlayerNode(double x, double y, double width, double height, Color color) {
//            double radius = Math.min(width, height);
//            Circle circle = new Circle(radius,color);
//
//            setTranslateX(x + width/2);
//            setTranslateY(y + height/2);
//
//            getChildren().addAll(circle);
//        }
//    }
    class PlayerNode extends ImageView {

        private Image image = new Image(String.valueOf(getClass().getClassLoader().getResource("arr.png")));

        PlayerNode(double x, double y, Player player){
            super();
            this.setImage(image);
            this.setFitWidth(40);
            this.setFitHeight(40);
            setTranslateX(x + 5);
            setTranslateY(y + 5);
            switch(player.getDirection()) {
                case North:
                    this.rotateProperty().setValue(270);
                    break;
                case South:
                    this.rotateProperty().setValue(90);
                    break;
                case West:
                    this.rotateProperty().setValue(180);
                    break;
            }
        }
    }

    public static MazeGameController getInstance() {
        if(instance == null) {
            instance = new MazeGameController();
        }
        return instance;
    }
}
