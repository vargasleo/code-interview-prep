package elemyfinalinterview.systemsdesign.combination;

import elemyfinalinterview.systemsdesign.domain.Hand;

public interface CombinationStrategy {

    boolean isValidCombination(Hand hand);

    String getCombinationName();
}
