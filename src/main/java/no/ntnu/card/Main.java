package no.ntnu.card;

import java.util.ArrayList;

public class Main {
    public static void main(String []args) {
//        DeckOfCards d1 = new DeckOfCards();
//        System.out.println(d1.getCards());
//        d1.shuffleDeck();
//        System.out.println(d1);
//        d1.shuffleDeck();
//        System.out.println(d1);
//        d1.burnCard();
//        System.out.println(d1.getCards().size());
//        d1.burnCard();
//        System.out.println(d1.getCards().size());
//        List<PlayingCard> p1 = d1.dealFlop();
//        System.out.println(p1);
//        System.out.println(d1);
//
//        for(PlayingCard playingCard: p1) {
//            System.out.println(d1.getCards().contains(playingCard));
//        }

        Player p1 = new Player("Oskar", "Eidem", 100);
        Player p2 = new Player("Per", "Ivar", 100);
        Player p3 = new Player("John", "Kenneth", 100);
        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);

        DeckOfCards deck = new DeckOfCards();
        GameTable game1 = new GameTable(players, deck, "Poker");

        System.out.println(game1.getDeck());
        System.out.println(game1.getPlayers());

        System.out.println(game1.getCommunityCards());

        game1.DealHandToPlayers(2);
        System.out.println(game1.getPlayers());
        game1.dealFlop();
        System.out.println(game1.getCommunityCards());
        System.out.println(game1.getDeck().getCards().size());

    }
}
