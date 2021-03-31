package no.ntnu.card;

import java.util.List;

public class Main {
    public static void main(String []args) {
        DeckOfCards d1 = new DeckOfCards();
        System.out.println(d1.getCards());
        d1.shuffleDeck();
        System.out.println(d1);
        d1.shuffleDeck();
        System.out.println(d1);
        d1.burnCard();
        System.out.println(d1.getCards().size());
        d1.burnCard();
        System.out.println(d1.getCards().size());
        List<PlayingCard> p1 = d1.dealFlop();
        System.out.println(p1);
        System.out.println(d1);
        for(PlayingCard playingCard: p1) {
            System.out.println(d1.getCards().contains(playingCard));
        }
    }
}
