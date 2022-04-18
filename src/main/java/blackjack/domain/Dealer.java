package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Dealer implements Gamer{
    private List<Card> cards;

    private static final int CAN_RECEIVE_POINT = 16;

    public Dealer() {
        cards = new ArrayList<>();
    }

    @Override
    public void drawCard(Card card) {
        if(this.isReceiveCard()) {
            this.cards.add(card);
            this.showCards();
        } else {
            System.out.println("카드의 총 합이 17이상입니다. 더이상 카드를 받을 수 없습니다.");
        }
    }

    private boolean isReceiveCard() {
        return getPointSum() <= CAN_RECEIVE_POINT;
    }

    private int getPointSum() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getDenomination().getPoint();
        }

        return sum;
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
    public List<Card> openCards() {
        return this.cards;
    }
}
