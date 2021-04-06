package no.ntnu.card;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DeckOfCards {

    private final char[] suit = { 'S', 'H', 'D', 'C' };
    private final List<PlayingCard> cards;
    private List<PlayingCard> communityCards;
    private Hand hand;

    public DeckOfCards() {
        this.cards = IntStream.range(0, suit.length).mapToObj(i -> suit[i])
                .flatMap(suit ->
                        IntStream.rangeClosed(1, 13)
                                .mapToObj(face -> new PlayingCard(suit, face)))
                .collect(Collectors.toList());

        communityCards = new ArrayList<>();

        shuffleDeck();
        newHand(2);
    }



    public List<PlayingCard> getBoard() {
        Stream<PlayingCard> combinedStream = Stream.concat(
                communityCards.stream(),
                hand.getCards().stream());

        return combinedStream.collect(Collectors.toList());
    }



    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    private void burnCard() {
        updateDeck(cards.remove(cards.size()-1));
    }

    private String flush() {
        int s = 0;
        int h = 0;
        int c = 0;
        int d = 0;
        Map<Character, Integer> values = new HashMap<>();
        List<Character> chars = getBoard().stream().map(PlayingCard::getSuit).collect(Collectors.toList());
        for(Character ch: chars) {
            switch (ch) {
                case 'S':
                    s++;
                    values.put('S', s);
                    break;
                case 'H':
                    h++;
                    values.put('H', h);
                    break;
                case 'C':
                    c++;
                    values.put('C', c);
                    break;
                case 'D':
                    d++;
                    values.put('D', d);
                    break;
            }
        }

        char flushChar = Collections.max(values.entrySet(), Comparator.comparingInt(Map.Entry::getValue))
                .getKey();

        String flushType = "";
        String toReturn = "";

        if(values.get(flushChar) >= 5) {
            switch (flushChar) {
                case 'S':
                    flushType = "Spades";
                    break;
                case 'H':
                    flushType = "Hearts";
                    break;
                case 'C':
                    flushType = "Clubs";
                    break;
                case 'D':
                    flushType = "Diamonds";
                    break;
            }
            toReturn = "Flush with " + flushType;
        }
        return toReturn;
    }

    public String highCard() {
        PlayingCard r = Collections.min(getBoard(), Comparator.comparingInt(PlayingCard::getFace));
        PlayingCard p = Collections.max(getBoard(), Comparator.comparingInt(PlayingCard::getFace));
        if(r.getFace() == 1) return r.getAsString();
        return p.getAsString();
    }

    public int sumOfCards() {
        return getBoard().stream().mapToInt(PlayingCard::getFace).sum();
    }

    public String getHearts() {
        String hearts = getBoard().stream().
                filter(p -> p.getSuit() == 'H').
                map(PlayingCard::getAsString).map(s -> s + " ").
                collect(Collectors.joining());

        try {
            if(hearts.charAt(0) == 'H') return hearts;
        } catch (StringIndexOutOfBoundsException e) {
            return "No hearts";
        }
        return "No hearts";
    }

    public boolean queenOfSpades() {
        return getBoard().stream().anyMatch(s -> s.equals(new PlayingCard('S', 12)));
    }

    public int set() {
        return (int) getBoard().stream()
                .collect(Collectors.groupingBy(PlayingCard::getFace, Collectors.counting()))
                .values().stream().filter(i-> i > 2).count();
    }

    public String pair() {
        int x = (int) getBoard().stream()
                .collect(Collectors.groupingBy(PlayingCard::getFace, Collectors.counting()))
                .values().stream().filter(i-> i > 1).count();

            if(x == 1) {
                return "One pair";
            } else if(x >= 2) return "Two pair";
            else return "";
    }

    public String checkHandRank() {
        if(!((flush().equals("")))) return flush();

        if(set() != 0) return "Set";

        if(!(pair().equals(""))) return pair();
        return "Highcard: " + highCard();
    }



    public void dealFlop() {
        burnCard();
        communityCards = cards.stream().limit(3).collect(Collectors.toList());
        updateDeck(communityCards);
    }

    private void newHand(int n) {
        this.hand = new Hand(dealHand(n));
    }

    public void dealTurnOrRiver() {
        burnCard();
        PlayingCard toAdd = cards.stream().findFirst().get();
        communityCards.add(toAdd);
        updateDeck(toAdd);
    }

    private void updateDeck(List<PlayingCard> toRemove) {
        cards.removeIf(toRemove::contains);
    }
    private void updateDeck(PlayingCard toRemove) {
        cards.remove(toRemove);
    }


    private List<PlayingCard> dealHand(int n) {
       List<PlayingCard> toReturn = cards.stream().limit(n).collect(Collectors.toList());
       updateDeck(toReturn);
       return toReturn;
    }



    public List<PlayingCard> getCards() {
        return cards;
    }

    public Hand getHand() {
        return hand;
    }

    public List<PlayingCard> getCommunityCards() {
        return communityCards;
    }

    @Override
    public String toString() {
        return "DeckOfCards{" +
                "suit=" + Arrays.toString(suit) +
                ", cards=" + cards +
                '}';
    }
}
