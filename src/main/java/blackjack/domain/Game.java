package blackjack.domain;

import java.util.Scanner;

public class Game {
    public void play() {
        System.out.println("=====BlackJack=====");
        Scanner sc = new Scanner(System.in);

//        Dealer dealer = new Dealer();
        Player player = new Player();
//        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();

        initPhase(cardDeck, player);
        playingPhase(sc, cardDeck, player);
    }

    private static final int INIT_DRAW_CARD_COUNT = 2;
    private void initPhase(CardDeck cardDeck, Player player) {
        System.out.println("2장의 카드를 뽑겠습니다.");
        for (int i = 0; i < INIT_DRAW_CARD_COUNT; i++) {
            Card card = cardDeck.draw();
            player.drawCard(card);
        }
    }

    private void playingPhase(Scanner sc, CardDeck cardDeck, Player player) {
        String gamerInput;
        while (true) {
            System.out.println("카드를 뽑으시겠습니까? 종료하시려면 0을 입력하세요.");
            gamerInput = sc.nextLine();

            if ("0".equals(gamerInput)) {
                break;
            }

            Card card = cardDeck.draw();
            player.drawCard(card);
        }
    }
}
