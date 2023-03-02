package sample;
import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.annotations.Expose;
import sample.CrewCard;
import sample.InGameColor;
import sample.Ship;
import sample.Treasure;

import static sample.GameManager.PLAYERS;
import static sample.GameManager.currentPlayer;
import static sample.CardManager.crewCardDeck;


public class Player {
    @Expose(serialize = true, deserialize = true)
    private Ship ship;

    @Expose(serialize = true, deserialize = true)
    private InGameColor Color;

    @Expose(serialize = true, deserialize = true)
    public String nickName;

    public Player() {
        this.ship = new Ship();
    }
    public ArrayList<CrewCard> currentCrewCards = new ArrayList<>(36);
    //private ArrayList<ChanceCards> currentChanceCards = new ArrayList<>();


    public Player(InGameColor ColorIn, Ship ShipIN, String nicknameIN) {
        this.Color = ColorIn;
        this.ship = ShipIN;
        this.nickName = nicknameIN;
    }

    public Ship getShip() {
        return ship;
    }
    public void addCrewCard(CrewCard cardIN) {
        currentCrewCards.add(cardIN);
    }

    public Ship getPlayersShip() {
        return ship;
    }
    public String getNickName(){
        return nickName;
    }


    public InGameColor getColor() {
        return Color;
    }

    public int getCrewScore(){
        int score = 0;
        for(CrewCard c : currentCrewCards){
            score += c.value;
        }
        return score;
    }

    public int getPirateScore() {
        int totalPower = 0;
        for (CrewCard c : currentCrewCards) {
            if (c.color == InGameColor.BLACK) {
                totalPower += c.value;
            } else {
                totalPower -= c.value;
            }
        }
        totalPower = Math.abs(totalPower);
        return totalPower;
    }
    public CrewCard getCrewCard(int position){
       return currentCrewCards.get(position);
    }

    public void removeLowestCrewCard(){
        int lowestCrewCard = this.currentCrewCards.indexOf(Collections.min(this.currentCrewCards));
        crewCardDeck.add(this.currentCrewCards.get(lowestCrewCard));
        this.currentCrewCards.remove(Collections.min(this.currentCrewCards));
    }

    public void loseTreasure(int x, int y){
        //currentPlayer.
    }

}















