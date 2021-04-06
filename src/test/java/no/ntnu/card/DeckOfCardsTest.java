package no.ntnu.card;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class DeckOfCardsTest {

    private final DeckOfCards deck1 = new DeckOfCards();

    @Nested
    class deckOfCardHasUniqueCards {

        @Test
        void getNumberOfCardsInDeck() {
            List<PlayingCard> cards = deck1.getCards();
            cards.addAll(deck1.getHand().getCards());

            Assertions.assertEquals(deck1.getCards().size(), 52);
        }

        @Test
        void thirteenOfEachSuit() {
            List<PlayingCard> cards = deck1.getCards();
            cards.addAll(deck1.getHand().getCards());


            int spadesSuit = (int) cards.stream().filter(s -> s.getSuit() == 'S').count();
            int heartsSuit = (int) cards.stream().filter(s -> s.getSuit() == 'H').count();
            int diamondsSuit = (int) cards.stream().filter(s -> s.getSuit() == 'D').count();
            int clubsSuit = (int) cards.stream().filter(s -> s.getSuit() == 'C').count();

            Assertions.assertEquals(spadesSuit, 13);
            Assertions.assertEquals(heartsSuit, 13);
            Assertions.assertEquals(diamondsSuit, 13);
            Assertions.assertEquals(clubsSuit, 13);
        }

        @Test
        void fourOfEachFace() {
            List<PlayingCard> cards = deck1.getCards();
            cards.addAll(deck1.getHand().getCards());

            int faceForEachSuit = (int) deck1.getCards().stream()
                    .collect(Collectors.groupingBy(PlayingCard::getFace, Collectors.counting()))
                    .values().stream().filter(i -> i == 4).count();
            System.out.println(faceForEachSuit);

            Assertions.assertEquals(faceForEachSuit, 13);
        }
    }

    @Nested
    class dealerOperations {

        @Test
        /***
         * In poker (Texas holdem) the first 3 community cards dealt, is called "the flop".
         * The dealer 'burns' a card before dealing the flop.
         * Deck of 52 cards minus 2 player cards minus burnt card and flop should
         * equal 46 cards in deck.
         */
        void burnCardDealFlopSize() {
            deck1.dealFlop();
            int burntCardBeforeFlop = 1;

            Assertions.assertEquals(deck1.getCards().size(), 52
                                    - deck1.getHand().getCards().size()
                                    -deck1.getCommunityCards().size()
                                    - burntCardBeforeFlop);
        }

        @Test
        void handOrCommunityCardsNotInDeckAfter_Flop() {
            deck1.dealFlop();

            boolean duplicatesExists = false;
            for(PlayingCard card: deck1.getBoard()) {
                if (deck1.getCards().contains(card)) {
                    duplicatesExists = true;
                    break;
                }
            }
            Assertions.assertFalse(duplicatesExists);
        }

        @Test
        void handOrCommunityCardsNotInDeckAfter_Turn_River() {
            deck1.dealFlop();
            deck1.dealTurnOrRiver();

            boolean duplicatesExistsAfterTurn = false;
            for(PlayingCard card: deck1.getBoard()) {
                if (deck1.getCards().contains(card)) {
                    duplicatesExistsAfterTurn = true;
                    break;
                }
            }
            Assertions.assertFalse(duplicatesExistsAfterTurn);
            Assertions.assertEquals(deck1.getCards().size(), 44);



            deck1.dealTurnOrRiver();
            boolean duplicatesExistsAfterRiver = false;

            for(PlayingCard card: deck1.getBoard()) {
                if (deck1.getCards().contains(card)) {
                    duplicatesExistsAfterRiver = true;
                    break;
                }
            }
            Assertions.assertFalse(duplicatesExistsAfterRiver);
            Assertions.assertEquals(deck1.getCards().size(), 42);

        }

    }

    @Nested
            /***
             * This class contains test methods for DeckOfCards.checkHandRank().
             * methods for testing the rank hierarchy.
             * Ranking hierarchy: flush -> set -> two pair -> pair -> high card.
             */
    class handRanking {

        @Test
        /***
         * Method loops until poker board got both set and flush.
         * In this case, it should score flush as its higher priority.
         */
        void flushWhenAlsoSetIsTrue() {
            boolean notFound = true;
            
            DeckOfCards testDeck = null;

            while(notFound) {
                testDeck = new DeckOfCards();
                testDeck.dealFlop();
                testDeck.dealTurnOrRiver();
                testDeck.dealTurnOrRiver();

                int set = testDeck.set();
                String flush = testDeck.flush();
                if((set != 0) && (!flush.equals(""))) notFound = false;
            }

            String rank = testDeck.checkHandRank();
            Assertions.assertTrue(rank.startsWith("F"));
        }

        @Test
        /***
         * Method loops until one of the boards contains 'queen of spades'
         * while the other board does not have it.
         * In this case assertTrue(testDeck.queenOfSpades()) should always be true.
         * assertFalse(testDeck2.queenOfSpades()) should always be false.
         */
        void queenOfSpadesTest() {
            DeckOfCards testDeck = null;
            DeckOfCards testDeck2 = null;
            boolean notReady = true;

            while (notReady) {
                testDeck = new DeckOfCards();
                testDeck.dealFlop();
                testDeck.dealTurnOrRiver();
                testDeck.dealTurnOrRiver();
                testDeck2 = new DeckOfCards();
                testDeck2.dealFlop();
                testDeck2.dealTurnOrRiver();
                testDeck2.dealTurnOrRiver();

                if((testDeck.getBoard().contains(new PlayingCard('S', 12)))
                    && (!(testDeck2.getBoard().contains(new PlayingCard('S', 12))))) {
                    notReady = false;
                }

            }
            Assertions.assertTrue(testDeck.queenOfSpades());
            Assertions.assertFalse(testDeck2.queenOfSpades());
        }
    }
}