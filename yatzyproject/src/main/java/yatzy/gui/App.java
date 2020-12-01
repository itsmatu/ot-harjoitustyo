package yatzy.gui;

import yatzy.applogic.Players;
import yatzy.applogic.Dice;

import javafx.application.Application;
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
        Button nextPlayerButton = new Button("Next player");
        nextPlayerButton.setDisable(true);

        // SCORECARD 
        // UPPER SECTION
        // ONES
        Label ones = new Label("Ones: ");
        Label onesValue = new Label("-");
        Button onesAdd = new Button("add");
        onesAdd.setDisable(false);
        HBox onesContents = new HBox(onesAdd, ones, onesValue);
        // TWOS
        Label twos = new Label("Twos: ");
        Label twosValue = new Label("-");
        Button twosAdd = new Button("add");
        twosAdd.setDisable(false);
        HBox twosContents = new HBox(twosAdd, twos, twosValue);
        // THREES
        Label threes = new Label("Threes: ");
        Label threesValue = new Label("-");
        Button threesAdd = new Button("add");
        threesAdd.setDisable(false);
        HBox threesContents = new HBox(threesAdd, threes, threesValue);
        // FOURS
        Label fours = new Label("Fours: ");
        Label foursValue = new Label("-");
        Button foursAdd = new Button("add");
        foursAdd.setDisable(false);
        HBox foursContents = new HBox(foursAdd, fours, foursValue);
        // FIVES
        Label fives = new Label("Fives: ");
        Label fivesValue = new Label("-");
        Button fivesAdd = new Button("add");
        fivesAdd.setDisable(false);
        HBox fivesContents = new HBox(fivesAdd, fives, fivesValue);
        // SIXES
        Label sixes = new Label("Sixes: ");
        Label sixesValue = new Label("-");
        Button sixesAdd = new Button("add");
        sixesAdd.setDisable(false);
        HBox sixesContents = new HBox(sixesAdd, sixes, sixesValue);

        // LOWER SECTION
        // ONE PAIR
        Label onePair = new Label("One pair: ");
        Button onePairAdd = new Button("add");
        onePairAdd.setDisable(false);
        Label onePairValue = new Label("-");
        HBox onePairContents = new HBox(onePairAdd, onePair, onePairValue);
        // TWO PAIRS
        Label twoPairs = new Label("Two pairs: ");
        Button twoPairsAdd = new Button("add");
        twoPairsAdd.setDisable(false);
        Label twoPairsValue = new Label("-");
        HBox twoPairsContents = new HBox(twoPairsAdd, twoPairs, twoPairsValue);
        // THREE OF A KIND
        Label threeOfAKind = new Label("Three of a kind: ");
        Button threeKindAdd = new Button("add");
        threeKindAdd.setDisable(false);
        Label threeKindValue = new Label("-");
        HBox threeKindContents = new HBox(threeKindAdd, threeOfAKind, threeKindValue);
        // FOUR OF A KIND
        Label fourOfAKind = new Label("Four of a kind: ");
        Button fourKindAdd = new Button("add");
        fourKindAdd.setDisable(false);
        Label fourKindValue = new Label("-");
        HBox fourKindContents = new HBox(fourKindAdd, fourOfAKind, fourKindValue);
        // SMALL STRAIGHT (1, 2, 3, 4, 5)
        Label smallStraight = new Label("Small straight: ");
        Button smallAdd = new Button("add");
        smallAdd.setDisable(false);
        Label smallValue = new Label("-");
        HBox smallContents = new HBox(smallAdd, smallStraight, smallValue);
        // LARGE STRAIGHT (2, 3, 4, 5, 6)
        Label largeStraight = new Label("Large straight: ");
        Button largeAdd = new Button("add");
        largeAdd.setDisable(false);
        Label largeValue = new Label("-");
        HBox largeContents = new HBox(largeAdd, largeStraight, largeValue);
        // FULL HOUSE
        Label fullHouse = new Label("Full house: ");
        Button fullAdd = new Button("add");
        fullAdd.setDisable(false);
        Label fullValue = new Label("-");
        HBox fullContents = new HBox(fullAdd, fullHouse, fullValue);
        // CHANCE
        Label chance = new Label("Chance: ");
        Button chanceAdd = new Button("add");
        chanceAdd.setDisable(false);
        Label chanceValue = new Label("-");
        HBox chanceContents = new HBox(chanceAdd, chance, chanceValue);
        // YATZY
        Label yatzy = new Label("Yatzy: ");
        Button yatzyAdd = new Button("add");
        yatzyAdd.setDisable(false);
        Label yatzyValue = new Label("-");
        HBox yatzyContents = new HBox(yatzyAdd, yatzy, yatzyValue);
        // SCORE SUM
        Label scoreLabel = new Label("Score sum: ");
        Label scoreSumLabel = new Label("-");

        // PLAYER CREATION WINDOW
        HBox playerButtons = new HBox(addPlayer, removePlayer);
        VBox buttonandtext = new VBox(playername, playerButtons, start);
        BorderPane playerCreation = new BorderPane();
        playerCreation.setLeft(buttonandtext);
        playerCreation.setRight(playersAdded);

        // GAME WINDOW
        HBox scoreAndSum = new HBox(scoreLabel, scoreSumLabel);
        HBox dices = new HBox(dice1, dice2, dice3, dice4, dice5, roll);
        VBox dicesAndPlayername = new VBox(currentPlayer, dices, nextPlayerButton);
        VBox scorecardContents = new VBox(onesContents, twosContents, threesContents, foursContents, fivesContents, sixesContents,
                onePairContents, twoPairsContents, threeKindContents,
                fourKindContents, smallContents, largeContents, fullContents, chanceContents, yatzyContents, scoreAndSum);
        BorderPane gameWindow = new BorderPane();
        gameWindow.setLeft(scorecardContents);
        gameWindow.setRight(dicesAndPlayername);

        // SCENES
        Scene addPlayers = new Scene(playerCreation, 500, 400);
        Scene game = new Scene(gameWindow, 500, 400);

        // ROLL BUTTON ON ACTIONS
        roll.setOnAction(event -> {
            dice.roll();
            dice1.setDisable(false);
            dice2.setDisable(false);
            dice3.setDisable(false);
            dice4.setDisable(false);
            dice5.setDisable(false);
            if (!(dice.diceIsSelected(1))) {
                dice1.setText(String.valueOf(dice.setDiceValue(1)));
            }
            if (!(dice.diceIsSelected(2))) {
                dice2.setText(String.valueOf(dice.setDiceValue(2)));
            }
            if (!(dice.diceIsSelected(3))) {
                dice3.setText(String.valueOf(dice.setDiceValue(3)));
            }
            if (!(dice.diceIsSelected(4))) {
                dice4.setText(String.valueOf(dice.setDiceValue(4)));
            }
            if (!(dice.diceIsSelected(5))) {
                dice5.setText(String.valueOf(dice.setDiceValue(5)));
            }
            if (dice.wasLastRoll()) {
                roll.setDisable(true);
            }
            dice.clearSelectedDices();
        });

        // GAME BUTTON ACTIONS
        dice1.setOnAction(event -> {
            dice.addToSelectedDices(1, Integer.valueOf(dice1.getText()));
            dice1.setDisable(true);
        });
        dice2.setOnAction(event -> {
            dice.addToSelectedDices(2, Integer.valueOf(dice2.getText()));
            dice2.setDisable(true);
        });
        dice3.setOnAction(event -> {
            dice.addToSelectedDices(3, Integer.valueOf(dice3.getText()));
            dice3.setDisable(true);
        });
        dice4.setOnAction(event -> {
            dice.addToSelectedDices(4, Integer.valueOf(dice4.getText()));
            dice4.setDisable(true);
        });
        dice5.setOnAction(event -> {
            dice.addToSelectedDices(5, Integer.valueOf(dice5.getText()));
            dice5.setDisable(true);
        });
        nextPlayerButton.setOnAction(event -> {
            players.nextPlayer();
            currentPlayer.setText(players.getCurrentPlayer());
            dice1.setDisable(true);
            dice2.setDisable(true);
            dice3.setDisable(true);
            dice4.setDisable(true);
            dice5.setDisable(true);
            roll.setDisable(false);
            dice1.setText("?");
            dice2.setText("?");
            dice3.setText("?");
            dice4.setText("?");
            dice5.setText("?");
            dice.clearSelectedDices();
            dice.endTurn();
            scoreSumLabel.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScoreSum()));

            nextPlayerButton.setDisable(true);
            if (players.getPlayerScorecard(currentPlayer.getText()).doesNotContainScore("ones")) {
                onesValue.setText("-");
                onesAdd.setDisable(false);
            } else {
                onesAdd.setDisable(true);
                onesValue.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScore("ones")));
            }
            if (players.getPlayerScorecard(currentPlayer.getText()).doesNotContainScore("twos")) {
                twosValue.setText("-");
                twosAdd.setDisable(false);
            } else {
                twosAdd.setDisable(true);
                twosValue.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScore("twos")));
            }
            if (players.getPlayerScorecard(currentPlayer.getText()).doesNotContainScore("threes")) {
                threesValue.setText("-");
                threesAdd.setDisable(false);
            } else {
                threesAdd.setDisable(true);
                threesValue.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScore("threes")));
            }
            if (players.getPlayerScorecard(currentPlayer.getText()).doesNotContainScore("fours")) {
                foursValue.setText("-");
                foursAdd.setDisable(false);
            } else {
                foursAdd.setDisable(true);
                foursValue.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScore("fours")));
            }
            if (players.getPlayerScorecard(currentPlayer.getText()).doesNotContainScore("fives")) {
                fivesValue.setText("-");
                fivesAdd.setDisable(false);
            } else {
                fivesAdd.setDisable(true);
                fivesValue.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScore("fives")));
            }
            if (players.getPlayerScorecard(currentPlayer.getText()).doesNotContainScore("sixes")) {
                sixesValue.setText("-");
                sixesAdd.setDisable(false);
            } else {
                sixesAdd.setDisable(true);
                sixesValue.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScore("sixes")));
            }
            if (players.getPlayerScorecard(currentPlayer.getText()).doesNotContainScore("one pair")) {
                onePairValue.setText("-");
                onePairAdd.setDisable(false);
            } else {
                onePairAdd.setDisable(true);
                onePairValue.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScore("one pair")));
            }
        });

        // SCORECARD BUTTONS
        onesAdd.setOnAction(event -> {
            players.getPlayerScorecard(currentPlayer.getText()).addScore("ones", dice.diceSum(1));
            onesValue.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScore("ones")));
            roll.setDisable(true);
            nextPlayerButton.setDisable(false);
            dice.clearDiceValues();
        });
        twosAdd.setOnAction(event -> {
            players.getPlayerScorecard(currentPlayer.getText()).addScore("twos", dice.diceSum(2));
            twosValue.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScore("twos")));
            roll.setDisable(true);
            nextPlayerButton.setDisable(false);
            dice.clearDiceValues();
        });
        threesAdd.setOnAction(event -> {
            players.getPlayerScorecard(currentPlayer.getText()).addScore("threes", dice.diceSum(3));
            threesValue.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScore("threes")));
            roll.setDisable(true);
            nextPlayerButton.setDisable(false);
            dice.clearDiceValues();
        });
        foursAdd.setOnAction(event -> {
            players.getPlayerScorecard(currentPlayer.getText()).addScore("fours", dice.diceSum(4));
            foursValue.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScore("fours")));
            roll.setDisable(true);
            nextPlayerButton.setDisable(false);
            dice.clearDiceValues();
        });
        fivesAdd.setOnAction(event -> {
            players.getPlayerScorecard(currentPlayer.getText()).addScore("fives", dice.diceSum(5));
            fivesValue.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScore("fives")));
            roll.setDisable(true);
            nextPlayerButton.setDisable(false);
            dice.clearDiceValues();
        });
        sixesAdd.setOnAction(event -> {
            players.getPlayerScorecard(currentPlayer.getText()).addScore("sixes", dice.diceSum(6));
            sixesValue.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScore("sixes")));
            roll.setDisable(true);
            nextPlayerButton.setDisable(false);
            dice.clearDiceValues();
        });
        
        onePairAdd.setOnAction(event -> {
            players.getPlayerScorecard(currentPlayer.getText()).addScore("one pair", dice.onePairSum());
            onePairValue.setText(String.valueOf(players.getPlayerScorecard(currentPlayer.getText()).getScore("one pair")));
            roll.setDisable(true);
            nextPlayerButton.setDisable(false);
            dice.clearDiceValues();
        });
        // PLAYER CREATION WINDOW BUTTONS
        addPlayer.setOnAction(event -> {
            if (!(playername.getText().isEmpty()) && !(players.containsPlayer(playername.getText()))) {
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
