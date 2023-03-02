package sample;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Popup;
import javafx.stage.Stage;
import sample.ports.PlayerPort;
import sample.ports.Port;
import sample.ports.TradingPort;
import sample.Player;
import sample.tiles.*;
import sample.tiles.SeaTile;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import static sample.BoardController.*;
import static sample.GameManager.PLAYERS;


public class BoardModel {

    InputStream shipImageGreen;
    InputStream shipImagePurple;
    InputStream shipImageRed;
    InputStream shipImageYellow;

    public void initializeContents() {
        shipImageGreen = this.getClass().getResourceAsStream("resources/shipImages/GreenShip.png");
        shipImagePurple = this.getClass().getResourceAsStream("resources/shipImages/PurpleShip.png");
        shipImageRed = this.getClass().getResourceAsStream("resources/shipImages/RedShip.png");
        shipImageYellow = this.getClass().getResourceAsStream("resources/shipImages/YellowShip.png");
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Tile tile;
                if (x >= Location.TreasureIslandTop.x && x <= Location.TreasureIslandBottom.x && y >= Location.TreasureIslandTop.y && y <= Location.TreasureIslandBottom.y) {
                    tile = new LandTile(x, y);
                } else if (((x == Location.TreasureIslandTop.x - 1 || x == Location.TreasureIslandBottom.x + 1) && (y <= Location.TreasureIslandBottom.y &&
                        y >= Location.TreasureIslandTop.y)) || ((y == Location.TreasureIslandTop.y - 1 || y == Location.TreasureIslandBottom.y + 1) &&
                        (x >= Location.TreasureIslandTop.x && x <= Location.TreasureIslandBottom.x))) {
                    tile = new TreasureIslandTile(x, y);
                } else if (x == 0 || x == 21 || y == 0 || y == 21) {
                    tile = new LandTile(x, y);
                } else if (x == Location.Venice.x && y == Location.Venice.y) {
                    tile = new PortTile(x, y, new PlayerPort(InGameColor.PURPLE, "Venice"));
                } else if (x == 1 && y == Location.London.y) {
                    tile = new PortTile(x, y, new PlayerPort(InGameColor.RED, "London"));
                } else if ((x == Location.Cadiz.x && y == Location.Cadiz.y)) {
                    tile = new PortTile(x, y, new PlayerPort(InGameColor.YELLOW, "Cadiz"));
                } else if ((x == Location.Amsterdam.x && y == Location.Amsterdam.y)) {
                    tile = new PortTile(x, y, new TradingPort(InGameColor.BLACK, "Amsterdam"));
                } else if ((x == Location.Marseilles.x && y == Location.Marseilles.y)) {
                    tile = new PortTile(x, y, new PlayerPort(InGameColor.GREEN, "Marseilles"));
                } else if ((x == Location.Genoa.x && y == Location.Genoa.y)) {
                    tile = new PortTile(x, y, new TradingPort(InGameColor.BLACK, "Genoa"));
                } else if ((x == Location.AnchorBay.x) && (y == Location.AnchorBay.y)) {
                    tile = new AnchorBayTile(x, y);

                } else if ((x >= Location.FlatIslandTop.x && x <= Location.FlatIslandBottom.x && y >= Location.FlatIslandBottom.y && y <= Location.FlatIslandTop.y)) {
                    tile = new LandTile(x, y);
                } else if ((x >= Location.PirateIslandTop.x && x <= Location.PirateIslandBottom.x && y >= Location.PirateIslandBottom.y && y <= Location.PirateIslandTop.y)) {
                    tile = new LandTile(x, y);
                } else if ((x == 1 && y > 1 && y <= 4) || (x == 4 && y > 1 && y <= 4)) {
                    tile = new FlatIslandTile(x, y);
                } else if ((y == 1 && (x == 2 || x == 3)) || (y == 5 && (x == 2 || x == 3))) {
                    tile = new FlatIslandTile(x, y);
                } else tile = new SeaTile(x, y);


                BOARD[x][y] = tile;
                tileGroup.getChildren().add(tile);

                ShipElement shipElement = null;

                Player redPlayer = null;
                Player yellowPlayer = null;
                Player greenPlayer = null;
                Player purplePlayer = null;

                for (Player p : PLAYERS) {
                    switch (p.getColor()) {
                        case PURPLE:
                            purplePlayer = p;
                            break;
                        case RED:
                            redPlayer = p;
                            break;
                        case GREEN:
                            greenPlayer = p;
                            break;
                        case YELLOW:
                            yellowPlayer = p;
                            break;
                    }
                }

                if (x == Location.London.x && y == HEIGHT - Location.London.y - 1)
                    redPlayer.getShip().setShipElement(shipElement = makeShip(shipImagePurple, x, y, Directions.SE));
                if (x == Location.Venice.x && y == HEIGHT - Location.Venice.y - 1)
                    purplePlayer.getShip().setShipElement(shipElement = makeShip(shipImageRed, x, y, Directions.E));
                if (x == Location.Cadiz.x && y == Location.Cadiz.y)
                    yellowPlayer.getShip().setShipElement(shipElement = makeShip(shipImageYellow, x, y, Directions.N));
                if (x == Location.Marseilles.x && y == Location.Marseilles.y)
                    greenPlayer.getShip().setShipElement(shipElement = makeShip(shipImageGreen, x, y, Directions.N));
                if (shipElement != null) {
                    tile.setShip(shipElement);
                    shipGroup.getChildren().add(shipElement);
                }
            }
        }
    }

    private int toBoard(double pixel) {
        return (int) (pixel + TILE_SIZE / 2) / TILE_SIZE;
    }

    private ShipElement makeShip(InputStream shipPic, int x, int y, Directions d) {
        ShipElement shipElement;
        BOARD[x][y].setShip(shipElement = new ShipElement(x, y, d, shipPic));
        return shipElement;
    }

    private boolean isBorder(int x, int y) {
        return (x <= 0 || y <= 0 || x >= WIDTH || y >= HEIGHT);
    }

    public static void showPopUp(ShipElement shipElement) {
        POPUP = new Popup();
        Parent root = null;
        try {
            root = FXMLLoader.load(BoardModel.class.getResource("ShipActionView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        if (!POPUP.isShowing()) POPUP.show(stage);
        else POPUP.hide();
    }
}