package blackjack.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    private static final int INIT_DRAW_CARD_COUNT = 2;
    private static final String STOP_DRAW_CARD = "0";

    public void play() {
        System.out.println("=====BlackJack=====");
        Scanner sc = new Scanner(System.in);

//        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();
        List<Gamer> gamers = Arrays.asList(new Player(), new Dealer());

        initPhase(cardDeck, gamers);
        playingPhase(sc, cardDeck, gamers);
    }

    private void initPhase(CardDeck cardDeck, List<Gamer> gamers) {
        System.out.println("2장의 카드를 뽑겠습니다.");
        for (int i = 0; i < INIT_DRAW_CARD_COUNT; i++) {
            for (Gamer gamer : gamers) {
                Card card = cardDeck.draw();
                gamer.drawCard(card);
            }
        }
    }

    private void playingPhase(Scanner sc, CardDeck cardDeck, List<Gamer> gamers) {
        while (true) {
            boolean isAllPlayerTurnOff = receiveCardAllPlayers(sc, cardDeck, gamers);

            if (isAllPlayerTurnOff) {
                break;
            }
        }
    }


    private boolean receiveCardAllPlayers(Scanner sc, CardDeck cardDeck, List<Gamer> gamers) {
        boolean isAllPlayerTurnOff = true;

        for (Gamer gamer : gamers) {
            if (isReceiveCard(sc)) {
                Card card = cardDeck.draw();
                gamer.drawCard(card);
                isAllPlayerTurnOff = false;
            } else {
                isAllPlayerTurnOff = true;
            }
        }
        return isAllPlayerTurnOff;
    }

    private boolean isReceiveCard(Scanner sc) {
        System.out.println("카드를 뽑으시겠습니까? 종료하시려면 0을 입력하세요.");
        return !STOP_DRAW_CARD.equals(sc.nextLine());
    }
}
