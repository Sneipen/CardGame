package no.ntnu.card;

import java.util.stream.Collectors;

public class Main {
    public static void main(String []args) {
        DeckOfCards d1 = new DeckOfCards();

        d1.newHand(2);
        System.out.println(d1.getHand());
        System.out.println(d1.getBoard());
        d1.dealFlop();
        System.out.println(d1.getCommunityCards());
        System.out.println(d1.getBoard());
        System.out.println(d1.getHand());
        d1.dealTurnOrRiver();
        System.out.println(d1.getCommunityCards());
        System.out.println(d1.getBoard());
        String s = d1.getBoard().stream().filter(p -> p.getSuit() == 'H').map(PlayingCard::getAsString).map(r -> r + " ").collect(Collectors.joining());
        System.out.println(s);
        System.out.println(d1.queenOfSpades());
        System.out.println(d1.highCard());



    }
}
