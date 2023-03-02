package sample;

public enum Directions {
    NW(315),
    N(0),
    NE(45),
    E(90),
    SE(135),
    S(180),
    SW(225),
    W(270);
    public final int degree;

    private Directions(int degree) {
        this.degree = degree;
    }
}
