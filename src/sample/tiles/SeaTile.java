package sample.tiles;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import sample.Player;
import sample.ShipElement;

import java.io.InputStream;

import static sample.BoardController.*;
import static sample.GameManager.triggerBattle;

public class SeaTile extends Tile {
    ShipElement loserShip;

    public SeaTile(int x, int y) {
        super(x, y);
        loserShip = null;
        baseColor = (x + y) % 2 == 0 ? Color.rgb(61, 181, 224, 0.6) : Color.rgb(41, 130, 196, 0.6);
        setFill(baseColor);
        basic = false;
    }

    @Override
    void whenHover(boolean show) {
        if (show) {
            if (accessible) {
                setFill(selected);
            }
        } else {
            if (accessible) setFill(highlighted);
            else {
                setFill(baseColor);
            }
        }
    }

    @Override
    void loadPictures() {
        try {
            InputStream selectedPic = this.getClass().getResourceAsStream("../resources/tileHighlightImages/SelectHighlight.png");
            InputStream highlightedPic = this.getClass().getResourceAsStream("../resources/tileHighlightImages/TheHighlightFinal.png");
            assert selectedPic != null;
            assert highlightedPic != null;
            selected = new ImagePattern(new Image(selectedPic));
            highlighted = new ImagePattern(new Image(highlightedPic));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void whenClickedOn(int x, int y) {
        if (accessible) {
            if (hasShip()) {
                BATTLE = true;
                ShipElement attackingShip = BOARD[x0][y0].getShip();
                moveInAllDirections(attackingShip, true);
                loserShip = triggerBattle(this.shipElement);
                if (BOARD[x0][y0].getLoserShip() != null) BOARD[x0][y0].setLoserShip(null);
                else BOARD[x0][y0].setShip(null);
                moveInAllDirections(loserShip, false);
                if (loserShip.equals(this.shipElement)) {
                    this.shipElement = attackingShip;
                    this.shipElement.move(x, y);
                    this.shipElement.changeSelected();
                }
                return;
            }
            if (BATTLE) {
                setShip(BOARD[x0][y0].getLoserShip());
                loserShip = null;
                moveInAllDirections(shipElement, true);
                BATTLE = false;
            } else {
                setShip(BOARD[x0][y0].getShip());
                unHighlightSpecifically();
                BOARD[x0][y0].setShip(null);
            }
            shipElement.move(x, y);
            shipElement.changeSelected();
            switchPlayers();
        }
    }


    @Override
    protected void unHighlightSpecifically() {
        moveInAllDirections(shipElement, true);
    }

    @Override
    public ShipElement getLoserShip() {
        ShipElement toBeReturned = loserShip;
        loserShip = null;
        return toBeReturned;
    }

    @Override
    boolean highlight(int x0, int y0) {
        boolean ret = super.highlight(x0, y0);
        if (hasShip() && BATTLE) {
            accessible = false;
            setFill(baseColor);
        }
        return ret;
    }

    @Override
    public void setLoserShip(ShipElement loserShip) {
        this.loserShip = loserShip;
    }
}
