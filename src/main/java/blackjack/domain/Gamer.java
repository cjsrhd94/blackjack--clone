package blackjack.domain;

import java.util.List;

public interface Gamer {
    void drawCard(Card card);

    void showCards();

    List<Card> openCards();
}
