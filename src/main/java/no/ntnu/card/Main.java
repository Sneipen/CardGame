package no.ntnu.card;

public class Main {
    public static void main(String []args) {
        DeckOfCards d1 = new DeckOfCards();

        d1.newHand(2);

        System.out.println(d1.getHands().get(0).getCards());

    }
}
