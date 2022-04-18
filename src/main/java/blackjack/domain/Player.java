package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Player implements Gamer {
    private List<Card> cards;

    public Player() {
        cards = new ArrayList<>();
    }

    @Override
    public void drawCard(Card card) {
        this.cards.add(card);
        this.showCards();
    }

    @Override
    public void showCards() {
        StringBuilder sb = new StringBuilder();
        sb.append("현재 보유 카드 목록 \n");

        for (Card card : cards) {
            sb.append(card.toString());
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    @Override
    public List<Card> openCards(){
        return this.cards;
    }
}
