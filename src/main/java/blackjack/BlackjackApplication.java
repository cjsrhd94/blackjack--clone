package blackjack;

import blackjack.domain.CardDeck;

public class BlackjackApplication {
	public static void main(String[] args) {
		CardDeck cardDeck = new CardDeck();
		System.out.println(cardDeck.toString());
		System.out.println(cardDeck.draw());
		System.out.println(cardDeck.draw());
	}
}
