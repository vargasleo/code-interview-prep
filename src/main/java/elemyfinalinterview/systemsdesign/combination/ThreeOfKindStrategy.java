package elemyfinalinterview.systemsdesign.combination;


import elemyfinalinterview.systemsdesign.domain.Hand;

class ThreeOfKindStrategy implements CombinationStrategy {

    private static final Integer COMBINATION_SIZE = 3;

    @Override
    public boolean isValidCombination(final Hand hand) {
        return NumberOfKindFunction.apply(hand, COMBINATION_SIZE);
    }

    @Override
    public String getCombinationName() {
        return "Three of a kind";
    }
}
