package blackjack.domain;

public class Card {
    private Suit suit;
    private Denomination denomination;

    public Card(Suit suit, Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", denomination=" + denomination +
                '}';
    }

    public Suit getSuit() {
        return suit;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public enum Suit {
        SPADE, HEART, DIAMOND, CLUB;

        Suit() {
        }
    }

    public enum Denomination {
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10);

        private int point;

        Denomination(int point) {
            this.point = point;
        }

        public int getPoint() {
            return this.point;
        }
    }
}

