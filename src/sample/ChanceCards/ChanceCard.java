package sample.ChanceCards;

import sample.*;
import sample.Player;

import static sample.BoardController.BOARD;

public class ChanceCard {

    public String textOnCard;

    public ChanceCard( String _textOnCard){
        textOnCard = _textOnCard;
    }

    public void action(Player player){

    }

    public void blowPlayerAway(Player player, int _x, int _y){

        int crewTotalToCheck = 3;

        if(player.getCrewScore() <= crewTotalToCheck){
            CardManager.givePlayerCrewCard(player, CardManager.drawCrewCard());
            CardManager.givePlayerCrewCard(player, CardManager.drawCrewCard());
            CardManager.givePlayerCrewCard(player, CardManager.drawCrewCard());
        }

        ShipElement element = player.getPlayersShip().getShipElement();
        BOARD[element.getBoardX()][element.getBoardY()].setShip(null);
        BOARD[_x][_y].setShip(element);
        element.move(_x, _y);

    }

    public void loseItemToPlace(Player player, String flag, int x, int y){
        if(flag == "crew"){
            int highestValue = 0;
            for(CrewCard c : player.currentCrewCards){
                if(c.value > highestValue){
                    highestValue = c.value;
                }

            }
        }else if(flag == "treasure"){
            int highestValue = 0;
            for(Treasure t : player.getShip().inventory){
                if(t.value > highestValue){
                    highestValue = t.value;
                }
            }
        }
    }

    public void takeTreasure(){
        
    }


}
