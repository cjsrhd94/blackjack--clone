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

        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();

        List<Gamer> gamers = Arrays.asList(new Player("사용자1"), new Dealer());
        List<Gamer> initAfterPlayers = initPhase(cardDeck, gamers);
        List<Gamer> playingAfterPlayers = playingPhase(sc, cardDeck, initAfterPlayers);

        Gamer winner = rule.getWinner(playingAfterPlayers);
        System.out.println("승자는 " + winner.getName() + "!");
    }

    private List<Gamer> initPhase(CardDeck cardDeck, List<Gamer> gamers) {
        System.out.println("2장의 카드를 뽑겠습니다.");
        for (int i = 0; i < INIT_DRAW_CARD_COUNT; i++) {
            for (Gamer gamer : gamers) {
                Card card = cardDeck.draw();
                gamer.drawCard(card);
            }
        }
        return gamers;
    }

    private List<Gamer> playingPhase(Scanner sc, CardDeck cardDeck, List<Gamer> gamers) {
        List<Gamer> cardDrawGamers;

        while (true) {
            cardDrawGamers = receiveCardAllPlayers(sc, cardDeck, gamers);

            if (isAllPlayerTurnOff(cardDrawGamers)) {
                break;
            }
        }
        return cardDrawGamers;
    }

    private boolean isAllPlayerTurnOff(List<Gamer> gamers) {
        for (Gamer gamer : gamers) {
            if(gamer.isTurn()) {
                return false;
            }
        }
        return true;
    }


    private List<Gamer> receiveCardAllPlayers(Scanner sc, CardDeck cardDeck, List<Gamer> gamers) {
        for (Gamer gamer : gamers) {
            System.out.println(gamer.getName() + "님 차례입니다.");

            if (isReceiveCard(sc)) {
                Card card = cardDeck.draw();
                gamer.drawCard(card);
                gamer.turnOn();
            } else {
                gamer.turnOff();
            }
        }
        return gamers;
    }

    private boolean isReceiveCard(Scanner sc) {
        System.out.println("카드를 뽑으시겠습니까? 종료하시려면 0을 입력하세요.");
        return !STOP_DRAW_CARD.equals(sc.nextLine());
    }
}
