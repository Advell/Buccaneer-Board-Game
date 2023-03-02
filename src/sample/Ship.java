package sample;

import com.google.gson.annotations.Expose;

import java.io.InputStream;
import java.util.ArrayList;

public class Ship {
    @Expose(serialize = true, deserialize = true)
    private ShipElement shipElement;

    @Expose(serialize = true, deserialize = true)
    public ArrayList<Treasure> inventory = new ArrayList<>(2);

    public Ship() {
        this.shipElement = null;
    }

    public void setShipElement(ShipElement shipElement) {
        this.shipElement = shipElement;
    }

    public ShipElement getShipElement() {
        return shipElement;
    }

    public ArrayList getAllShipInventory(){return inventory;}

    public Treasure getShipInventory(int position) {
        return inventory.get(position);
    }

    public void addTreasure(Treasure treasure){
        inventory.add(treasure);
    }

    public int getAmountOfTreasure() {
        return inventory.size();
    }

    public void clearInventory() {
        inventory.clear();
    }
}
