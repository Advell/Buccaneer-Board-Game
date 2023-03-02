package sample.rightSideMenu.trade;

import sample.CrewCard;
import sample.Treasure;

public class TradingModel {



    protected static int toLoose;
    protected static int toGain;
    protected static int numOfItemsOnShip;


    public void addTreasureToGain(Treasure treasureToGainIN){
        toGain++;
        //treasureToGain.add(treasureToGainIN);
    }
    public void addTreasureToLoose(Treasure treasureToLooseIN){
        toLoose++;
        //treasuretoLoose.add(treasureToLooseIN);
    }
    public void addCrewToGain(CrewCard crewCardToGainIN){
        toGain++;

    }
    public void addCrewToLoose(CrewCard crewCardToLooseIN){
        toLoose++;
    }
}
