package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private List<Card> cards;

    public Dealer() {
        cards = new ArrayList<>();
    }

    public void drawCard(Card card) {
        this.cards.add(card);
    }

    public List<Card> openCards() {
        return null;
    }
}
