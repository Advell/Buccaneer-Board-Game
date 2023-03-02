package sample;

import java.util.ArrayList;

public class TradingPort {
    ArrayList<CrewCard> portCrew = new ArrayList<>();


    public CrewCard getCrewCard(int Position) {
        return portCrew.get(Position);
    }
}