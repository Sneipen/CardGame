module no.ntnu.card {

    requires transitive javafx.controls;
    requires javafx.fxml;

    opens no.ntnu.card.controller to javafx.fxml;
    exports no.ntnu.card;

}