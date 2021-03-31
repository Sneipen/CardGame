package no.ntnu.card;

import java.util.List;

public class Player {
    private final String firstName;
    private final String lastName;
    private int position;
    private Hand hand;
    private int chips;

    public Player(String firstName, String lastName, int chips) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.chips = chips;
    }

    public void newHand(List<PlayingCard> cards) {
        this.hand = new Hand(cards);
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPosition() {
        return position;
    }

    public Hand getHand() {
        return hand;
    }

    public int getChips() {
        return chips;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", hand=" + hand +
                ", chips=" + chips +
                '}';
    }
}
