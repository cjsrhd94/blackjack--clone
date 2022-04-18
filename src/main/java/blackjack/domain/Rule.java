package blackjack.domain;

import java.util.List;

public class Rule {
    public Gamer getWinner(List<Gamer> gamers) {
        Gamer highestGamer = null;
        int highestPoint = 0;

        for (Gamer gamer : gamers) {
            int gamerPointSum = getPointSum(gamer.openCards());
            if (gamerPointSum > highestPoint) {
                highestGamer = gamer;
                highestPoint = gamerPointSum;
            }
        }
        return highestGamer;
    }

    private int getPointSum(List<Card> cards) {
        int sum = 0;

        for (Card card : cards) {
            sum += card.getDenomination().getPoint();
        }

        return sum;
    }
}
