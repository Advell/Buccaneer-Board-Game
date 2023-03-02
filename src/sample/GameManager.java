package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.leftSideMenu.Menu.ArrowPopupController;
import sample.leftSideMenu.Menu.ShipActionController;
import sample.ports.Port;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import static sample.BoardController.BOARD;
import static sample.BoardController.TILE_SIZE;
import static sample.TreasureIsland.*;

public class GameManager extends Application {

    /*
        (()__(()
         /       \
        ( /    \  \
         \ o o    /
         (_()_)__/ \
        / _,==.____ \
       (   |--|      )  Thanks Lucasz for the hard work.
       /\_.|__|'-.__/\_
      / (        /     \
      \  \      (      /
       )  '._____)    /
    (((____.--(((____/mrf
         */

    public static Player currentPlayer;
    public boolean noOneWon;
    public static ArrayList<Player> PLAYERS;
    public static ArrayList<Port> PORTS;
    public ArrayList<CrewCard> CrewCards;
    private static CardManager cardManager = new CardManager();
    static BorderPane theGame;

    public GameManager() {
        PLAYERS = new ArrayList<>(4);
        PORTS = new ArrayList<>(6);
        CrewCards = new ArrayList<>(36);
        noOneWon = true;
    }

    private Parent getRightSideMenu() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("rightSideMenu/rightSideMenu.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    private Parent getLeftSideMenu() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("leftSideMenu/leftSideMenu.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    // CIRCULAR ARRAYLIST WITH SAVING
    public static Player getNextPlayer(Player curr) {
        Gson gsonObject = new GsonBuilder().setPrettyPrinting().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();//gson variable for saving use
        Iterator<Player> itr = PLAYERS.iterator();
        while (itr.hasNext()) {
            //saving
            try {
                FileWriter cardManageFileWriter = new FileWriter("cardmanager.json");//create save file for cardmanager
                gsonObject.toJson(cardManager, cardManageFileWriter);
                cardManageFileWriter.close();

                FileWriter playersFileWriter = new FileWriter("players.json");//create save file for players array
                gsonObject.toJson(PLAYERS, playersFileWriter);
                playersFileWriter.close();

                FileWriter portsFileWriter = new FileWriter("ports.json");//create save file for ports array
                gsonObject.toJson(PORTS, portsFileWriter);
                portsFileWriter.close();

                FileWriter currentPlayerFileWriter = new FileWriter("currentplayer.json");//create save file for currentplayer
                gsonObject.toJson(currentPlayer, currentPlayerFileWriter);
                currentPlayerFileWriter.close();

                /*FileWriter treasureFileWriter = new FileWriter("treasure.json");//create save file for treasure
                gsonObject.toJson(TREASURE,currentPlayerFileWriter);
                treasureFileWriter.close();
                //can save treasure but cannot load due to problems with gson deserialising ArrayLists of Enums*/

            } catch (IOException e) {
                e.printStackTrace();
            }
            Player next = itr.next();
            if (next.equals(curr)) {
                if (itr.hasNext()) return itr.next();
                else {
                    return PLAYERS.get(0);
                }
            }
        }
        return null;
    }

    public void saveGame() {

    }

    private void shipToMove(Ship ship) {
        ShipElement shipElement = ship.getShipElement();
    }

    public static ShipElement triggerBattle(ShipElement attackedShip) {
        return attackedShip;
    }

    public Parent getBoardPane() {
        BoardController board = new BoardController();
        return board.getBoardPane();
    }

    public static void treasureIsland(ShipElement shipElement) {
        Player player = null;

        for (Player p : PLAYERS) {
            if (p.getShip().getShipElement() == shipElement) {
                player = p;
            }
        }

        if (player != null) {
            CardManager.drawChanceCard(player);
        }
    }

    public static void flatIsland() {
        System.out.println("you stole from flat isalnd");
    }

    public static void anchorBay() {
        System.out.println("checks if you have card** if card take up to 7 treasure");
    }

    private int toBoard(double pixel) {
        return (int) (pixel + TILE_SIZE / 2) / TILE_SIZE;
    }

    @Override
    public void start(Stage stage) throws Exception {
        GameManager gm = new GameManager();
        String[] playernames = gm.setupScreen(stage);
        this.initialize(playernames);
        theGame = new BorderPane();
        theGame.setCenter(getBoardPane());
        theGame.setRight(getRightSideMenu());
        theGame.setLeft(getLeftSideMenu());
        Scene scene = new Scene(theGame);
        stage.setScene(scene);
        //initializeGame();
        stage.show();
    }

    public String[] setupScreen(Stage stage) {
        String[] names = null;
        try {
            Stage tempStage = new Stage();
            tempStage.setTitle("Buccaneer Game");
            Parent root = FXMLLoader.load(getClass().getResource("startupMenu/MainView.fxml"));
            Scene mainViewScene = new Scene(root);
            tempStage.setScene(mainViewScene);
            tempStage.showAndWait();
            if (tempStage.getScene().getWindow().getUserData() instanceof Player) { //TRIGGER LOAD
                //doLoad = true;
                System.exit(1);//exit for now as load doesn't work yet
                return null;
            }
            names = (String[]) tempStage.getScene().getWindow().getUserData(); //THESE ARE THE PLAYER NAMES
            for (String name : names) {
                System.out.println(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }

    public void initialize(String[] names) {
        //Create players and ships
        Ship player1Ship = new Ship();
        Ship player2Ship = new Ship();
        Ship player3Ship = new Ship();
        Ship player4Ship = new Ship();

        ArrayList<InGameColor> playerColours = new ArrayList<InGameColor>(4);
        playerColours.add(InGameColor.PURPLE);
        playerColours.add(InGameColor.RED);
        playerColours.add(InGameColor.YELLOW);
        playerColours.add(InGameColor.GREEN);
        Collections.shuffle(playerColours);

        Player player1 = new Player(playerColours.get(0), player1Ship, names[0]);
        Player player2 = new Player(playerColours.get(1), player2Ship, names[1]);
        Player player3 = new Player(playerColours.get(2), player3Ship, names[2]);
        Player player4 = new Player(playerColours.get(3), player4Ship, names[3]);
        //Add the players to the list of players
        PLAYERS.add(player1);
        PLAYERS.add(player2);
        PLAYERS.add(player3);
        PLAYERS.add(player4);

        //System.out.println(PLAYERS.get(0));

        //Set current player to be player 1
        //currentPlayer = PLAYERS.get(0);

        //Add ports to the list of ports
        PORTS.add(new Port(InGameColor.PURPLE, "Venice"));
        PORTS.add(new Port(InGameColor.YELLOW, "Cadiz"));
        PORTS.add(new Port(InGameColor.GREEN, "Marseilles"));
        PORTS.add(new Port(InGameColor.RED, "London"));
        PORTS.add(new Port(InGameColor.BLACK, "Amsterdam"));
        PORTS.add(new Port(InGameColor.BLACK, "Genoa"));

        //Initialize the treasure
        for (int i = 0; i < 4; i++) {
            TREASURE.add(Treasure.DIAMOND);
            TREASURE.add(Treasure.RUBY);
            TREASURE.add(Treasure.GOLD);
            TREASURE.add(Treasure.PEARL);
            TREASURE.add(Treasure.RUM);
        }

        //Create a card manager to initialize the decks
        cardManager = new CardManager();

        //Deal 5 crew cards from the decks to each player
        for (int i = 0; i < 5; i++) {
            CardManager.givePlayerCrewCard(player1, CardManager.drawCrewCard());
            CardManager.givePlayerCrewCard(player2, CardManager.drawCrewCard());
            CardManager.givePlayerCrewCard(player3, CardManager.drawCrewCard());
            CardManager.givePlayerCrewCard(player4, CardManager.drawCrewCard());
        }

        //Deal two cards to each trading port
        int amsterdamCardValue = 0, genoaCardValue = 0;

        Port amsterdam = PORTS.get(4);
        Port genoa = PORTS.get(5);

        for (int i = 0; i < 2; i++) {
            //Amsterdam
            CrewCard amsterdamCard = CardManager.drawCrewCard();
            amsterdamCardValue += amsterdamCard.value;
            amsterdam.addCrewCard(amsterdamCard);

            //Genoa
            CrewCard genoaCard = CardManager.drawCrewCard();
            genoaCardValue += genoaCard.value;
            genoa.addCrewCard(genoaCard);
        }

        //Give treasure to trading ports based on value of cards given to port
        //This code is awful
        switch (amsterdamCardValue) {
            case 2 -> {
                amsterdam.addTreasure(TreasureIsland.takeTreasure(5));
                amsterdam.addTreasure(TreasureIsland.takeTreasure(1));
            }
            case 3 -> amsterdam.addTreasure(TreasureIsland.takeTreasure(5));
            case 4 -> amsterdam.addTreasure(TreasureIsland.takeTreasure(4));
            case 5 -> amsterdam.addTreasure(TreasureIsland.takeTreasure(3));
            case 6 -> amsterdam.addTreasure(TreasureIsland.takeTreasure(2));
            case 7 -> amsterdam.addTreasure(TreasureIsland.takeTreasure(1));
        }

        switch (genoaCardValue) {
            case 2 -> {
                genoa.addTreasure(TreasureIsland.takeTreasure(5));
                genoa.addTreasure(TreasureIsland.takeTreasure(1));
            }
            case 3 -> genoa.addTreasure(TreasureIsland.takeTreasure(5));
            case 4 -> genoa.addTreasure(TreasureIsland.takeTreasure(4));
            case 5 -> genoa.addTreasure(TreasureIsland.takeTreasure(3));
            case 6 -> genoa.addTreasure(TreasureIsland.takeTreasure(2));
            case 7 -> genoa.addTreasure(TreasureIsland.takeTreasure(1));
        }

    }

    private Player battle(Player Attacker, Player Defender) {
        if (Attacker.getPirateScore() < Defender.getPirateScore()) {
            return Attacker;
        } else {
            return Defender;
        }
    }

    public static void launchTradeWindow(Port port) {
        BorderPane p = (BorderPane) theGame.getRight();
        VBox dialogVbox = new VBox(20);
        //TradingController tradingController = new TradingController(new Player(),this);
        try {
            System.out.println("load");
            FXMLLoader fxmlLoader = new FXMLLoader(GameManager.class.getResource("rightSideMenu/trade/trading_3.0.fxml"));
            Parent root = fxmlLoader.load();
//            ShipActionController shipController = fxmlLoader.<ShipActionController>getController();
//            shipController.setShipElement(currentPlayer.getPlayersShip().getShipElement());

//                shipController.setShipElement(this.shipElement);
//                ArrowPopupController arrowController = fxmlLoader.<ArrowPopupController>getController();
//                arrowController.setTileDir(this);
//                arrowController.setShipElementDir(this.shipElement);
            dialogVbox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        p.setTop(dialogVbox);
    }

    public static void launchShipMoveMenu() {
        BorderPane p = (BorderPane) theGame.getLeft();
        VBox dialogVbox = new VBox(20);
        try {
            System.out.println("load");
            FXMLLoader fxmlLoader = new FXMLLoader(BoardController.class.getResource("/sample/leftSideMenu/Menu/ShipActionView.fxml"));
            Parent root = fxmlLoader.load();
            ShipActionController shipController = fxmlLoader.<ShipActionController>getController();
            shipController.setShipElement(currentPlayer.getPlayersShip().getShipElement());
            dialogVbox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        p.setTop(dialogVbox);
    }

    public static void launchDirectionSelection() {
        BorderPane p = (BorderPane) theGame.getLeft();
        FXMLLoader fxmlLoader = new FXMLLoader(GameManager.class.getResource("/sample/leftSideMenu/Menu/ArrowPopup.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrowPopupController controller = fxmlLoader.<ArrowPopupController>getController();
        ShipElement shipElement = currentPlayer.getPlayersShip().getShipElement();
        controller.setTileDir(BOARD[shipElement.getBoardX()][shipElement.getBoardY()]);
        controller.setShipElement(shipElement);
        p.setBottom(root);
    }

    public static void exitDirectionSelection() {
        BorderPane p = (BorderPane) theGame.getLeft();
        p.setBottom(null);
    }

    public static void exitShipMoveMenu() {
        BorderPane p = (BorderPane) theGame.getLeft();
        if (p != null) p.setTop(null);
    }

    public static void exitTradeWindow() {
        BorderPane p = (BorderPane) theGame.getRight();
        if (p != null) p.setTop(null);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
