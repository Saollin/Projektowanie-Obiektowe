package pl.agh.edu.dp.visualisation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

import java.util.ArrayList;
import java.util.List;

public class MazeGameController implements EventHandler<javafx.scene.input.KeyEvent> {

    @FXML
    private Label lifeValue;

    @FXML
    private Label message;

    @FXML
    private AnchorPane mazePane;

    @FXML
    private Button restartButton;

    private static MazeGameController instance;

    private Maze maze;
    private static Room startRoom;
    private static Room finishRoom;
    private boolean doesGameLast = true;

    private int playerStartLife = 30;
    private int rows;
    private int columns;
    private List<Room> rooms;

    private int widthOfRoom = 50;
    private int heightOfRoom = 50;

    private Player player;

    private MazeGameController() {
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

        this.player = new Player(playerStartLife, startRoom, Direction.East);
    }

    public void initialize() {
        drawAll();
        restartButton.setOnAction(actionEvent -> {
              player = new Player(playerStartLife, startRoom, Direction.East);
              doesGameLast = true;
              drawAll();
              mazePane.requestFocus();
        }
        );
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
        Room roomOfPlayer = player.getPlayerRoom();
        int number = roomOfPlayer.getRoomNumber();
        int row = number % columns;
        int column = number / columns;
        PlayerNode node = new PlayerNode(row * widthOfRoom, column * heightOfRoom, player);
        mazePane.getChildren().add(node);
        if(roomOfPlayer == finishRoom) {
            setMessage("Jesteś na mecie! Gratulacje.");
            doesGameLast = false;
        }
    }

    private void setLifeValue() {
        int life = player.getLifeValue();
        lifeValue.setText(String.valueOf(life));
        if(life <= 0) {
            setMessage("Straciłeś zbyt dużo obrażeń. Koniec gry :(");
            doesGameLast = false;
        }
    }

    public void setMessage(String communication) {
        message.setText(communication);
    }

    public void movePlayer(Direction direction) {
        if (doesGameLast) {
            switch(direction) {
                case North:
                    player.moveForward();
                    break;
                case East:
                    player.moveRight();
                    break;
                case West:
                    player.moveLeft();
                    break;
                case South:
                    player.moveBackward();
                    break;
            }
            drawAll();
        }
    }

    public void changePlayerRoom(Room first, Room second) {
        if(player.getPlayerRoom() == first) {
            player.setPlayerRoom(second);
            second.Enter();
        }
        else {
            player.setPlayerRoom(first);
            first.Enter();
        }
    }

    public void changePlayerLife(int value) {
        player.decrementLiveValue(value);
    }

    @Override
    public void handle(javafx.scene.input.KeyEvent keyEvent) {
        switch(keyEvent.getCode()) {
            case UP:
            case W:
                movePlayer(Direction.North);
                break;
            case RIGHT:
            case D:
                movePlayer(Direction.East);
                break;
            case DOWN:
            case S:
                movePlayer(Direction.South);
                break;
            case LEFT:
            case A:
                movePlayer(Direction.West);
                break;
        }
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

    class PlayerNode extends ImageView {

        private Image image = new Image(String.valueOf(getClass().getClassLoader().getResource("arr.png")));

        PlayerNode(double x, double y, Player player){
            super();
            this.setImage(image);
            this.setFitWidth(40);
            this.setFitHeight(40);
            setTranslateX(x + 5);
            setTranslateY(y + 5);
            switch(player.getPlayerDirection()) {
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
