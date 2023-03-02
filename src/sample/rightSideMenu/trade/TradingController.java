package sample.rightSideMenu.trade;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.CrewCard;
import sample.InGameColor;
import sample.Treasure;
import sample.ports.Port;
import sample.Player;

import java.util.ArrayList;

import static sample.CrewCard.*;
import static sample.CrewCard.CREW_BLACK_3;

public class TradingController {


    protected static int toLose;
    protected static int toGain;
    protected static int numOfItemsOnShip;
    protected static Player playerIN;
    protected static Port portIN;


    private ArrayList<Integer> indexPlayerTreasure = new ArrayList<>(5);
    private ArrayList<Integer> indexPlayerCrew = new ArrayList<>(6);
    private ArrayList<Integer> indexPortTreasure = new ArrayList<>(5);
    private ArrayList<Integer> indexPortCrew = new ArrayList<>(6);

    @FXML
    public Button lhsRed1Minus = new Button();
    public Button lhsRed1Plus = new Button();
    public Button lhsRed2Minus = new Button();
    public Button lhsRed2Plus = new Button();
    public Button lhsRed3Minus = new Button();
    public Button lhsRed3Plus = new Button();
    public Button lhsBlack1Minus = new Button();;
    public Button lhsBlack1Plus = new Button();;
    public Button lhsBlack2Minus = new Button();;
    public Button lhsBlack2Plus = new Button();;
    public Button lhsBlack3Minus = new Button();;
    public Button lhsBlack3Plus = new Button();;
    public Button lhsRumMinus = new Button();;
    public Button lhsRumPlus = new Button();;
    public Button lhsPearlMinus = new Button();;
    public Button lhsPearlPlus = new Button();;
    public Button lhsGoldMinus = new Button();;
    public Button lhsGoldPlus = new Button();;
    public Button lhsRubyMinus = new Button();;
    public Button lhsRubyPlus = new Button();;
    public Button lhsDiamondMinus = new Button();;
    public Button lhsDiamondPlus = new Button();;

    public Button complete;

    public Button rhsRed1Minus = new Button();
    public Button rhsRed1Plus = new Button();
    public Button rhsRed2Minus = new Button();
    public Button rhsRed2Plus = new Button();
    public Button rhsRed3Minus = new Button();
    public Button rhsRed3Plus = new Button();
    public Button rhsBlack1Minus = new Button();
    public Button rhsBlack1Plus = new Button();
    public Button rhsBlack2Minus = new Button();
    public Button rhsBlack2Plus = new Button();
    public Button rhsBlack3Minus = new Button();
    public Button rhsBlack3Plus = new Button();
    public Button rhsRumMinus = new Button();
    public Button rhsRumPlus = new Button();
    public Button rhsPearlMinus = new Button();
    public Button rhsPearlPlus = new Button();
    public Button rhsGoldMinus = new Button();
    public Button rhsGoldPlus = new Button();
    public Button rhsRubyMinus = new Button();
    public Button rhsRubyPlus = new Button();
    public Button rhsDiamondMinus = new Button();
    public Button rhsDiamondPlus = new Button();

    public Label red2port = new Label();
    public Label red1port = new Label();
    public Label totalPort = new Label();
    public Label red1Port = new Label();
    public Label red2Port = new Label();
    public Label red3port = new Label();
    public Label diamondPort = new Label();
    public Label black1port = new Label();
    public Label black2port = new Label();
    public Label black3port = new Label();
    public Label rumPort = new Label();
    public Label pearlPort = new Label();
    public Label goldPort = new Label();
    public Label rubyPort = new Label();
    public Label black2player = new Label();
    public Label black3player = new Label();
    public Label rumPlayer = new Label();
    public Label pearlPlayer = new Label();
    public Label goldPlayer = new Label();
    public Label rubyPlayer = new Label();
    public Label diamondPlayer = new Label();
    public Label totalPlayer = new Label();
    public Label red1player = new Label();
    public Label red2player = new Label();
    public Label red3player = new Label();
    public Label black1player = new Label();

    private int currentRumSelected;
    private int currentPearlSelected;
    private int currentGoldSelected;
    private int currentRubySelected;
    private int currrentDiamondSelected;
    private int currentR1Selected;
    private int currentR2Selected;
    private int currentR3Selected;
    private int currentB1Selected;
    private int currentB2Selected;
    private int currentB3Selected;

