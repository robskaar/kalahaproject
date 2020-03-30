package GUI;

/**
 * @Author Robert Skaar
 * @Project Kalaha  -  https://github.com/robskaar
 * @Date 26-03-2020
 **/

import Domain.Cup;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * this class Game is actually a circular linked list, and cup's are like the nodes, this class is also assigned as the controller.
 */
public class Game implements Initializable {
    @FXML
    private ImageView cup1_1;

    @FXML
    private ImageView cup1_2;

    @FXML
    private ImageView cup1_3;

    @FXML
    private ImageView cup1_4;

    @FXML
    private ImageView cup1_5;

    @FXML
    private ImageView cup1_6;

    @FXML
    private ImageView cup2_6;

    @FXML
    private ImageView cup2_5;

    @FXML
    private ImageView cup2_4;

    @FXML
    private ImageView cup2_3;

    @FXML
    private ImageView cup2_2;

    @FXML
    private ImageView cup2_1;

    @FXML
    private Label label2_7;
    @FXML
    private Label label2_6;

    @FXML
    private Label label2_5;

    @FXML
    private Label label2_4;

    @FXML
    private Label label2_3;

    @FXML
    private Label label2_2;

    @FXML
    private Label label2_1;

    @FXML
    private Label label1_1;

    @FXML
    private Label label1_2;

    @FXML
    private Label label1_3;

    @FXML
    private Label label1_4;

    @FXML
    private Label label1_5;

    @FXML
    private Label label1_6;
    @FXML
    private Label label1_7;
    @FXML
    private ImageView mancala2;

    @FXML
    private ImageView mancala1;

    Image startCup = new Image("Resources/Pictures/cupstart.png");
    Image mancalaImage_1 = new Image("Resources/Pictures/mancala1.png");
    Image mancalaImage_2 = new Image("Resources/Pictures/mancala2.png");
    private static Cup temp = new Cup(0, 0);
    private Cup head = null;
    private Cup tail = null;
    private static Game currentGame;
    private static ArrayList<Cup> cupArrayList = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * this method add a node 'Cup' to the circular linked list.
     *
     * @param amountOfStones - this is the amount of stones initially in a cup
     * @param ID             - this is the id of the cup, to be used when traversing through the cups
     *                       layout is like below, mancala1 = cup7 and mancala2 = cup14
     *                       the number after cup is also equal to the ID.
     *                       <p>
     *                       mancala2    cup13  cup12   cup11   cup10   cup9    cup8
     *                       cup1   cup2    cup3    cup4    cup5    cup6    mancala1
     */
    public void addCup(int amountOfStones, int ID) {
        Cup newCup = new Cup(amountOfStones, ID);
        cupArrayList.add(newCup);
        if (head == null) {
            head = newCup;
        } else {
            tail.nextCup = newCup;
        }

        tail = newCup;
        tail.nextCup = head;
    }

    /**
     * this methods finds a cup by its given ID
     *
     * @param findID - the id to search for
     * @return - returns the cup of the id searched for
     */
    public Cup containsCup(int findID) {
        Cup currentCup = head;

        if (head == null) {
            return null;
        } else {
            do {
                if (currentCup.ID == findID) {
                    System.out.println(currentCup);
                    return currentCup;

                }
                currentCup = currentCup.nextCup;
            } while (currentCup != head);
            return null;
        }
    }


    /**
     * this is the method that we use as an "API" to use the helper methods below, to move stones from one cup.
     *
     * @param ID - this is the ID of the cup we want to move stones from, which is parsed into a method that return that cup when found.
     * TODO make movestones recieve NO PARAMS, instead switch case depending on the field pressed.
     */
    public void moveStones(int ID) {
        moveStonesHelper(currentGame.containsCup(ID));
    }

    /**
     * this method is a helper for the moveStones method. it initializes the temp cup
     * that is used in the recursive method, then it sets the start cup = temp cup, which is after recursion 0.
     *
     * @param cup this is the cup sent from moveStones method, the first cup we move the stones from
     */
    private void moveStonesHelper(Cup cup) {
        temp.amountOfStones = cup.amountOfStones;
        moveStonesRecursion(cup);
        cup.amountOfStones = temp.amountOfStones;
    }

    /**
     * this method does the recursive movements of stones until 0 stones in the first cup
     *
     * @param cup this is the cup sent from moveStonesHelper method, the first cup we move the stones from
     */
    private void moveStonesRecursion(Cup cup) {
        while (temp.amountOfStones.getValue() > 0) {

            temp.amountOfStones.set(temp.amountOfStones.getValue() - 1);
            cup.nextCup.amountOfStones.setValue(cup.nextCup.amountOfStones.getValue() + 1);
            System.out.println("cup: " + cup.nextCup + " amount: " + cup.nextCup.amountOfStones);
            moveStonesRecursion(cup.nextCup);

        }
    }
    /**
     * this methods creates a new object Game, adds cups and sets initial amount of stones in each cup.
     * also gives each cup an ID, updates currentgame to this game and sets databinding for cup values
     */
    public void newGame() {

        Game game = new Game();
        for (int i = 1; i < 15; i++) {
            if (i == 7 || i == 14) {
                game.addCup(0, i);
            } else {
                game.addCup(4, i);
            }
        }
        currentGame = game;

        cup1_1.setImage(startCup);
        cup1_2.setImage(startCup);
        cup1_3.setImage(startCup);
        cup1_4.setImage(startCup);
        cup1_5.setImage(startCup);
        cup1_6.setImage(startCup);
        cup2_1.setImage(startCup);
        cup2_2.setImage(startCup);
        cup2_3.setImage(startCup);
        cup2_4.setImage(startCup);
        cup2_5.setImage(startCup);
        cup2_6.setImage(startCup);

        mancala1.setImage(mancalaImage_1);
        mancala2.setImage(mancalaImage_2);

        for (Cup cup : cupArrayList) {
            switch (cup.ID) {
                case 1:
                    label1_1.textProperty().bind(cup.amountOfStones.asString());
                case 2:
                    label1_2.textProperty().bind(cup.amountOfStones.asString());
                case 3:
                    label1_3.textProperty().bind(cup.amountOfStones.asString());
                case 4:
                    label1_4.textProperty().bind(cup.amountOfStones.asString());
                case 5:
                    label1_5.textProperty().bind(cup.amountOfStones.asString());
                case 6:
                    label1_6.textProperty().bind(cup.amountOfStones.asString());
                case 7:
                    label1_7.textProperty().bind(cup.amountOfStones.asString());
                case 8:
                    label2_1.textProperty().bind(cup.amountOfStones.asString());
                case 9:
                    label2_2.textProperty().bind(cup.amountOfStones.asString());
                case 10:
                    label2_3.textProperty().bind(cup.amountOfStones.asString());
                case 11:
                    label2_4.textProperty().bind(cup.amountOfStones.asString());
                case 12:
                    label2_5.textProperty().bind(cup.amountOfStones.asString());
                case 13:
                    label2_6.textProperty().bind(cup.amountOfStones.asString());
                case 14:
                    label2_7.textProperty().bind(cup.amountOfStones.asString());
            }
        }

    }

    public void main(String[] args) {
        newGame();
    }

}
