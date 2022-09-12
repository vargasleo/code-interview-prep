package elemyfinalinterview.systemsdesign.combination;

import elemyfinalinterview.systemsdesign.domain.Card;
import elemyfinalinterview.systemsdesign.domain.Hand;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        final var strategies = List.of(new FlushStrategy(), new ThreeOfKindStrategy(), new TwoOfKindStrategy());

        final var service = new FindCombinationService(strategies);

        final var cards = List.of(
                new Card("H",1),
                new Card("H",2),
                new Card("H",3),
                new Card("C",4),
                new Card("H",1));

        final var hand = new Hand();
        hand.setCards(cards);

        System.out.println(service.findCombination(hand));
    }
}
