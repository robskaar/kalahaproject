package GUI;

/**
 * @Author Robert Skaar
 * @Project Kalaha  -  https://github.com/robskaar
 * @Date 26-03-2020
 **/

import Domain.Cup;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * this class Game is actually a circular linked list, and cup's are like the nodes, this class is also assigned as the controller.
 */
public class Game implements Initializable {

    @FXML private ImageView cup1_1;
    @FXML private ImageView cup1_2;
    @FXML private ImageView cup1_3;
    @FXML private ImageView cup1_4;
    @FXML private ImageView cup1_5;
    @FXML private ImageView cup1_6;
    @FXML private ImageView cup2_6;
    @FXML private ImageView cup2_5;
    @FXML private ImageView cup2_4;
    @FXML private ImageView cup2_3;
    @FXML private ImageView cup2_2;
    @FXML private ImageView cup2_1;
    @FXML private Label label2_7;
    @FXML private Label label2_6;
    @FXML private Label label2_5;
    @FXML private Label label2_4;
    @FXML private Label label2_3;
    @FXML private Label label2_2;
    @FXML private Label label2_1;
    @FXML private Label label1_1;
    @FXML private Label label1_2;
    @FXML private Label label1_3;
    @FXML private Label label1_4;
    @FXML private Label label1_5;
    @FXML private Label label1_6;
    @FXML private Label label1_7;
    @FXML private ImageView mancala2;
    @FXML private ImageView mancala1;
    @FXML private Label statusMessage;

    Image startCup = new Image("Resources/Pictures/cupstart.png");
    Image mancalaImage_1 = new Image("Resources/Pictures/unavngivet1.png");
    Image mancalaImage_2 = new Image("Resources/Pictures/unavngivet1.png");

    private int noStones = 0;
    private int mancala1Id = 7;
    private int mancala2Id = 14;
    private int mancalaStartStones = 0;
    private int cupStartStones = 4;
    private static Cup tempCup = new Cup(0, 0);
    private Cup head = null;
    private Cup tail = null;
    private static int IDclicked;
    private static Game currentGame;
    private static ArrayList<Cup> cupArrayList = new ArrayList<>();
    private static ArrayList<ImageView> imageViewArrayList = new ArrayList<ImageView>();
    private static ArrayList<SimpleObjectProperty<Image>> imageArrayList = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Cup cup1 = new Cup(4,4);
        Cup cup2 = new Cup(4,4);
        Cup cup3 = new Cup(4,4);
        Cup cup4 = new Cup(4,4);
        Cup cup5 = new Cup(4,4);
        Cup cup6 = new Cup(4,4);
        Cup mancala_1 = new Cup(0,4);
        Cup cup8 = new Cup(4,4);
        Cup cup9 = new Cup(4,4);
        Cup cup10 = new Cup(4,4);
        Cup cup11 = new Cup(4,4);
        Cup cup12 = new Cup(4,4);
        Cup cup13 = new Cup(4,4);
        Cup mancala_2 = new Cup(0,4);


        imageViewArrayList.add(cup1_1);
        imageViewArrayList.add(cup1_2);
        imageViewArrayList.add(cup1_3);
        imageViewArrayList.add(cup1_4);
        imageViewArrayList.add(cup1_5);
        imageViewArrayList.add(cup1_6);
        imageViewArrayList.add(mancala1);
        imageViewArrayList.add(cup2_1);
        imageViewArrayList.add(cup2_2);
        imageViewArrayList.add(cup2_3);
        imageViewArrayList.add(cup2_4);
        imageViewArrayList.add(cup2_5);
        imageViewArrayList.add(cup2_6);
        imageViewArrayList.add(mancala2);
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup0.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup1.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup2.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup3.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup4.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup5.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup6.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup7.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup8.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup9.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup10.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup11.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup12.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup13.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup14.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup15.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup16.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup17.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup18.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup19.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup20.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup21.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup22.png")));
        imageArrayList.add(new SimpleObjectProperty<>(new Image("Resources/Pictures/cup23.png")));

