package no.ntnu.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeckOfCards {

    private final char[] suit = { 'S', 'H', 'D', 'C' };
    private final List<PlayingCard> cards;
    private List<Hand> hands;

    public DeckOfCards() {
        this.cards = IntStream.range(0, suit.length).mapToObj(i -> suit[i])
                .flatMap(suit ->
                        IntStream.rangeClosed(1, 13)
                                .mapToObj(face -> new PlayingCard(suit, face)))
                .collect(Collectors.toList());

        hands = new ArrayList<>();
        shuffleDeck();
    }




    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

//    public void burnCard() {
//        cards.remove(cards.size()-1);
//    }

    public List<PlayingCard> dealFlop() {
        List<PlayingCard> flop = cards.stream().limit(3).collect(Collectors.toList());
        updateDeck(flop);
        return flop;
    }

    public void newHand(int n) {
        Hand hand = new Hand(dealHand(n));
        hands.add(hand);
    }

    public PlayingCard dealTurnOrRiver() {
        PlayingCard toReturn = cards.stream().findFirst().get();
        this.cards.remove(toReturn);
        return toReturn;
    }

    private void updateDeck(List<PlayingCard> toRemove) {
        this.cards.removeIf(e -> toRemove.contains(e));
    }


    private List<PlayingCard> dealHand(int n) {
       List<PlayingCard> toReturn = cards.stream().limit(n).collect(Collectors.toList());
       updateDeck(toReturn);
       return toReturn;
    }

//    public Collection<PlayingCard> dealHand(int n) {
//        return drawHand(n);
//    }


    public List<PlayingCard> getCards() {
        return cards;
    }

    public List<Hand> getHands() {
        return hands;
    }

    @Override
    public String toString() {
        return "DeckOfCards{" +
                "suit=" + Arrays.toString(suit) +
                ", cards=" + cards +
                '}';
    }
}
