package no.ntnu.card;

import java.util.List;

public class Hand {
    private final List<PlayingCard> cards;

    public Hand(List<PlayingCard> cards) {
        this.cards = cards;
    }

    public void addCard(PlayingCard cardToAdd) {
        cards.add(cardToAdd);
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