        for (int i = 1; i < 15; i++) {
            int id = i;
            if (id == 7 || id == 14) {
                imageViewArrayList.get(i - 1).addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    IDclicked = id;
                    statusMessage.setText("Why would you empty the coffee pot");
                });
            }
            else {
                imageViewArrayList.get(i - 1).addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    IDclicked = id;
                    statusMessage.setText(null);
                    moveStones();
                });
            }
        }
        newGame();
    }

    /**
     * this method add a node 'Cup' to the circular linked list.
     *
     * @param amountOfStones - this is the amount of stones initially in a cup
     * @param ID             - this is the id of the cup, to be used when traversing through the cups
     *                       layout is like below, mancala1 = cup7 and mancala2 = cup14
     *                       the number after cup is also equal to the ID of that cup.
     *                       <p>
     *                       mancala2    cup13  cup12   cup11   cup10   cup9    cup8
     *                       cup1   cup2    cup3    cup4    cup5    cup6    mancala1
     */
    public void addCup(int amountOfStones, int ID) {
        Cup newCup = new Cup(amountOfStones, ID);
        cupArrayList.add(newCup);
        if (head == null) {
            head = newCup;
        }
        else {
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
        }
        else {
            do {
                if (currentCup.ID == findID) {
                    System.out.println(currentCup);
                    return currentCup;

                }
                currentCup = currentCup.nextCup;
            }
            while (currentCup != head);
            return null;
        }
    }


    /**
     * this method works as an "API" to the recursion method below.
     * start by getting the cup that is clicked
     * then it sets the start cup = temp cup, which is after recursion 0.
     */
    public void moveStones() {
        Cup cup = currentGame.containsCup(IDclicked);
        tempCup.amountOfStones = cup.amountOfStones;
        moveStonesRecursion(cup);
        cup.amountOfStones = tempCup.amountOfStones;
    }

    /**
     * this method does the recursive movements of stones until 0 stones in the first cup
     *
     * @param cup this is the cup sent from moveStonesHelper method, the first cup we move the stones from
     */
    private void moveStonesRecursion(Cup cup) {
        while (tempCup.amountOfStones.getValue() > noStones) {
            tempCup.amountOfStones.set(tempCup.amountOfStones.getValue() - 1);
            if (IDclicked > 0 && IDclicked < 7) {
                if (cup.nextCup.ID == 14) {
                    cup.nextCup.nextCup.amountOfStones.setValue(cup.nextCup.nextCup.amountOfStones.getValue() + 1);
                    moveStonesRecursion(cup.nextCup.nextCup);
                }
                else {
                    if (cup.amountOfStones.intValue() == 1 && cup.nextCup.amountOfStones.intValue() == noStones) {
                        cup.nextCup.amountOfStones.setValue(cup.nextCup.amountOfStones.getValue() + 1);
                        switch (cup.ID) {
                            case 1:
                                containsCup(7).amountOfStones.set(cup.nextCup.amountOfStones.intValue()+containsCup(13).amountOfStones.intValue()+containsCup(7).amountOfStones.intValue());
                                cup.nextCup.amountOfStones.set(noStones);
                                containsCup(13).amountOfStones.set(noStones);
                            case 2:
                                containsCup(7).amountOfStones.set(cup.nextCup.amountOfStones.intValue()+containsCup(12).amountOfStones.intValue()+containsCup(7).amountOfStones.intValue());
                                cup.nextCup.amountOfStones.set(noStones);
                                containsCup(12).amountOfStones.set(noStones);
                            case 3:
                                containsCup(7).amountOfStones.set(cup.nextCup.amountOfStones.intValue()+containsCup(11).amountOfStones.intValue()+containsCup(7).amountOfStones.intValue());
                                cup.nextCup.amountOfStones.set(noStones);
                                containsCup(11).amountOfStones.set(noStones);
                            case 4:
                                containsCup(7).amountOfStones.set(cup.nextCup.amountOfStones.intValue()+containsCup(10).amountOfStones.intValue()+containsCup(7).amountOfStones.intValue());
                                cup.nextCup.amountOfStones.set(noStones);
                                containsCup(10).amountOfStones.set(noStones);
                            case 5:
                                containsCup(7).amountOfStones.set(cup.nextCup.amountOfStones.intValue()+containsCup(9).amountOfStones.intValue()+containsCup(7).amountOfStones.intValue());
                                cup.nextCup.amountOfStones.set(noStones);
                                containsCup(9).amountOfStones.set(noStones);
                            case 6:
                                containsCup(7).amountOfStones.set(cup.nextCup.amountOfStones.intValue()+containsCup(8).amountOfStones.intValue()+containsCup(7).amountOfStones.intValue());
                                cup.nextCup.amountOfStones.set(noStones);
                                containsCup(8).amountOfStones.set(noStones);
                        }
                    }
                    cup.nextCup.amountOfStones.setValue(cup.nextCup.amountOfStones.getValue() + 1);
                    moveStonesRecursion(cup.nextCup);


                }
            }
            else if (IDclicked > 7 && IDclicked < 14) {
                if (cup.nextCup.ID == 7) {
                    cup.nextCup.nextCup.amountOfStones.setValue(cup.nextCup.nextCup.amountOfStones.getValue() + 1);
                    moveStonesRecursion(cup.nextCup.nextCup);
                }
                else {
                    cup.nextCup.amountOfStones.setValue(cup.nextCup.amountOfStones.getValue() + 1);
                    moveStonesRecursion(cup.nextCup);
                }
            }

        }
    }

    /**
     * creates a new game and resets game states
     **/
    private void newGame() {
        //creates a new Circular linked list "game" and uses this instead of the last, which should be garbage collected
        Game game = new Game();

        //we start from 1, and include 14 to be used as ID's of the cups.
        for (int ID = 1; ID < 15; ID++) {
            if (ID == mancala1Id || ID == mancala2Id) {
                game.addCup(mancalaStartStones, ID); // adds Mancala's, 0 start stones and id 7 && 14
            }
            else {
                game.addCup(cupStartStones, ID); // adds cup's, 4 start stones and id 1..6 && 8..13
            }
        }

        //iterate through imageviews and set them to start states.
        for (ImageView imageView : imageViewArrayList) {
            if (imageView.equals(mancala1)) {
                imageView.setImage(mancalaImage_1);
            }
            else if (imageView.equals(mancala2)) {
                imageView.setImage(mancalaImage_2);
            }
            else {
                imageView.imageProperty().setValue(startCup);
            }

        }

        /*
        for each cup bind the score label to the amount of stones in it
        also add listener to stones and update the image of the cup depending on the stones in cup
        */
        for (Cup cup : cupArrayList) {
            switch (cup.ID) {
                case 1: {
                    label1_1.textProperty().bind(cup.amountOfStones.asString());
                    cup.amountOfStones.addListener((observable, oldValue, newValue) -> cup1_1.imageProperty().bind(
                            imageArrayList.get(Integer.parseInt(label1_1.getText()))));
                }
                case 2: {
                    label1_2.textProperty().bind(cup.amountOfStones.asString());
                    cup.amountOfStones.addListener((observable, oldValue, newValue) -> cup1_2.imageProperty().bind(
                            imageArrayList.get(Integer.parseInt(label1_2.getText()))));
                }
                case 3: {
                    label1_3.textProperty().bind(cup.amountOfStones.asString());
                    cup.amountOfStones.addListener((observable, oldValue, newValue) -> cup1_3.imageProperty().bind(
                            imageArrayList.get(Integer.parseInt(label1_3.getText()))));
                }
                case 4: {
                    label1_4.textProperty().bind(cup.amountOfStones.asString());
                    cup.amountOfStones.addListener((observable, oldValue, newValue) -> cup1_4.imageProperty().bind(
                            imageArrayList.get(Integer.parseInt(label1_4.getText()))));
                }
                case 5: {
                    label1_5.textProperty().bind(cup.amountOfStones.asString());
                    cup.amountOfStones.addListener((observable, oldValue, newValue) -> cup1_5.imageProperty().bind(
                            imageArrayList.get(Integer.parseInt(label1_5.getText()))));
                }
                case 6: {
                    label1_6.textProperty().bind(cup.amountOfStones.asString());
                    cup.amountOfStones.addListener((observable, oldValue, newValue) -> cup1_6.imageProperty().bind(
                            imageArrayList.get(Integer.parseInt(label1_6.getText()))));
                }
                case 7: {
                    label1_7.textProperty().bind(cup.amountOfStones.asString());
                    //no listener here since mancala's dont need to update the image
                }
                case 8: {
                    label2_1.textProperty().bind(cup.amountOfStones.asString());
                    cup.amountOfStones.addListener(
                            (observable, oldValue, newValue) -> cup2_1.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(label2_1.getText()))));
                }
                case 9: {
                    label2_2.textProperty().bind(cup.amountOfStones.asString());
                    cup.amountOfStones.addListener(
                            (observable, oldValue, newValue) -> cup2_2.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(label2_2.getText()))));
                }
                case 10: {
                    label2_3.textProperty().bind(cup.amountOfStones.asString());
                    cup.amountOfStones.addListener(
                            (observable, oldValue, newValue) -> cup2_3.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(label2_3.getText()))));
                }
                case 11: {
                    label2_4.textProperty().bind(cup.amountOfStones.asString());
                    cup.amountOfStones.addListener(
                            (observable, oldValue, newValue) -> cup2_4.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(label2_4.getText()))));
                }
                case 12: {
                    label2_5.textProperty().bind(cup.amountOfStones.asString());
                    cup.amountOfStones.addListener(
                            (observable, oldValue, newValue) -> cup2_5.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(label2_5.getText()))));
                }
                case 13: {
                    label2_6.textProperty().bind(cup.amountOfStones.asString());
                    cup.amountOfStones.addListener(
                            (observable, oldValue, newValue) -> cup2_6.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(label2_6.getText()))));
                }
                case 14: {
                    label2_7.textProperty().bind(cup.amountOfStones.asString());
                    //no listener here since mancala's dont need to update the image
                }
            }
        }


        /*
         *update currentGame variable, used in moveStones - so we are certain that the game we move in is the current
         *and not a game which haven't been garbage collected yet.
         */
        currentGame = game;
    }
}
