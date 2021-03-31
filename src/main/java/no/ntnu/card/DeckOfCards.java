package no.ntnu.card;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeckOfCards {

    private final char[] suit = { 'S', 'H', 'D', 'C' };
    private final List<PlayingCard> cards;
    private List<PlayingCard> communityCards;

    public DeckOfCards() {
        this.cards = IntStream.range(0, suit.length).mapToObj(i -> suit[i])
                .flatMap(suit ->
                        IntStream.rangeClosed(1, 13)
                                .mapToObj(face -> new PlayingCard(suit, face)))
                .collect(Collectors.toList());

        shuffleDeck();
    }




    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public void burnCard() {
        cards.remove(cards.size()-1);
    }

    public List<PlayingCard> dealFlop() {
        List<PlayingCard> flop = cards.stream().limit(3).collect(Collectors.toList());
        this.cards.removeIf(e -> flop.contains(e));
        communityCards = flop;
        return flop;
    }

    public PlayingCard dealTurnOrRiver() {
        PlayingCard toReturn = cards.stream().findFirst().get();
        this.cards.remove(toReturn);
        return toReturn;
    }

    public Collection<PlayingCard> dealHand(int n) {

    }

    public char[] getSuit() {
        return suit;
    }

    public List<PlayingCard> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "DeckOfCards{" +
                "suit=" + Arrays.toString(suit) +
                ", cards=" + cards +
                '}';
    }
}
