package elemyfinalinterview.systemsdesign.combination;

import elemyfinalinterview.systemsdesign.domain.Hand;

import java.util.List;

public class FindCombinationService {

    private final List<CombinationStrategy> strategies;

    public FindCombinationService(List<CombinationStrategy> strategies) {
        this.strategies = strategies;
    }

    public String findCombination(Hand hand) {

        return strategies.stream()
                .filter(strategy -> strategy.isValidCombination(hand))
                .findFirst()
                .map(CombinationStrategy::getCombinationName)
                .orElse("None");
    }
}