    private short portcurrentRumSelected;
    private short portcurrentPearlSelected;
    private short portcurrentGoldSelected;
    private short portcurrentRubySelected;
    private short portcurrrentDiamondSelected;
    private short portcurrentR1Selected;
    private short portcurrentR2Selected;
    private short portcurrentR3Selected;
    private short portcurrentB1Selected;
    private short portcurrentB2Selected;
    private short portcurrentB3Selected;


    protected ArrayList<Treasure> treasureToGain = new ArrayList<>();
    protected ArrayList<Treasure> treasureToLoose = new ArrayList<>();
    protected ArrayList<CrewCard> crewCardsToLoose = new ArrayList<>();
    protected ArrayList<CrewCard> crewCardsToGain = new ArrayList<>();

    /*public TradingController(Player currentPlayerIn, Port currentPortIn) {
        toGain = 0;
        toLoose = 0;

        //numOfItemsOnShip = currentPlayerIn.getShip().getAllShipInventory().size();

    }*/

    public void playerRumIncrease(){
        if(currentRumSelected<indexPlayerTreasure.get(0)){
        treasureToLoose.add(Treasure.RUM);
        toLose += Treasure.RUM.value;
        currentRumSelected++;
        rumPlayer.setText(Integer.toString(currentRumSelected));
        updateScore();
    }}

    public void playerRumDecrease() {
        if (currentRumSelected > 0) {
            treasureToLoose.remove(Treasure.RUM);
            toLose = toLose - 2;
            currentRumSelected--;
            rumPlayer.setText(Integer.toString(currentRumSelected));
            updateScore();
        }
    }

    public void playerPearlIncrease() {
        if(currentPearlSelected<indexPlayerTreasure.get(1)){
        treasureToLoose.add(Treasure.PEARL);
        currentPearlSelected++;
        pearlPlayer.setText(Integer.toString(currentPearlSelected));
        toLose = toLose + 3;
        updateScore();
    }}

    public void playerPearlDecrease() {
        if (currentPearlSelected > 0) {
            treasureToLoose.remove(Treasure.PEARL);
            currentPearlSelected--;
            pearlPlayer.setText(Integer.toString(currentPearlSelected));
            toLose = toLose - 3;
            updateScore();
        }
    }

    public void playerGoldIncrease() {
        if(currentGoldSelected<indexPlayerTreasure.get(2)){
        treasureToLoose.add(Treasure.GOLD);
        currentGoldSelected++;
        goldPlayer.setText(Integer.toString(currentGoldSelected));
        toLose = toLose + 4;
        updateScore();
    }}

    public void playerGoldDecrease() {
        if (currentGoldSelected > 0) {
            treasureToLoose.remove(Treasure.GOLD);
            currentGoldSelected--;
            goldPlayer.setText(Integer.toString(currentGoldSelected));
            toLose = toLose - 4;
            updateScore();
        }
    }

    public void playerRubyIncrease() {
        if(currentRubySelected<indexPlayerTreasure.get(3)){
        treasureToLoose.add(Treasure.RUBY);
        currentRubySelected++;
        rubyPlayer.setText(Integer.toString(currentRubySelected));
        toLose = toLose + 5;
        updateScore();
    }}

    public void playerRubyDecrease() {
        if (currentRubySelected > 0) {
            treasureToLoose.remove(Treasure.RUBY);
            currentRubySelected--;
            rubyPlayer.setText(Integer.toString(currentRubySelected));
            toLose = toLose - 5;
            updateScore();
        }
    }

    public void playerDiamondIncrease() {
        if(currrentDiamondSelected<indexPlayerTreasure.get(4)){
        treasureToLoose.add(Treasure.DIAMOND);
        currrentDiamondSelected++;
        diamondPlayer.setText(Integer.toString(currrentDiamondSelected));
        toLose = toLose + 5;
        updateScore();
    }}

    public void playerDiamondDecrease() {
        if (currrentDiamondSelected > 0) {
            treasureToLoose.remove(Treasure.DIAMOND);
            currrentDiamondSelected--;
            diamondPlayer.setText(Integer.toString(currrentDiamondSelected));
            toLose = toLose - 5;
            updateScore();
        }
    }

    public void playerRed1Increase() {
        if(currentR1Selected<indexPlayerCrew.get(0)){
        crewCardsToLoose.add(CREW_RED_1);
        currentR1Selected++;
        red1player.setText(Integer.toString(currentR1Selected));
        toLose = toLose + 1;
        updateScore();
    }}

