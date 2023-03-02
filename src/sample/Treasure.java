package sample;

public enum Treasure {
    GOLD("Gold", 4, 1),
    RUM("Rum", 2, 2),
    PEARL("Pearl", 3, 3),
    RUBY("Ruby", 5, 4),
    DIAMOND("Diamond", 5, 5);
    public final String label;
    public final int value;
    public final int index;

    private Treasure(String label, int value, int index) {
        this.label = label;
        this.index = index;
        this.value = value;
    }
    public String getLabel() {
        return this.label;
    }

    public int getValue() {
        return value;
    }
}
