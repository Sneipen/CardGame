package no.ntnu.card;

import java.util.ArrayList;
import java.util.List;

public class GameTable {
    private final String game;
    private DeckOfCards deck;
    private List<PlayingCard> communityCards;
    private ArrayList<Player> players;

    public GameTable(ArrayList<Player> players, DeckOfCards deck, String game) {
        this.players = players;
        this.deck = deck;
        this.game = game;
    }

    public void DealHandToPlayers(int n) {
        for(Player player: players) {
            List<PlayingCard> toAssign = (List<PlayingCard>) deck.dealHand(n);
            player.newHand(toAssign);
        }
    }


    public void dealTurnOrRiver() {
        communityCards.add(deck.dealTurnOrRiver());
    }

    public void dealFlop() {
        communityCards = deck.dealFlop();
    }

    public DeckOfCards getDeck() {
        return deck;
    }

    public List<PlayingCard> getCommunityCards() {
        return communityCards;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "GameTable{" +
                "deck=" + deck +
                ", communityCards=" + communityCards +
                ", players=" + players +
                '}';
    }
}
