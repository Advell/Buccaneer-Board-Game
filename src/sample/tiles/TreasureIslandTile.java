package sample.tiles;

import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;
import sample.GameManager;
import sample.ShipElement;

import static sample.BoardController.*;
import static sample.GameManager.treasureIsland;

public class TreasureIslandTile extends SeaTile {
    public TreasureIslandTile(int x, int y) {
        super(x, y);
        this.basic = false;
        //baseColor = Color.LIGHTGREEN;
        setFill(baseColor);
    }

    @Override
    public void whenClickedOn(int x, int y) {
        boolean occupied = hasShip();
        super.whenClickedOn(x, y);
        if (!occupied) {
            if (BATTLE) moveInAllDirections(shipElement, false);
            treasureIsland(shipElement);
        }
    }

    @Override
    boolean highlight(int x0, int y0) {
        boolean ret = super.highlight(x0, y0);
        if (hasShip()) {
            accessible = false;
            setFill(baseColor);
        }
        return ret;
    }

    @Override
    boolean unhighlight(int x0, int y0) {
        return super.unhighlight(x0, y0);
    }
}

