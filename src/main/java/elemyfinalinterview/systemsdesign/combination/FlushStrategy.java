package elemyfinalinterview.systemsdesign.combination;

import elemyfinalinterview.systemsdesign.domain.Card;
import elemyfinalinterview.systemsdesign.domain.Hand;

class FlushStrategy implements CombinationStrategy {

    @Override
    public boolean isValidCombination(Hand hand) {

        final var handSize = hand.getCards().size();

        if (handSize == 0) return false;

        final var symbol = hand.getCards().get(0).getSymbol();

        return hand.getCards()
                .stream()
                .map(Card::getSymbol)
                .allMatch(i -> i.equalsIgnoreCase(symbol));
    }

    @Override
    public String getCombinationName() {
        return "Flush";
    }
}
