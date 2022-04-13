package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

import static blackjack.domain.Card.*;

public class CardDeck {
    private List<Card> cards;

    public CardDeck() {
        cards = new ArrayList<>();

        for(Suit suit : Suit.values()) {
            for (Denomination denomination : Denomination.values()) {
                Card card = new Card(suit, denomination);
                cards.add(card);
            }
        }
    }

    @Override
    public String toString() {
        return "CardDeck{" +
                "cards=" + cards +
                '}';
    }

    public Card draw() {
        return null;
    }
}
