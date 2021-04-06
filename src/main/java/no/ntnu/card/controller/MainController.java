package no.ntnu.card.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import no.ntnu.card.DeckOfCards;

public class MainController {

    private DeckOfCards deck;

    @FXML
    private TextField handRank;

    @FXML
    private TextField queenOfSpadesField;

    @FXML
    private TextField cardsOfHeartsField;

    @FXML
    private TextField sumOfTheFacesField;

    @FXML
    private Button dealFlopButton;

    @FXML
    private Button dealTurnButton;

    @FXML
    private Button dealRiverButton;

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
    void checkHandValue() {
        String handValue = deck.checkHandRank();
        handRank.setText(handValue);

        if(deck.queenOfSpades()) {
            queenOfSpadesField.setText("True");
        } else queenOfSpadesField.setText("False");

        sumOfTheFacesField.setText(Integer.toString(deck.sumOfCards()));
        cardsOfHeartsField.setText(deck.getHearts());
    }


    @FXML
    void dealFlop(ActionEvent event) {
        deck.dealFlop();
        communityCard1.setImage(new Image(getClass().
                getResourceAsStream("/cardImg/" + deck.getCommunityCards().
                        get(0).getCardImagePath())));
        communityCard1.setVisible(true);

        communityCard2.setImage(new Image(getClass().
                getResourceAsStream("/cardImg/" + deck.getCommunityCards().
                        get(1).getCardImagePath())));
        communityCard2.setVisible(true);

        communityCard3.setImage(new Image(getClass().
                getResourceAsStream("/cardImg/" + deck.getCommunityCards().
                        get(2).getCardImagePath())));
        communityCard3.setVisible(true);


        dealFlopButton.setVisible(false);
        dealTurnButton.setVisible(true);
        checkHandValueButton.setVisible(true);
    }


    @FXML
    void dealTurn(ActionEvent event) {
            deck.dealTurnOrRiver();
            communityCard4.setImage(new Image(getClass().
                getResourceAsStream("/cardImg/" + deck.getCommunityCards().
                     get(3).getCardImagePath())));
            communityCard4.setVisible(true);

            dealTurnButton.setVisible(false);
            dealRiverButton.setVisible(true);
    }


    @FXML
    void dealRiver(ActionEvent event) {
        deck.dealTurnOrRiver();
        communityCard5.setImage(new Image(getClass().
                getResourceAsStream("/cardImg/" + deck.getCommunityCards().
                        get(4).getCardImagePath())));
        communityCard5.setVisible(true);

        dealRiverButton.setVisible(false);
    }



    @FXML
    void newGame(ActionEvent e) {
        deck = new DeckOfCards();
        personalCard1.setImage(new Image(getClass().
                getResourceAsStream("/cardImg/" + deck.getHand().
                        getCards().get(0).getCardImagePath())));

        personalCard2.setImage(new Image(getClass().
                getResourceAsStream("/cardImg/" + deck.getHand().
                        getCards().get(1).getCardImagePath())));


        dealFlopButton.setVisible(true);
        dealTurnButton.setVisible(false);
        dealRiverButton.setVisible(false);
        communityCard1.setVisible(false);
        communityCard2.setVisible(false);
        communityCard3.setVisible(false);
        communityCard4.setVisible(false);
        communityCard5.setVisible(false);
        checkHandValueButton.setVisible(false);
        handRank.setText("");
        queenOfSpadesField.setText("");
        sumOfTheFacesField.setText("");
        cardsOfHeartsField.setText("");
    }



}
