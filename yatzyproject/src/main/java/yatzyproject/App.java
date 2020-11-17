package yatzyproject;

import yatzyproject.applogic.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Dice dice = new Dice();
        Players players = new Players();

        // PLAYER CREATION ELEMENTS
        TextField playername = new TextField();
        ListView<String> playersAdded = new ListView();
        Button addPlayer = new Button("Add player");
        Button removePlayer = new Button("Remove player");
        removePlayer.setDisable(true);
        Button start = new Button("Start game");
        start.setDisable(true);
        addPlayer.setDefaultButton(true);

        // DICES
        Button dice1 = new Button("?");
        dice1.setDisable(true);
        Button dice2 = new Button("?");
        dice2.setDisable(true);
        Button dice3 = new Button("?");
        dice3.setDisable(true);
        Button dice4 = new Button("?");
        dice4.setDisable(true);
        Button dice5 = new Button("?");
        dice5.setDisable(true);
        Button roll = new Button("Roll");

        // GAME WINDOW ELEMENTS
        Label currentPlayer = new Label("");

        // PLAYER CREATION WINDOW
        HBox playerButtons = new HBox(addPlayer, removePlayer);
        VBox buttonandtext = new VBox(playername, playerButtons, start);
        BorderPane playerCreation = new BorderPane();
        playerCreation.setLeft(buttonandtext);
        playerCreation.setRight(playersAdded);

        // GAME WINDOW
        HBox dices = new HBox(dice1, dice2, dice3, dice4, dice5, roll);
        VBox test = new VBox(currentPlayer, dices);

        // SCENES
        Scene addPlayers = new Scene(playerCreation, 500, 700);
        Scene game = new Scene(test, 500, 700);

        // ROLL BUTTON ON ACTIONS
        roll.setOnAction(event -> {
            dice.roll();
            if (!(dice.diceIsSelected(1))) {
                dice1.setText(String.valueOf(dice.setDiceValue(1)));
                dice1.setDisable(false);
            }
            if (!(dice.diceIsSelected(2))) {
                dice2.setText(String.valueOf(dice.setDiceValue(2)));
                dice2.setDisable(false);
            }
            if (!(dice.diceIsSelected(3))) {
                dice3.setText(String.valueOf(dice.setDiceValue(3)));
                dice3.setDisable(false);
            }
            if (!(dice.diceIsSelected(4))) {
                dice4.setText(String.valueOf(dice.setDiceValue(4)));
                dice4.setDisable(false);
            }
            if (!(dice.diceIsSelected(5))) {
                dice5.setText(String.valueOf(dice.setDiceValue(5)));
                dice5.setDisable(false);
            }
            if (dice.wasLastRoll()) {
                dice.clearSelectedDices();
                roll.setDisable(true);
            }
        });

        // GAME BUTTON ACTIONS
        dice1.setOnAction(event -> {
            dice.addToSelectedDices(1);
            dice1.setDisable(true);
        });
        dice2.setOnAction(event -> {
            dice.addToSelectedDices(2);
            dice2.setDisable(true);
        });
        dice3.setOnAction(event -> {
            dice.addToSelectedDices(3);
            dice3.setDisable(true);
        });
        dice4.setOnAction(event -> {
            dice.addToSelectedDices(4);
            dice4.setDisable(true);
        });
        dice5.setOnAction(event -> {
            dice.addToSelectedDices(5);
            dice5.setDisable(true);
        });

        // PLAYER CREATION WINDOW BUTTONS
        addPlayer.setOnAction(event -> {
            if (!(playername.getText().isEmpty())) {
                players.addPlayer(playername.getText());
                playersAdded.getItems().add(playername.getText());
                removePlayer.setDisable(false);
                start.setDisable(false);
                playername.clear();
            }
        });
        removePlayer.setOnAction(event -> {
            String remove = playersAdded.getSelectionModel().getSelectedItem();
            playersAdded.getItems().remove(playersAdded.getSelectionModel().getSelectedItem());
            players.removePlayer(remove);
            if (playersAdded.getItems().size() == 0) {
                removePlayer.setDisable(true);
                start.setDisable(true);
            }
        });
        start.setOnAction(event -> {
            currentPlayer.setText(players.getCurrentPlayer());
            stage.setScene(game);
        });

        stage.setResizable(false);
        stage.setScene(addPlayers);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
