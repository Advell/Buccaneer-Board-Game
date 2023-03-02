package sample.ChanceCards;

import sample.Directions;
import sample.Player;

public class ChanceCardBlownNearestPort extends ChanceCard{

    int x, y;

    public ChanceCardBlownNearestPort(String _text){
        super(_text);
    }

    //@Override
    public void action(Player player){

        Directions dir = player.getShip().getShipElement().getDirection();

        switch(dir){
            case N:
                break;
            case NE:
                break;
            case E:
                break;
            case SE:
                break;
            case S:
                break;
            case SW:
                break;
            case W:
                break;
            case NW:
                break;
        }

        //Decision made to just blow player to Amsterdam

        super.blowPlayerAway(player,x, y);
    }
}
