package sample.ChanceCards;

import sample.Location;
import sample.ports.Port;
import sample.Player;

import static sample.GameManager.PORTS;

public class ChanceCardBlownAwayHomePort extends ChanceCard {

    int x, y;

    public ChanceCardBlownAwayHomePort(String _text) {
        super(_text);

    }

    //@Override
    public void action(Player player) {

        for (Port port : PORTS) {
            if (port.getColor() == player.getColor()) {
                switch (port.getColor()) {
                    case RED:
                        x = Location.London.x;
                        y = Location.London.y;
                        break;
                    case GREEN:
                        x = Location.Marseilles.x;
                        y = Location.Marseilles.y;
                        break;
                    case PURPLE:
                        x = Location.Venice.x;
                        y = Location.Venice.y;
                        break;
                    case YELLOW:
                        x = Location.Cadiz.x;
                        y = Location.Cadiz.y;
                        break;
                }
            }
        }

        super.blowPlayerAway(player, x, y);
    }


}