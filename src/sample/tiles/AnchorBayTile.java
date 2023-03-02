package sample.tiles;

import javafx.scene.paint.Color;

import javax.swing.*;

import static sample.BoardController.BOARD;
import static sample.BoardController.switchPlayers;


public class AnchorBayTile
        extends SeaTile {
    public AnchorBayTile(int x,int y) {
        super(x, y);
        this.basic=false;
    }
}