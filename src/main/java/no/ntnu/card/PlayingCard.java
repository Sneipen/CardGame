package no.ntnu.card;

/**
 * Represents a playing card. A playing card has a number (face) between
 * 1 and 13, where 1 is called an Ace, 11 = Knight, 12 = Queen and 13 = King.
 * The card can also be one of 4 suits: Spade, Heart, Diamonds and Clubs.
 *
 * @author ntnu
 * @version 2020-01-10
 */
public class PlayingCard {

    private final char suit; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
    private final int face; // a number between 1 and 13
    private final String cardImagePath;

    /**
     * Creates an instance of a PlayingCard with a given suit and face.
     *  @param suit The suit of the card, as a single character. 'S' for Spades,
     *             'H' for Heart, 'D' for Diamonds and 'C' for clubs
     * @param face The face value of the card, an integer between 1 and 13
     */
    public PlayingCard(char suit, int face) {
        this.suit = suit;
        this.face = face;
        this.cardImagePath = face + Character.toString(suit) + ".png";
    }

    /**
     * Returns the suit and face of the card as a string.
     * A 4 of hearts is returned as the string "H4".
     *
     * @return the suit and face of the card as a string
     */
    public String getAsString() {
        return String.format("%s%s", suit, face);
    }

    /**
     * Returns the suit of the card, 'S' for Spades, 'H' for Heart, 'D' for Diamonds and 'C' for clubs
     *
     * @return the suit of the card
     */
    public char getSuit() {
        return suit;
    }

    /**
     * Returns the face of the card (value between 1 and 13).
     *
     * @return the face of the card
     */
    public int getFace() {
        return face;
    }

    public String getCardImagePath() {
        return cardImagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayingCard that = (PlayingCard) o;

        if (suit != that.suit) return false;
        return face == that.face;
    }

    @Override
    public int hashCode() {
        int result = suit;
        result = 31 * result + face;
        return result;
    }

    @Override
    public String toString() {
        return "PlayingCard{" +
                "suit=" + suit +
                ", face=" + face +
                '}';
    }
}
