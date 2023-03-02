package sample.ChanceCards;
import sample.Player;

public class ChanceCardBlownAway extends ChanceCard{

    int x, y;

    public ChanceCardBlownAway(String _text, int _x, int _y){
        super(_text);
        x = _x;
        y = _y;
    }

    //@Override
    public void action(Player player){
        super.blowPlayerAway(player, x,y);
    }


}
