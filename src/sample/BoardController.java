package sample;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import sample.tiles.Tile;

import java.io.InputStream;

import static sample.GameManager.*;

public class BoardController {

    BoardModel model;
    public static final int TILE_SIZE = 45;
    public static final int WIDTH = 22;
    public static final int HEIGHT = 22;
    public static boolean BATTLE = false;
    ImageView boardImage;

    public static final Tile[][] BOARD = new Tile[WIDTH][HEIGHT];

    public static final Group tileGroup = new Group();
    public static final Group shipGroup = new Group();
    public static final Group mapContents = new Group();

    public static Popup POPUP;

    //FileInputStream inputStream;
    //private Image sea_gif;
    private final InputStream imagePic = this.getClass().getResourceAsStream("resources/board_graphic.png");

    public static void switchPlayers() {
        exitTradeWindow();
        currentPlayer = getNextPlayer(currentPlayer);
        if (currentPlayer != null) {
            currentPlayer.getShip().getShipElement().changeSelected();
            startTurn();
        }
    }

    private static void startTurn() {
        if (BOARD[currentPlayer.getPlayersShip().getShipElement().getBoardX()][currentPlayer.getPlayersShip().getShipElement().getBoardY()].isPort()) {
            exitShipMoveMenu();
            BOARD[currentPlayer.getPlayersShip().getShipElement().getBoardX()][currentPlayer.getPlayersShip().getShipElement().getBoardY()].
                    highlightMoves(currentPlayer.getPlayersShip().getShipElement(), false);
        }
        else createPopup();
    }

    public BoardController() {
        initializeBoard();
    }

    public Parent getBoardPane() {
        Pane theBoard = new Pane();

        try {
            boardImage = new ImageView();
            assert imagePic != null;
            boardImage.setImage(new Image(imagePic));
            boardImage.setFitWidth(WIDTH * TILE_SIZE);
            boardImage.setFitHeight(HEIGHT * TILE_SIZE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        theBoard.setPrefSize(TILE_SIZE * WIDTH, TILE_SIZE * HEIGHT);
        theBoard.getChildren().addAll(boardImage, tileGroup, mapContents, shipGroup);
        return theBoard;
    }
    public static void createPopup(){
        launchShipMoveMenu();
    }

    public void initializeBoard() {
        model = new BoardModel();
        model.initializeContents();
        currentPlayer = PLAYERS.get(0);
        currentPlayer.getPlayersShip().getShipElement().changeSelected();
        startTurn();
    }
}
