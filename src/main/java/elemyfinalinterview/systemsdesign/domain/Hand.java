package elemyfinalinterview.systemsdesign.domain;

import java.util.List;

public class Hand {

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    private List<Card> cards;
}
