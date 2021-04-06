package no.ntnu.card;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    public static Stage primaryStage;



    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Card Game");
        stage.setResizable(false);
        scene = new Scene(loadFXML("mainPage"));
        stage.setScene(scene);
        primaryStage = stage;
        stage.show();
    }


    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void main(String []args) {
        launch();
    }


}