    public void playerRed1Decrease() {
        if (currentR1Selected > 0) {
            crewCardsToLoose.remove(CREW_RED_1);
            currentR1Selected--;
            red1player.setText(Integer.toString(currentR1Selected));
            toLose = toLose - 1;
            updateScore();
        }
    }

    public void playerRed2Increase() {
        if(currentR2Selected<indexPlayerCrew.get(1)){
        crewCardsToLoose.add(CREW_RED_2);
        currentR2Selected++;
        red2player.setText(Integer.toString(currentR2Selected));
        toLose = toLose + 2;
        updateScore();
    }}

    public void playerRed2Decrease() {
        if (currentR2Selected > 0) {
            crewCardsToLoose.remove(CREW_RED_2);
            currentR2Selected--;
            red2player.setText(Integer.toString(currentR2Selected));
            toLose = toLose - 2;
            updateScore();
        }
    }

    public void playerRed3Increase() {
        if(currentR2Selected<indexPlayerCrew.get(3)){
        crewCardsToLoose.add(CREW_RED_3);
        currentR3Selected++;
        red3player.setText(Integer.toString(currentR3Selected));
        toLose = toLose + 3;
        updateScore();

    }}

    public void playerRed3Decrease() {
        if (currentR3Selected > 0) {
            crewCardsToLoose.remove(CREW_RED_3);
            currentR3Selected--;
            red3player.setText(Integer.toString(currentR3Selected));
            toLose = toLose - 3;
            updateScore();
        }
    }

    public void playerBlack1Increase() {
        if(currentB1Selected<indexPlayerCrew.get(3)) {
            crewCardsToLoose.add(CREW_BLACK_1);
            currentB1Selected++;
            black1player.setText(Integer.toString(currentB1Selected));
            toLose = toLose + 1;
            updateScore();
        }
    }

    public void playerBlack1Decrease() {
        if (currentB1Selected > 0) {
            crewCardsToLoose.remove(CREW_BLACK_1);
            currentB1Selected--;
            black1player.setText(Integer.toString(currentB1Selected));
            toLose = toLose - 1;
            updateScore();
        }
    }

    public void playerBlack2Increase() {
        if(currentB2Selected<indexPlayerCrew.get(4)){
        crewCardsToLoose.add(CREW_BLACK_2);
        currentB2Selected++;
        black2player.setText(Integer.toString(currentB2Selected));
        toLose = toLose + 2;
        updateScore();
    }}

    public void playerBlack2Decrease() {
        if (currentB2Selected > 0) {
            crewCardsToLoose.remove(CREW_BLACK_2);
            currentB2Selected--;
            black2player.setText(Integer.toString(currentB2Selected));
            toLose = toLose - 2;
            updateScore();
        }
    }

    public void playerBlack3Increase() {
        if(currentB3Selected<indexPlayerCrew.get(5)){
        crewCardsToLoose.add(CREW_BLACK_3);
        currentB3Selected++;
        black3player.setText(Integer.toString(currentB3Selected));
        toLose = toLose + 3;
        updateScore();
    }}

    public void playerBlack3Decrease() {
        if (currentB3Selected > 0) {
            crewCardsToLoose.remove(CREW_BLACK_3);
            currentB3Selected--;
            black3player.setText(Integer.toString(currentB3Selected));
            toLose = toLose - 3;
            updateScore();
        }
    }

    public void portRumIncrease() {
        if(portcurrentRumSelected<indexPlayerTreasure.get(0)){
        treasureToGain.add(Treasure.RUM);
        portcurrentRumSelected++;
        rumPort.setText(Integer.toString(portcurrentRumSelected));
        toGain = toGain + 2;
        updateScore();
    }}

    public void portRumDecrease() {
        if (portcurrentRumSelected > 0) {
            treasureToGain.remove(Treasure.RUM);
            portcurrentRumSelected--;
            rumPort.setText(Integer.toString(portcurrentRumSelected));
            toGain = toGain - 2;
            updateScore();
        }
    }

    public void portPearlIncrease() {
        if(portcurrentPearlSelected<indexPlayerTreasure.get(1)){
        treasureToGain.add(Treasure.PEARL);
        portcurrentPearlSelected++;
        pearlPort.setText(Integer.toString(portcurrentPearlSelected));
        toGain = toGain + 3;
        updateScore();
    }}

