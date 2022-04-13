package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
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
        getShuffle();
    }

    private void getShuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("카드 목록 \n");

        for (Card card : cards) {
            sb.append(card.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    public Card draw() {
        Card selectedCard = cards.get(0);
        cards.remove(selectedCard);
        return selectedCard;
    }
}
