package sample;

import com.google.gson.annotations.Expose;
import sample.ChanceCards.*;
import sample.ports.Port;

import java.util.ArrayList;
import java.util.Collections;

import static sample.GameManager.exitDirectionSelection;
import static sample.GameManager.exitShipMoveMenu;

public class CardManager {

    @Expose(serialize = true, deserialize = true)
    public static ArrayList<CrewCard> crewCardDeck = new ArrayList<>(36);

    @Expose(serialize = true, deserialize = true)
    public static ArrayList<ChanceCard> chanceCardDeck = new ArrayList<>(24);

    public CardManager() {
        initializeChanceCards();
        initializeCrewCards();
    }

    public static void givePlayerCrewCard(Player player, CrewCard card) {
        player.addCrewCard(card);
    }

    public static void givePortCrewCard(Port port, CrewCard card) {
        port.addCrewCard(card);
    }

    public void returnCardToDeck(CrewCard c) {
        crewCardDeck.add(c);
    }

    public static CrewCard drawCrewCard() {
        CrewCard card = null;

        if (!(crewCardDeck.isEmpty())) {
            card = crewCardDeck.get(0);
            crewCardDeck.remove(0);
        }
        return card;
    }

    public static void drawChanceCard(Player _player) {
        ChanceCard card = null;
        Player player = _player;

        if (!(chanceCardDeck.isEmpty())) {
            card = chanceCardDeck.get(0); //Get top card
            //Display Pop up
            //card.text
            card.action(player); //Call what it needs to do
            chanceCardDeck.add(card); //Put to bottom
        }
    }

    private void initializeChanceCards() {
        /*chanceCardDeck.add(new ChanceCardBlownAway("You are blown to Mud Bay. If your crew total is 3 or less, take 4 crew cards from Pirate Island.",
                Location.MudBay.x, Location.MudBay.y)); //Chance card #3

        chanceCardDeck.add(new ChanceCardBlownAway("You are blown to Cliff Creek. If your crew total is 3 or less, take 4 crew cards from Pirate Island.",
                Location.CliffCreek.x, Location.CliffCreek.y)); //Chance card #4

        chanceCardDeck.add(new ChanceCardBlownAwayHomePort("You are blown to your Home Port. If your\n" +
                "crew total is 3 or less, take 4 crew cards\n" +
                "from Pirate Island.")); //Chance card #5

        chanceCardDeck.add(new ChanceCardBlownAway("You are blown to Amsterdam. If your crew \n" +
                "total is 3 or less, take 4 crew cards from Pirate Island.", Location.Amsterdam.x, Location.Amsterdam.y)); //Chance card #6

        chanceCardDeck.add(new ChanceCard("Your most valuable treasure on board or if\n" +
                "no treasure, the best crew card from your\n" +
                "hand is washed overboard to Flat Island."));*/

        chanceCardDeck.add(new ChanceCardTakeTreasureOrCrew("Get 3 treasure"));

        Collections.shuffle(chanceCardDeck);
    }

    private void initializeCrewCards() {

        for (int i = 1; i < 7; i++) {
            crewCardDeck.add(CrewCard.CREW_BLACK_1);
            crewCardDeck.add(CrewCard.CREW_BLACK_2);
            crewCardDeck.add(CrewCard.CREW_BLACK_3);
            crewCardDeck.add(CrewCard.CREW_RED_1);
            crewCardDeck.add(CrewCard.CREW_RED_2);
            crewCardDeck.add(CrewCard.CREW_RED_3);
        }

        Collections.shuffle(crewCardDeck);
    }


}