    public void portPearlDecrease() {
        if (portcurrentPearlSelected > 0) {
            treasureToGain.remove(Treasure.PEARL);
            portcurrentPearlSelected--;
            pearlPort.setText(Integer.toString(portcurrentPearlSelected));
            toGain = toGain - 3;
            updateScore();
        }
    }

    public void portGoldIncrease() {
        if(portcurrentGoldSelected<indexPlayerTreasure.get(2)){
        treasureToGain.add(Treasure.GOLD);
        portcurrentGoldSelected++;
        goldPort.setText(Integer.toString(portcurrentGoldSelected));
        toGain = toGain + 4;
        updateScore();
    }}

    public void portGoldDecrease() {
        if (portcurrentGoldSelected > 0) {
            treasureToGain.remove(Treasure.GOLD);
            portcurrentGoldSelected--;
            goldPort.setText(Integer.toString(portcurrentGoldSelected));
            toGain = toGain - 4;
            updateScore();
        }
    }

    public void portRubyIncrease() {
        if(portcurrentRubySelected<indexPlayerTreasure.get(3)){
        treasureToGain.add(Treasure.RUBY);
        portcurrentRubySelected++;
        rubyPort.setText(Integer.toString(portcurrentRubySelected));
        toGain = toGain + 5;
        updateScore();

    }}

    public void portRubyDecrease() {
        if (portcurrentRubySelected > 0) {
            treasureToGain.remove(Treasure.RUBY);
            portcurrentRubySelected--;
            rubyPort.setText(Integer.toString(portcurrentRubySelected));
            toGain = toGain - 5;
            updateScore();
        }
    }

    public void portDiamondIncrease() {
        if(portcurrrentDiamondSelected<indexPlayerTreasure.get(4)){
        treasureToGain.add(Treasure.DIAMOND);
        portcurrrentDiamondSelected++;
        diamondPort.setText(Integer.toString(portcurrrentDiamondSelected));
        toGain = toGain + 5;
        updateScore();
    }}

    public void portDiamondDecrease() {
        if (portcurrrentDiamondSelected > 0) {
            treasureToGain.remove(Treasure.DIAMOND);
            portcurrrentDiamondSelected--;
            diamondPort.setText(Integer.toString(portcurrrentDiamondSelected));
            toGain = toGain - 5;
            updateScore();
        }
    }

    public void portRed1Increase() {
        if(portcurrentR1Selected<indexPlayerCrew.get(0)){
        crewCardsToGain.add(CREW_RED_1);
        portcurrentR1Selected++;
        red1Port.setText(Integer.toString(portcurrentR1Selected));
        toGain = toGain + 1;
        updateScore();
    }}

    public void portRed1Decrease() {

        if (portcurrentR1Selected > 0) {
            crewCardsToGain.remove(CREW_RED_1);
            portcurrentR1Selected--;
            red1Port.setText(Integer.toString(portcurrentR1Selected));
            toGain = toGain - 1;
            updateScore();
        }
    }

    public void portRed2Increase() {
        if(portcurrentR2Selected<indexPlayerCrew.get(1)){
        crewCardsToGain.add(CREW_RED_2);
        portcurrentR2Selected++;
        red2Port.setText(Integer.toString(portcurrentR2Selected));
        toGain = toGain + 2;
        updateScore();
    }
    }

    public void portRed2Decrease() {
        if (portcurrentR2Selected > 0) {
            crewCardsToGain.remove(CREW_RED_2);
            portcurrentR2Selected--;
            red2Port.setText(Integer.toString(portcurrentR2Selected));
            toGain = toGain - 2;
            updateScore();
        }
    }

    public void portRed3Increase() {
        if(portcurrentR3Selected<indexPlayerCrew.get(2)){
        crewCardsToGain.add(CREW_RED_3);
        portcurrentR3Selected++;
        red3port.setText(Integer.toString(portcurrentR3Selected));
        toGain = toGain + 3;
        updateScore();
    }}

    public void portRed3Decrease() {
        if (portcurrentR3Selected > 0) {
            crewCardsToGain.remove(CREW_RED_3);
            portcurrentR3Selected--;
            red3port.setText(Integer.toString(portcurrentR3Selected));
            toGain = toGain - 3;
            updateScore();
        }
    }

    public void portBlack1Increase() {
        if(portcurrentB1Selected<indexPlayerCrew.get(4)){
        crewCardsToGain.add(CREW_BLACK_1);
        portcurrentB1Selected++;
        black1port.setText(Integer.toString(portcurrentB1Selected));
        toGain = toGain + 1;
        updateScore();
    }}

