package no.ntnu.card;

import java.util.List;

public class Hand {
    private List<PlayingCard> cards;

    public Hand(List<PlayingCard> cards) {
        this.cards = cards;
    }

    public List<PlayingCard> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }
}
