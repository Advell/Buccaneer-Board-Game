package sample;

public class MoveResult {
    private final MoveType type;

    public MoveType getType() {
        return type;
    }

    private final ShipElement shipElement;

    public ShipElement getShip() {
        return shipElement;
    }

    public MoveResult(MoveType type) {
        this(type, null);
    }

    public MoveResult(MoveType type, ShipElement shipElement) {
        this.type = type;
        this.shipElement = shipElement;
    }
}
