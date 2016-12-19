package mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import static javafx.scene.layout.AnchorPane.setLeftAnchor;
import static javafx.scene.layout.AnchorPane.setTopAnchor;

/**
 * Created by Aditya Kharosekar on 12/18/2016.
 */
public class GUI {

    public int[] nums;

    GUI() {
        nums = new int[] {-1, -1, -1, -1}; //These have to be -1 because in my changeColor function,
                                           //I update the color index and then display the color
    }
    /**
     * Creates and displays welcome screen. This screen will show the rules of the game
     * and will have a "Start game" button so the user can start playing.
     * It will also have an "Exit" button so the user can quit instead
     */
    public void createWelcomeScreen() {
        Stage stage = new Stage();
        stage.setTitle("Welcome");
        AnchorPane welcomeScreen = new AnchorPane();
        Scene scene = new Scene(welcomeScreen, 520, 550);
        Label rules = new Label();
        setTopAnchor(rules, 15.0);
        setLeftAnchor(rules, 80.0);
        rules.setText("Welcome to Mastermind.\n" +
                "\n" +
                "The objective of the game is to correctly guess a secret code consisting\n" +
                "of a series of 4 colored pegs.\n\n" +
                "Each peg will be of one of 6 colors – Blue, Green, Orange, Purple, Red,\nand Yellow.\n" +
                "More than one peg in the secret code could be of the same color.\nYou must guess the correct color " +
                "and order of the code.\n\n" +
                "You will have 10 chances to correctly guess the code.\n\nAfter every guess, the computer " +
                "will provide you feedback in the\nform of 0 to 4 colored pegs. A black peg indicates " +
                "that a peg in your guess is\nof the correct color and is in the correct position.\n" +
                "A white peg indicates that a peg in your guess is of the correct color\n" +
                "but is not in the correct position.\n\n" +
                "NOTE: The order of the feedback pegs does not correspond to either the\npegs in the code " +
                "or the pegs in your guess. " +
                "\nIn other words, the color of the pegs is important, not the order they are in.\n\n" +
                "Are you ready?");
        welcomeScreen.getChildren().add(rules);

        Button play = new Button("Start Game");
        setTopAnchor(play, 420.0);
        setLeftAnchor(play, 80.0);
        play.setPrefHeight(50.0);
        play.setPrefWidth(120.0);
        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
                createGameScreen();

            }
        });
        Button quit = new Button("Quit");
        setTopAnchor(quit, 420.0);
        setLeftAnchor(quit, 330.0);
        quit.setPrefWidth(120.0);
        quit.setPrefHeight(50.0);
        quit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
                System.exit(0);
            }
        });

        welcomeScreen.getChildren().addAll(play,quit);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Creates and displays game screen
     */
    public void createGameScreen() {
        Stage stage = new Stage();
        stage.setTitle("Mastermind");
        AnchorPane gameScreen = new AnchorPane();
        Scene scene = new Scene(gameScreen, 800, 600);

        /*
        This part of the code creates the circles which the player will use to select their guess
         */
        HBox options = new HBox();
        options.setSpacing(30.0);
        Circle c1 = new Circle(20.0);
        c1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                changeColor(c1, 0); //0 denotes that the first circle's color should be changed
            }
        });
        Circle c2 = new Circle(20.0);
        c2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                changeColor(c2, 1);
            }
        });
        Circle c3 = new Circle(20.0);
        c3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                changeColor(c3, 2);
            }
        });
        Circle c4 = new Circle(20.0);
        c4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                changeColor(c4, 3);
            }
        });
        options.getChildren().addAll(c1, c2, c3, c4);
        setTopAnchor(options, 30.0);
        setLeftAnchor(options, 250.0);



        gameScreen.getChildren().add(options);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * This function is responsible for the different colors that the guess circles can have
     * @param c Circle whose color needs to be changed
     * @param index denotes which color the circle currently has
     */
    public void changeColor(Circle c, int index) {
        if (nums[index]==5) { //there are only 6 color options
            nums[index]=0;
        }
        else {
            nums[index]++;
        }
        switch (nums[index]) {
            case 0: {
                c.setFill(Color.BLUE); break;
            }
            case 1: {
                c.setFill(Color.GREEN); break;
            }
            case 2: {
                c.setFill(Color.ORANGE); break;
            }
            case 3: {
                c.setFill(Color.PURPLE); break;
            }
            case 4: {
                c.setFill(Color.RED); break;
            }
            case 5: {
                c.setFill(Color.YELLOW); break;
            }
        }
    }
}
