package sample.tiles;

import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.*;

import java.io.InputStream;
import java.util.ArrayList;

import static sample.BoardController.*;
import static sample.BoardModel.*;
import static sample.GameManager.*;

public class Tile extends Rectangle {
    ShipElement shipElement;
    boolean accessible;
    boolean basic;
    int x0, y0;
    Color baseColor;
    ImagePattern selected;
    ImagePattern highlighted;

    public static Player playerOnTile;


    public Tile(int x, int y) {
        loadPictures();
        baseColor = Color.LIGHTBLUE;
        setWidth(TILE_SIZE);
        setHeight(TILE_SIZE);
        relocate(x * TILE_SIZE, y * TILE_SIZE);
        fillStandard();
        basic = true;
        hoverProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean show) -> {
            whenHover(show);
        });
        setOnMouseClicked(mouseEvent -> {
            whenClickedOn(x, y);
        });
    }

    void loadPictures() {
    }

    void whenHover(boolean show) {

    }

    public void whenClickedOn(int x, int y) {

    }

    void fillStandard() {
        setFill(baseColor);
    }

    public ShipElement getShip() {
        return shipElement;
    }

    public void setShip(ShipElement shipElement) {
        this.shipElement = shipElement;
        if (this.shipElement == null) fillStandard();
    }

    public boolean hasShip() {
        return this.shipElement != null;
    }

    protected void unHighlightSpecifically() {

    }

    boolean highlight(int x0, int y0) {
        if (hasShip()) setFill(Color.RED);
        else setFill(highlighted);
        accessible = true;
        this.x0 = x0;
        this.y0 = y0;
        return false;
    }

    boolean unhighlight(int x0, int y0) {
        setFill(baseColor);
        accessible = false;
        this.x0 = x0;
        this.y0 = y0;
        return false;
    }

    public boolean isAccessible() {
        return accessible;
    }

    private int toBoard(double pixel) {
        return (int) (pixel + TILE_SIZE / 2) / TILE_SIZE;
    }

    private boolean isBorder(int x, int y) {
        return (x <= 0 || y <= 0 || x > WIDTH - 1 || y > HEIGHT - 1);
    }

    public void highlightMoves(ShipElement shipElement, boolean unhighlight_flag) {
        Directions direction = shipElement.getDirection();
        highlightDirection(shipElement, direction, unhighlight_flag);
    }

    void highlightDirection(ShipElement shipElement, Directions direction, boolean unhighlight_flag) {
        int x0 = toBoard(shipElement.getCurrentX());
        int y0 = toBoard(shipElement.getCurrentY());
        int max = currentPlayer.getCrewScore();
        System.out.println(max);// MAX POSSIBLE MOVE
        int move = 0;
        switch (direction) {
            case N:
                while (move <= max && !isBorder(x0, y0 - 1)) {
                    y0--;
                    move++;
                    if (!unhighlight_flag) {
                        if (BOARD[x0][y0].highlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                            break;
                    } else if (BOARD[x0][y0].unhighlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                        break;
                }
                break;
            case S:
                while (move <= max && !isBorder(x0, y0 + 1)) {
                    y0++;
                    move++;
                    if (!unhighlight_flag) {
                        if (BOARD[x0][y0].highlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                            break;
                    } else if (BOARD[x0][y0].unhighlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                        break;
                }
                break;
            case NE:
                while (move <= max && !isBorder(x0 + 1, y0 - 1)) {
                    y0--;
                    x0++;
                    move++;
                    if (!unhighlight_flag) {
                        if (BOARD[x0][y0].highlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                            break;
                    } else if (BOARD[x0][y0].unhighlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                        break;
                }
                break;
            case NW:
                while (move <= max && !isBorder(x0 - 1, y0 - 1)) {
                    y0--;
                    x0--;
                    move++;
                    if (!unhighlight_flag) {
                        if (BOARD[x0][y0].highlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                            break;
                    } else if (BOARD[x0][y0].unhighlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                        break;
                }
                break;
            case SE:
                while (move <= max && !isBorder(x0 + 1, y0 + 1)) {
                    y0++;
                    x0++;
                    move++;
                    if (!unhighlight_flag) {
                        if (BOARD[x0][y0].highlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                            move = max + 1;
                    } else if (BOARD[x0][y0].unhighlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                        move = max + 1;
                }
                break;
            case SW:
                while (move <= max && !isBorder(x0 - 1, y0 + 1)) {
                    y0++;
                    x0--;
                    move++;
                    if (!unhighlight_flag) {
                        if (BOARD[x0][y0].highlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                            move = max + 1;
                    } else if (BOARD[x0][y0].unhighlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                        move = max + 1;
                }
                break;
            case E:
                while (move <= max && !isBorder(x0 + 1, y0)) {
                    x0++;
                    move++;
                    if (!unhighlight_flag) {
                        if (BOARD[x0][y0].highlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                            break;
                    } else if (BOARD[x0][y0].unhighlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                        break;
                }
                break;
            case W:
                while (move <= max && !isBorder(x0 - 1, y0)) {
                    x0--;
                    move++;
                    if (!unhighlight_flag) {
                        if (BOARD[x0][y0].highlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                            break;
                    } else if (BOARD[x0][y0].unhighlight(toBoard(shipElement.getCurrentX()), toBoard(shipElement.getCurrentY())))
                        break;
                }
                break;
        }
    }

    void moveInAllDirections(ShipElement looserShip, boolean flag) {
        Directions[] directions = new Directions[]{Directions.N, Directions.NE, Directions.E, Directions.SE, Directions.S, Directions.SW, Directions.W, Directions.NW};
        for (Directions d : directions) {
            highlightDirection(looserShip, d, flag);
        }

    }


    ShipElement getLoserShip() {
        return null;
    }

    protected void setLoserShip(ShipElement shipElement) {
    }

    public boolean isPort() {
        return false;
    }
}