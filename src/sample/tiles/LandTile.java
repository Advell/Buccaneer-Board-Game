package sample.tiles;

import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;
import sample.GameManager;

import static sample.BoardController.BOARD;
import static sample.BoardController.switchPlayers;

public class LandTile extends Tile {
    public LandTile(int x, int y) {
        super(x, y);
        this.basic=false;

        setFill(Color.TRANSPARENT);
    }

    @Override
    boolean highlight(int x0, int y0) {
        return true;
    }

    @Override
    boolean unhighlight(int x0, int y0) {
        return true;
    }
}


