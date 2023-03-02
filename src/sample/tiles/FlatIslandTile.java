package sample.tiles;

import javafx.scene.paint.Color;

import static sample.BoardController.BOARD;
import static sample.BoardController.switchPlayers;
import static sample.GameManager.flatIsland;


public class FlatIslandTile
        extends SeaTile {
    public FlatIslandTile(int x, int y) {
        super(x, y);
        this.basic = false;
        setFill(baseColor);
    }

    @Override
    public void whenClickedOn(int x, int y) {
        super.whenClickedOn(x, y);
        if (hasShip()) flatIsland();
    }
}