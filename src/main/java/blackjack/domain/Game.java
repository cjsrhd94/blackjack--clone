package blackjack.domain;

import java.util.Scanner;

public class Game {

    private static final int INIT_DRAW_CARD_COUNT = 2;

    public void play() {
        System.out.println("=====BlackJack=====");
        Scanner sc = new Scanner(System.in);

        Dealer dealer = new Dealer();
        Player player = new Player();
//        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();

        initPhase(cardDeck, player, dealer);
        playingPhase(sc, cardDeck, player, dealer);
    }

    private void initPhase(CardDeck cardDeck, Player player, Dealer dealer) {
        System.out.println("2장의 카드를 뽑겠습니다.");
        for (int i = 0; i < INIT_DRAW_CARD_COUNT; i++) {
            Card card = cardDeck.draw();
            player.drawCard(card);

            Card card2 = cardDeck.draw();
            dealer.drawCard(card2);
        }
    }

    private void playingPhase(Scanner sc, CardDeck cardDeck, Player player, Dealer dealer) {
        String gamerInput, dealerInput;
        boolean isPlayerTurn = false;
        boolean isDealerTurn = false;

        while (true) {
            System.out.println("카드를 뽑으시겠습니까? 종료하시려면 0을 입력하세요.");
            gamerInput = sc.nextLine();

            if ("0".equals(gamerInput)) {
                isPlayerTurn = true;
            } else {
                Card card = cardDeck.draw();
                player.drawCard(card);
            }

            System.out.println("카드를 뽑으시겠습니까? 종료하시려면 0을 입력하세요.");
            dealerInput = sc.nextLine();

            if ("0".equals(dealerInput)) {
                isDealerTurn = true;
            } else {
                Card card = cardDeck.draw();
                dealer.drawCard(card);
            }

            if (isPlayerTurn && isDealerTurn) {
                break;
            }
        }
    }
}
