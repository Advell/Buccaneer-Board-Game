package sample.tiles;

import javafx.scene.paint.Color;
import sample.InGameColor;
import sample.ports.Port;
import sample.ShipElement;

public class PortTile extends SeaTile {

    Port port;

    public PortTile(int x, int y, Port port) {
        super(x, y);
        basic = false;
        this.port = port;
        if (port.getColor().equals(InGameColor.RED)) {
            baseColor = Color.RED;
        }
        if (port.getColor().equals(InGameColor.PURPLE)) {
            baseColor = Color.PURPLE;
        }
        if (port.getColor() == InGameColor.GREEN) {
            baseColor = Color.GREEN;
        }
        if (port.getColor() == InGameColor.YELLOW) {
            baseColor = Color.YELLOW;
        }
        if (port.getColor() == InGameColor.BLACK) {
            baseColor = Color.BLACK;
        }
        setFill(baseColor);
    }

    @Override
    public void highlightMoves(ShipElement shipElement, boolean unhighlight_flag) {
        super.moveInAllDirections(shipElement, unhighlight_flag);
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
    public void whenClickedOn(int x, int y) {
        super.whenClickedOn(x, y);
        port.playerArrive();
    }


    @Override
    public boolean isPort() {
        return true;
    }
}
