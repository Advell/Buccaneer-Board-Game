package sample.ports;


import com.google.gson.annotations.Expose;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.CrewCard;
import sample.InGameColor;
import sample.Treasure;
import sample.rightSideMenu.trade.TradingController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static sample.GameManager.currentPlayer;
import static sample.GameManager.launchTradeWindow;

public class Port {
    @Expose(serialize = true, deserialize = true)
    String portName;

    @Expose(serialize = true, deserialize = true)
    InGameColor portColor;

    @Expose(serialize = true, deserialize = true)
    protected ArrayList<Treasure> safeInventory;

    @Expose(serialize = true, deserialize = true)
    protected ArrayList<Treasure> nonSafeInventory;

    @Expose(serialize = true, deserialize = true)
    protected ArrayList<CrewCard> crewCards;

    public Port(InGameColor color, String portName) {
        safeInventory = new ArrayList<>(20);
        nonSafeInventory = new ArrayList<>(20);
        portColor = color;
        this.portName = portName;
    }

    public String getPortName() {
        return portName;
    }

    public InGameColor getColor() {
        return portColor;
    }

    public void addTreasure(Treasure shipsTreasure) {
        nonSafeInventory.add(shipsTreasure);
        checkSafe();
    }

    public void checkSafe(){
        int countRum, countRuby, countDiamond, countGold, countPearl;
        countRum = Collections.frequency(nonSafeInventory, Treasure.RUM);
        countRuby = Collections.frequency(nonSafeInventory, Treasure.RUBY);
        countDiamond = Collections.frequency(nonSafeInventory, Treasure.DIAMOND);
        countGold = Collections.frequency(nonSafeInventory, Treasure.GOLD);
        countPearl = Collections.frequency(nonSafeInventory, Treasure.PEARL);

        if(countRum >= 3){
            for(int i = 0; i < 3; i++) {
                safeInventory.add(Treasure.RUM);
                nonSafeInventory.remove(Treasure.RUM);
            }
        }

        if(countRuby >= 3){
            for(int i = 0; i < 3; i++) {
                safeInventory.add(Treasure.RUBY);
                nonSafeInventory.remove(Treasure.RUBY);
            }
        }

        if(countDiamond >= 3){
            for(int i = 0; i < 3; i++) {
                safeInventory.add(Treasure.DIAMOND);
                nonSafeInventory.remove(Treasure.DIAMOND);
            }
        }

        if(countGold >= 3){
            for(int i = 0; i < 3; i++) {
                safeInventory.add(Treasure.GOLD);
                nonSafeInventory.remove(Treasure.GOLD);
            }
        }

        if(countPearl >= 3){
            for(int i = 0; i < 3; i++) {
                safeInventory.add(Treasure.PEARL);
                nonSafeInventory.remove(Treasure.PEARL);
            }
        }
    }

    public void checkVictory(){
        int totalTreasureValue = 0;
        for(Treasure t : nonSafeInventory){
            totalTreasureValue += t.value;
        }
        for(Treasure t : safeInventory){
            totalTreasureValue += t.value;
        }
        if(totalTreasureValue >= 5){
            System.out.println(currentPlayer.nickName + " has won the game");
            System.exit(0);
        }
    }

    public void addCrewCard(CrewCard genoaCard) {
    }

    public void playerArrive() {

        if(currentPlayer.getColor() == portColor){
            for(int i = 0; i < currentPlayer.getShip().getAllShipInventory().size(); i++){
                Treasure t = (Treasure) currentPlayer.getShip().getAllShipInventory().get(i);
                this.addTreasure(t);
            };
            checkSafe();
            checkVictory();
        }else{
            launchTradeWindow(this);
        }
    }

    protected void showTradingWindow() {

    }

    public ArrayList<CrewCard> getCrewCards() {
        return crewCards;
    }

    public Treasure getNonSafe(int option) {
        return nonSafeInventory.get(option);
    }
    public ArrayList<Treasure> getNonSafeInventory(){return nonSafeInventory;};

    public ArrayList<Treasure> getSafeInventory() {
        return safeInventory;
    }
}

