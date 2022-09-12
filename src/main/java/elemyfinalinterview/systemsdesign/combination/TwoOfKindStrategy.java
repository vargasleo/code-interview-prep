package elemyfinalinterview.systemsdesign.combination;

import elemyfinalinterview.systemsdesign.domain.Hand;

class TwoOfKindStrategy implements CombinationStrategy {

    private static final Integer COMBINATION_SIZE = 2;

    @Override
    public boolean isValidCombination(final Hand hand) {
        return NumberOfKindFunction.apply(hand, COMBINATION_SIZE);
    }

    @Override
    public String getCombinationName() {
        return "Two of a kind";
    }
}
