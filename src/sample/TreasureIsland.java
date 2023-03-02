package sample;

import java.util.ArrayList;

public class TreasureIsland {
    public static ArrayList<Treasure> TREASURE = new ArrayList<>(20);
    public TreasureIsland(){

    }

    public static Treasure takeTreasure(int desiredValue){
        for(Treasure t : TREASURE){
            if(t.value == desiredValue){
                Treasure treasure = TREASURE.get(t.index);
                TREASURE.remove(t.index);
                return t;
            }
        }
        return null;
    }

}
