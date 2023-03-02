package sample;

public enum CrewCard {
    CREW_BLACK_1(InGameColor.BLACK, 1),
    CREW_BLACK_2(InGameColor.BLACK, 2),
    CREW_BLACK_3(InGameColor.BLACK, 3),
    CREW_RED_1(InGameColor.RED, 1),
    CREW_RED_2(InGameColor.RED, 2),
    CREW_RED_3(InGameColor.RED, 3);
    public final InGameColor color;
    public final int value;

    private CrewCard(InGameColor colorIN, int value) {
        this.color = colorIN;
        this.value = value;
    }
}
