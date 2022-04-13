package blackjack;

import blackjack.domain.Card;
import blackjack.domain.CardDeck;
import blackjack.domain.Player;

public class BlackjackApplication {
	public static void main(String[] args) {
		CardDeck cardDeck = new CardDeck();
		System.out.println(cardDeck.toString());

		Player player = new Player();
		Card card = cardDeck.draw();
		player.drawCard(card);
	}
}
