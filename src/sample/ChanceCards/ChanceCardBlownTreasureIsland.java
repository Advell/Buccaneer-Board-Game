package sample.ChanceCards;

import sample.Location;
import sample.Player;

public class ChanceCardBlownTreasureIsland extends ChanceCard{

        int x, y;

        public ChanceCardBlownTreasureIsland(String _text){
            super(_text);

        }

        //@Override
        public void action(Player player){

            int player_x, player_y;

            player_x = player.getPlayersShip().getShipElement().getBoardX();
            player_y = player.getPlayersShip().getShipElement().getBoardY();

            if(player_x == Location.TreasureIslandTop.x) {

                if(player_y == Location.TreasureIslandTop.y) {
                    x = player_x - 5;
                    y = player_y - 5;
                }//top left corner
                else if(player_y <= Location.TreasureIslandBottom.y) {
                    x = player_x - 5;
                    y = player_y + 5;
                }//bottom left corner
                else {
                    x = player_x - 5;
                    y = player_y;
                }//left side, not at a corner

            if(player_x == Location.TreasureIslandBottom.x){
                if(player_y == Location.TreasureIslandTop.y){

                }//top right corner
                else if(player_y == Location.TreasureIslandBottom.y){

                }//bottom right corner
                else{

                }//right side, not a corner

                if((player_x != Location.TreasureIslandTop.x) && (player_x != Location.TreasureIslandBottom.x)){
                    if(player_y == Location.TreasureIslandTop.y){

                    }//top side
                    else{

                    }//bottom side
                }
            }


            super.blowPlayerAway(player, x,y);
        }


    }
}
