package sample;

public enum Location {
    //Y VALUES ARE INVERTED FROM THE SPEC
    //

    //Ports
    Venice(1,14),
    London(1, 7),
    Cadiz(14,1),
    Marseilles(20,14),
    Amsterdam(20,7),
    Genoa(7,20),

    MudBay(20,20),
    AnchorBay(1,20),
    CliffCreek(1,1),
    FlatIslandTop(2,5),
    FlatIslandBottom(4,2),
    PirateIslandTop(17,19),
    PirateIslandBottom(19,16),
    TreasureIslandTop(9,9),
    TreasureIslandBottom(12,12);

    public final int x, y;

    private Location( int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }

}
