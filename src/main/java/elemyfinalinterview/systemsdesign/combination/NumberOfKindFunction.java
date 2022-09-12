package elemyfinalinterview.systemsdesign.combination;

import elemyfinalinterview.systemsdesign.domain.Card;
import elemyfinalinterview.systemsdesign.domain.Hand;

public class NumberOfKindFunction {

    public static Boolean apply(Hand hand, Integer combinationSize) {

        final var cards = hand.getCards();

        if (cards.size() == 0) return false;

        var maxCount = 0;
        var count = 0;

        Card curr;

        for (int i = 0; i < cards.size(); i++) {
            curr = cards.get(i);
            for (int j = i + 1; j <cards.size(); j++) {
                if (curr.getValue() == cards.get(j).getValue()) {
                    count++;
                }
            }
            maxCount = Math.max(count, maxCount);
            count = 0;
        }
        return maxCount == combinationSize;
    }
}