    public void portBlack1Decrease() {
        if (portcurrentB1Selected > 0) {
            crewCardsToGain.remove(CREW_BLACK_1);
            portcurrentB1Selected--;
            toGain = toGain-1;
            black1port.setText(Integer.toString(portcurrentB1Selected));

            updateScore();
        }
    }

    public void portBlack2Increase() {
        if(portcurrentR2Selected<indexPlayerCrew.get(4)){
        crewCardsToGain.add(CREW_BLACK_2);
        portcurrentB2Selected++;
        black2port.setText(Integer.toString(portcurrentB2Selected));
        toGain = toGain + 2;
        updateScore();
    }}

    public void portBlack2Decrease() {
        if (portcurrentB2Selected > 0) {
            crewCardsToGain.remove(CREW_BLACK_2);
            portcurrentB2Selected--;
            black2port.setText(Integer.toString(portcurrentB2Selected));
            toGain = toGain - 2;
            updateScore();
        }
    }

    public void portBlack3Increase() {
        if(portcurrentR1Selected<indexPlayerCrew.get(5)){
        crewCardsToGain.add(CREW_BLACK_3);
        portcurrentB3Selected++;
        black3port.setText(Integer.toString(portcurrentB3Selected));
        toGain = toGain + 3;
        updateScore();
    }}

    public void portBlack3Decrease() {
        if (portcurrentB3Selected > 0) {
            crewCardsToGain.remove(CREW_BLACK_3);
            portcurrentB3Selected--;
            black3port.setText(Integer.toString(portcurrentB3Selected));
            toGain = toGain - 3;
            updateScore();
        }
    }

    private void updateScore() {

        totalPlayer.setText(Integer.toString(toLose));
        totalPort.setText(Integer.toString(toGain));
    }

    private void refreshScene() {

        lhsRed1Minus.setVisible(false);
        lhsRed1Plus.setVisible(false);
        lhsRed2Minus.setVisible(false);
        lhsRed2Plus.setVisible(false);
        lhsRed3Minus.setVisible(false);
        lhsRed3Plus.setVisible(false);
        lhsBlack1Minus.setVisible(false);
        lhsBlack1Plus.setVisible(false);
        lhsBlack2Minus.setVisible(false);
        lhsBlack2Plus.setVisible(false);
        lhsBlack3Minus.setVisible(false);
        lhsBlack3Plus.setVisible(false);
        lhsRumMinus.setVisible(false);
        lhsRumPlus.setVisible(false);
        lhsPearlMinus.setVisible(false);
        lhsPearlPlus.setVisible(false);
        lhsGoldMinus.setVisible(false);
        lhsGoldPlus.setVisible(false);
        lhsRubyMinus.setVisible(false);
        lhsRubyPlus.setVisible(false);
        lhsDiamondMinus.setVisible(false);
        lhsDiamondPlus.setVisible(false);


        rhsRed1Minus.setVisible(false);
        rhsRed1Plus.setVisible(false);
        rhsRed2Minus.setVisible(false);
        rhsRed2Plus.setVisible(false);
        rhsRed3Minus.setVisible(false);
        rhsRed3Plus.setVisible(false);
        rhsBlack1Minus.setVisible(false);
        rhsBlack1Plus.setVisible(false);
        rhsBlack2Minus.setVisible(false);
        rhsBlack2Plus.setVisible(false);
        rhsBlack3Minus.setVisible(false);
        rhsBlack3Plus.setVisible(false);
        rhsRumMinus.setVisible(false);
        rhsRumPlus.setVisible(false);
        rhsPearlMinus.setVisible(false);
        rhsPearlPlus.setVisible(false);
        rhsGoldMinus.setVisible(false);
        rhsGoldPlus.setVisible(false);
        rhsRubyMinus.setVisible(false);
        rhsDiamondMinus.setVisible(false);
        rhsDiamondPlus.setVisible(false);

        red2port.setVisible(false);
        red1port.setVisible(false);
        totalPort.setVisible(false);
        red1Port.setVisible(false);
        red2Port.setVisible(false);
        red3port.setVisible(false);
        diamondPort.setVisible(false);
        black1port.setVisible(false);
        black2port.setVisible(false);
        black3port.setVisible(false);
        rumPort.setVisible(false);
        pearlPort.setVisible(false);
        goldPort.setVisible(false);
        rubyPort.setVisible(false);
        black2player.setVisible(false);
        black3player.setVisible(false);
        rumPlayer.setVisible(false);
        pearlPlayer.setVisible(false);
        goldPlayer.setVisible(false);
        rubyPlayer.setVisible(false);
        diamondPlayer.setVisible(false);
        totalPlayer.setVisible(false);
        red1player.setVisible(false);
        red2player.setVisible(false);
        red3player.setVisible(false);
        black1player.setVisible(false);
    }

