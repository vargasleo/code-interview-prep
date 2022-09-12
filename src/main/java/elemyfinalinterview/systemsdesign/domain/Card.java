package elemyfinalinterview.systemsdesign.domain;

public class Card {

    private final String symbol;

    public Card(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    private final int value;

    public int getValue() {
        return value;
    }
    public String getSymbol() {
        return symbol;
    }
}
