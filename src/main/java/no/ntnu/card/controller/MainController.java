package no.ntnu.card.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import no.ntnu.card.DeckOfCards;
import no.ntnu.card.Hand;
import no.ntnu.card.PlayingCard;

public class MainController {
    private DeckOfCards deck;
    private Hand hand;


    @FXML
    private Button dealHandButton;

    @FXML
    private Button dealFlopButton;

    @FXML
    private Button dealTurnRiverButton;

    @FXML
    private Button checkHandValueButton;

    @FXML
    private Button newGameButton;

    @FXML
    private ImageView communityCard1;

    @FXML
    private ImageView communityCard2;

    @FXML
    private ImageView communityCard3;

    @FXML
    private ImageView communityCard4;

    @FXML
    private ImageView communityCard5;

    @FXML
    private ImageView personalCard1;

    @FXML
    private ImageView personalCard2;


    @FXML
    void checkHandValue(ActionEvent event) {

    }

    @FXML
    void dealFlop(ActionEvent event) {

    }

    @FXML
    void dealHand(ActionEvent event) {

    }

    @FXML
    void dealTurnOrRiver(ActionEvent event) {

    }

    @FXML
    void newGame(ActionEvent e) {
        deck = new DeckOfCards();
        Image card1 = new Image(getClass().getResourceAsStream("/cardImg/" + deck.getHand().getCards().get(0).getCardImagePath()));
       // Image card2 = new Image(getClass().getResourceAsStream("/cardImg/" + deck.getHand().getCards().get(1).getCardImagePath()));
        personalCard1.setImage(card1);
      //  personalCard2.setImage(card2);
      //  System.out.println(deck.getHand().getCards().get(0).getCardImagePath());
      //  for(PlayingCard card: deck.getCards()) {
       //     System.out.println(card.getCardImagePath());
      //  }

    }

}