    public void confirm(){
/*
        if(toGain==toLose){
            for(int i=0;i<playerIN.getShip().getAllShipInventory().size();i++){

            }
            crewCardsToGain;
            crewCardsToLoose;
            treasureToGain;
            treasureToLoose;

        }*/
    }



    public void startTrading() {
        System.out.println("START TRADING");

        /*if(ship inventory equals some treasure value){
        if(players treasure at some index is equal to
    }*/

        refreshScene();
        for (int i = 0; i < 2; i++) {
            if (playerIN.getPlayersShip().getShipInventory(i).equals(Treasure.RUM)) {
                if (indexPlayerTreasure.get(1) == currentRumSelected && (currentRumSelected != 0)) {
                    lhsRumPlus.setVisible(false);
                } else {

                    lhsRumMinus.setVisible(true);
                    rumPlayer.setVisible(true);
                    indexPlayerTreasure.set(1, indexPlayerTreasure.get(1) + 1);

                }
            }
            if (playerIN.getPlayersShip().getShipInventory(i).equals(Treasure.PEARL)) {
                if (indexPlayerTreasure.get(2) == currentPearlSelected && (currentPearlSelected != 0)) {
                    lhsPearlPlus.setVisible(false);
                } else {
                    lhsPearlPlus.setVisible(true);
                    lhsPearlMinus.setVisible(true);
                    pearlPlayer.setVisible(true);
                    indexPlayerTreasure.set(2, indexPlayerTreasure.get(2) + 1);
                }
            }
            if (playerIN.getPlayersShip().getShipInventory(i).equals(Treasure.GOLD)) {
                if (indexPlayerTreasure.get(3) == currentGoldSelected && (currentGoldSelected != 0)) {
                    lhsGoldPlus.setVisible(false);
                } else {
                    lhsGoldPlus.setVisible(true);
                    lhsGoldMinus.setVisible(true);
                    goldPlayer.setVisible(true);
                    indexPlayerTreasure.set(3, indexPlayerTreasure.get(3) + 1);
                }
            }
            if (playerIN.getPlayersShip().getShipInventory(i).equals(Treasure.RUBY)) {
                if (indexPlayerTreasure.get(4) == currentRubySelected && (currentRubySelected != 0)) {

                    lhsRubyPlus.setVisible(false);
                } else {
                    lhsRubyPlus.setVisible(true);
                    lhsRubyMinus.setVisible(true);
                    rubyPlayer.setVisible(true);
                    indexPlayerTreasure.set(4, indexPlayerTreasure.get(4) + 1);
                }
            }
            if (playerIN.getPlayersShip().getShipInventory(i).equals(Treasure.DIAMOND)) {
                if (indexPlayerTreasure.get(5) == currrentDiamondSelected && (currrentDiamondSelected != 0)) {
                    lhsDiamondPlus.setVisible(false);
                } else {
                    lhsDiamondPlus.setVisible(true);
                    lhsDiamondMinus.setVisible(true);
                    diamondPlayer.setVisible(true);
                    indexPlayerTreasure.set(5, indexPlayerTreasure.get(5) + 1);
                }
            }
        }

        for (int j = 0; j < playerIN.currentCrewCards.size(); j++) {
            if (playerIN.getCrewCard(j).equals(CREW_RED_1)) {
                if (indexPlayerCrew.get(1) == currentR1Selected && (currentR1Selected != 0)) {
                    lhsRed1Plus.setVisible(false);
                } else {
                    lhsRed1Plus.setVisible(true);
                    lhsRed1Minus.setVisible(true);
                    red1player.setVisible(true);
                    indexPlayerTreasure.set(1, indexPlayerCrew.get(1) + 1);
                }
            }

            if (playerIN.getCrewCard(j).equals(CREW_RED_2)) {
                if (indexPlayerCrew.get(2) == currentR2Selected && (currentR2Selected != 0)) {
                    lhsRed2Plus.setVisible(false);
                } else {
                    lhsRed2Plus.setVisible(true);
                    lhsRed2Minus.setVisible(true);
                    red2player.setVisible(true);
                    indexPlayerTreasure.set(2, indexPlayerCrew.get(2) + 1);
                }
            }
            if (playerIN.getCrewCard(j).equals(CREW_RED_3)) {
                if (indexPlayerCrew.get(3) == currentR3Selected && (currentR3Selected != 0)) {
                    lhsRed3Plus.setVisible(false);
                } else {
                    lhsRed3Plus.setVisible(true);
                    lhsRed3Minus.setVisible(true);
                    red3player.setVisible(true);
                    indexPlayerTreasure.set(3, indexPlayerCrew.get(3) + 1);
                }
            }
            if (playerIN.getCrewCard(j).equals(CREW_BLACK_1)) {
                if (indexPlayerCrew.get(4) == currentB1Selected && (currentB1Selected != 0)) {
                    lhsBlack1Plus.setVisible(false);
                } else {
                    lhsBlack1Plus.setVisible(true);
                    lhsBlack1Minus.setVisible(true);
                    black1player.setVisible(true);
                    indexPlayerTreasure.set(4, indexPlayerCrew.get(4) + 1);
                }
            }
            if (playerIN.getCrewCard(j).equals(CREW_BLACK_2)) {
                if (indexPlayerCrew.get(5) == currentB2Selected && (currentB2Selected != 0)) {
                    lhsBlack2Plus.setVisible(false);
                } else {
                    lhsBlack2Plus.setVisible(true);
                    lhsBlack2Minus.setVisible(true);
                    black2player.setVisible(true);
                    indexPlayerTreasure.set(5, indexPlayerCrew.get(5) + 1);
                }
            }
            if (playerIN.getCrewCard(j).equals(CREW_BLACK_3)) {
                if (indexPlayerCrew.get(6) == currentB3Selected && (currentB3Selected != 0)) {
                    lhsGoldPlus.setVisible(false);
                } else {
                    lhsBlack3Plus.setVisible(true);
                    lhsBlack3Minus.setVisible(true);
                    black3player.setVisible(true);
                    indexPlayerTreasure.set(6, indexPlayerCrew.get(6) + 1);
                }
            }
        }

        for (int j = 0; j < portIN.getNonSafeInventory().size(); j++) {
            if (portIN.getNonSafe(j).equals(Treasure.RUM)) {
                if (indexPortTreasure.get(1) == portcurrentRumSelected && (portcurrentRumSelected != 0)) {
                    rhsRumPlus.setVisible(false);
                } else {
                    rhsRumPlus.setVisible(true);
                    rhsRumMinus.setVisible(true);
                    rumPort.setVisible(true);
                    indexPortTreasure.set(1, indexPortTreasure.get(1) + 1);
                }
            }
            if (portIN.getNonSafe(j).equals(Treasure.PEARL)) {
                if (indexPortTreasure.get(2) == portcurrentPearlSelected && (portcurrentPearlSelected != 0)) {
                    rhsPearlPlus.setVisible(false);
                } else {
                    rhsPearlPlus.setVisible(true);
                    rhsPearlMinus.setVisible(true);
                    pearlPort.setVisible(true);
                    indexPortTreasure.set(2, indexPortTreasure.get(2) + 1);
                }
            }
            if (portIN.getNonSafe(j).equals(Treasure.GOLD)) {
                if (indexPortTreasure.get(3) == portcurrentGoldSelected && (portcurrentGoldSelected != 0)) {
                    rhsGoldPlus.setVisible(false);
                } else {
                    rhsGoldPlus.setVisible(true);
                    rhsGoldMinus.setVisible(true);
                    goldPort.setVisible(true);
                    indexPortTreasure.set(3, indexPortTreasure.get(3) + 1);
                }
            }
            if (portIN.getNonSafe(j).equals(Treasure.RUBY)) {
                if (indexPortTreasure.get(4) == portcurrentRubySelected && (portcurrentRubySelected != 0)) {
                    rhsRubyPlus.setVisible(false);
                } else {
                    rhsRubyPlus.setVisible(true);
                    rhsRubyMinus.setVisible(true);
                    rubyPort.setVisible(true);
                    indexPortTreasure.set(4, indexPortTreasure.get(4) + 1);
                }
            }
            if (portIN.getNonSafe(j).equals(Treasure.DIAMOND)) {
                if (indexPortTreasure.get(5) == portcurrrentDiamondSelected && (portcurrrentDiamondSelected != 0)) {
                    rhsDiamondPlus.setVisible(false);
                } else {
                    rhsDiamondPlus.setVisible(true);
                    rhsDiamondMinus.setVisible(true);
                    diamondPort.setVisible(true);
                    indexPortTreasure.set(5, indexPortTreasure.get(5) + 1);
                }
            }
        }

        if (portIN.getColor().equals(InGameColor.BLACK)) {
            for (CrewCard c : portIN.getCrewCards()) {
                if (c.equals(CREW_RED_1)) {
                    if (indexPortCrew.get(1) == portcurrentR1Selected && (portcurrentR1Selected != 0)) {
                        rhsRed1Plus.setVisible(false);
                    } else {
                        rhsRed1Plus.setVisible(true);
                        rhsRed1Minus.setVisible(true);
                        red1port.setVisible(true);
                        indexPortCrew.set(1, indexPortCrew.get(1) + 1);
                    }
                }
                if (c.equals(CREW_RED_2)) {
                    if (indexPortCrew.get(2) == portcurrentR2Selected && (portcurrentR2Selected != 0)) {
                        rhsRed2Plus.setVisible(false);
                    } else {
                        rhsRed2Plus.setVisible(true);
                        rhsRed2Minus.setVisible(true);
                        red2port.setVisible(true);
                        indexPortCrew.set(2, indexPortCrew.get(2) + 1);
                    }
                }
                if (c.equals(CREW_RED_3)) {
                    if (indexPortCrew.get(3) == portcurrentR3Selected && (portcurrentR3Selected != 0)) {
                        rhsRed3Plus.setVisible(false);
                    } else {
                        rhsRed3Plus.setVisible(true);
                        rhsRed3Minus.setVisible(true);
                        red3port.setVisible(true);
                        indexPortCrew.set(3, indexPortCrew.get(3) + 1);
                    }
                }
                if (c.equals(CREW_BLACK_1)) {
                    if (indexPortCrew.get(4) == portcurrentB1Selected && (portcurrentB1Selected != 0)) {
                        rhsBlack1Plus.setVisible(false);
                    } else {
                        rhsBlack1Plus.setVisible(true);
                        rhsBlack1Minus.setVisible(true);
                        black1port.setVisible(true);
                        indexPortCrew.set(4, indexPortCrew.get(4) + 1);
                    }
                }

                if (c.equals(CREW_BLACK_2)) {
                    if (indexPortCrew.get(5) == portcurrentB2Selected && (portcurrentB2Selected != 0)) {
                        rhsBlack2Plus.setVisible(false);
                    } else {
                        rhsBlack2Plus.setVisible(true);
                        rhsBlack2Minus.setVisible(true);
                        black2port.setVisible(true);
                        indexPortCrew.set(5, indexPortCrew.get(5) + 1);
                    }
                }

                if (c.equals(CREW_BLACK_3)) {
                    if (indexPortCrew.get(6) == portcurrentB3Selected && (portcurrentB3Selected != 0)) {
                        rhsBlack3Plus.setVisible(false);
                    } else {
                        rhsBlack3Plus.setVisible(true);
                        rhsBlack3Minus.setVisible(true);
                        black3port.setVisible(true);
                        indexPortCrew.set(6, indexPortCrew.get(6) + 1);
                    }
                }

            }
        }


        complete.setVisible(true);
        totalPlayer.setVisible(true);
        totalPort.setVisible(true);

        playerIN.getPlayersShip().getShipInventory(2);
        selector();
    }

    private void selector() {

    }

    public void addTreasureToGain(Treasure treasureToGainIN) {
        toGain++;
        treasureToGain.add(treasureToGainIN);
    }

    public void addTreasureToLoose(Treasure treasureToLooseIN) {
        toLose++;
        treasureToLoose.add(treasureToLooseIN);
    }

    public void addCrewToGain(CrewCard crewCardToGainIN) {
        toGain++;

    }

    public void addCrewToLoose(CrewCard crewCardToLooseIN) {
        toLose++;
    }

    public void removeItemsFromSide(){

    }


    public void initializeVariable(Player player, Port port) {
        playerIN = player;
        portIN = port;
        startTrading();
    }
    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Player playerIN= currentPlayer;
        Port portIN = null;

    }*/
}
