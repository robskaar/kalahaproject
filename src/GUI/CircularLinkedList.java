package GUI;

/**
 * @Author Robert Skaar
 * @Project Kalaha  -  https://github.com/robskaar
 * @Date 26-03-2020
 **/

import Domain.Node;
import Domain.Player;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * this class Game is actually a circular linked list, and cup's are like the nodes, this class is also assigned as the controller.
 */
public class CircularLinkedList implements Initializable {

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
    @FXML private ImageView mancala2;
    @FXML private ImageView mancala1;
    @FXML private Label label1_1;
    @FXML private Label label1_2;
    @FXML private Label label1_3;
    @FXML private Label label1_4;
    @FXML private Label label1_5;
    @FXML private Label label1_6;
    @FXML private Label label1_7;
    @FXML private Label label2_7;
    @FXML private Label label2_6;
    @FXML private Label label2_5;
    @FXML private Label label2_4;
    @FXML private Label label2_3;
    @FXML private Label label2_2;
    @FXML private Label label2_1;

    @FXML private Label statusMessage;
    @FXML private TextField userOne;
    @FXML private TextField userTwo;
    @FXML private BorderPane newGamePane;
    @FXML private Button newGameButton;
    @FXML private Button rematchButton;

    Image startCup = new Image("Resources/Pictures/cupstart.png");
    Image mancalaImage_1 = new Image("Resources/Pictures/unavngivet1.png");
    Image mancalaImage_2 = new Image("Resources/Pictures/unavngivet1.png");

    private int noStones = 0;
    private static Node tempNode = new Node(0, 0);
    private Node head = null;
    private Node tail = null;
    private static Node nodeClicked;
    private  ArrayList<Node> nodeArrayList = new ArrayList<>();
    private  ArrayList<ImageView> imageViewArrayList = new ArrayList<ImageView>();
    private  ArrayList<SimpleObjectProperty<Image>> imageArrayList = new ArrayList<>();

    private Player player1;
    private Player player2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
            int ID = i;
            if (imageViewArrayList.get(i - 1).equals(imageViewArrayList.get(13)) || imageViewArrayList.get(i).equals(
                    imageViewArrayList.get(7))) {
                imageViewArrayList.get(i - 1).addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    nodeClicked = findCup(ID);
                    statusMessage.setText("Why would you empty the Mancala?");
                });
            }
            else {
                imageViewArrayList.get(i - 1).addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    nodeClicked = findCup(ID);
                    statusMessage.setText(null);
                        moveStones();
                });
            }
        }
    }


    /**
     * this methods finds a cup by its given ID
     *
     * @param findID - the id to search for
     * @return - returns the cup of the id searched for
     */
    public Node findCup(int findID) {
        Node currentNode = head;

        if (head == null) {
            return null;
        }
        else {
            do {
                if (currentNode.ID == findID) {
                    return currentNode;

                }
                currentNode = currentNode.nextNode;
            }
            while (currentNode != head);
            return null;
        }
    }


    public void nextPlayersTurn(Node node) {
        if (player1.getMyTurn()) {
            if (node.ID == 7) {

            }
            else {
                player1.setMyTurn(false);
                player2.setMyTurn(true);
            }
        }
        else {
            if (node.ID == 14) {

            }
            else {
                player1.setMyTurn(true);
                player2.setMyTurn(false);
            }
        }
    }

    /**
     * this method works as an "API" to the recursion method below.
     * start by getting the cup that is clicked
     * then it sets the start cup = temp cup, which is after recursion 0.
     */
    public void moveStones(){
        Node node = nodeClicked;
        tempNode.amountOfStones = node.amountOfStones;
        moveStonesRecursion(node);
        node.amountOfStones = tempNode.amountOfStones;
    }

    /**
     * this method does the recursive movements of stones until 0 stones in the first cup
     * TODO fix the next turn bullshit
     *
     * @param node this is the cup sent from moveStonesHelper method, the first cup we move the stones from
     */
    private void moveStonesRecursion(Node node){
        didGameEnd();
        while (tempNode.amountOfStones.getValue() > noStones) {
            if (player1.getMyTurn()) {
                if (nodeClicked.ID > 0 && nodeClicked.ID < 7) {
                    if (node.nextNode.ID == 14) {
                        tempNode.amountOfStones.set(tempNode.amountOfStones.getValue() - 1);
                        node.nextNode.nextNode.amountOfStones.setValue(
                                node.nextNode.nextNode.amountOfStones.getValue() + 1);
                        moveStonesRecursion(node.nextNode.nextNode);
                    }
                    else {
                        tempNode.amountOfStones.set(tempNode.amountOfStones.getValue() - 1);
                        node.nextNode.amountOfStones.setValue(node.nextNode.amountOfStones.getValue() + 1);
                        moveStonesRecursion(node.nextNode);
                    }
                    nextPlayersTurn(node);
                }
                else {
                    statusMessage.setText("It's " + player1.getUserName() + " Playing ");
                    break;
                }

            }
            else if (player2.getMyTurn()) {
                if (nodeClicked.ID > 7 && nodeClicked.ID < 14) {
                    if (node.nextNode.ID == 7) {
                        tempNode.amountOfStones.set(tempNode.amountOfStones.getValue() - 1);
                        node.nextNode.nextNode.amountOfStones.setValue(
                                node.nextNode.nextNode.amountOfStones.getValue() + 1);
                        moveStonesRecursion(node.nextNode.nextNode);
                    }
                    else {
                        tempNode.amountOfStones.set(tempNode.amountOfStones.getValue() - 1);
                        node.nextNode.amountOfStones.setValue(node.nextNode.amountOfStones.getValue() + 1);
                        moveStonesRecursion(node.nextNode);
                    }
                    nextPlayersTurn(node);
                }
                else {

                    statusMessage.setText("It's " + player2.getUserName() + " Playing ");
                    break;
                }
            }

        }

    }

    public void didGameEnd() {

        if (nodeArrayList.get(0).amountOfStones.intValue() == 0 && nodeArrayList.get(
                1).amountOfStones.intValue() == 0 && nodeArrayList.get(
                2).amountOfStones.intValue() == 0 && nodeArrayList.get(
                3).amountOfStones.intValue() == 0 && nodeArrayList.get(
                4).amountOfStones.intValue() == 0 && nodeArrayList.get(
                5).amountOfStones.intValue() == 0)
        {
            endGameScreen();
        }
        else if (nodeArrayList.get(7).amountOfStones.intValue() == 0 && nodeArrayList.get(
                8).amountOfStones.intValue() == 0 && nodeArrayList.get(
                9).amountOfStones.intValue() == 0 && nodeArrayList.get(
                10).amountOfStones.intValue() == 0 && nodeArrayList.get(
                11).amountOfStones.intValue() == 0 && nodeArrayList.get(
                12).amountOfStones.intValue() == 0)
        {
            endGameScreen();
        }



    }

    private void endGameScreen() {
        movetoMancala();
        if (nodeArrayList.get(6).amountOfStones.intValue() < nodeArrayList.get(13).amountOfStones.intValue()){
            statusMessage.setText(player2.getUserName() + " has Won");
        }
        else {
            statusMessage.setText(player1.getUserName() + " has Won");
        }
        rematchButton.setVisible(true);
        newGameButton.setVisible(true);
    }

    public void movetoMancala(){
        for (Node node : nodeArrayList) {
            if (node.ID >= 0 && node.ID < 7){
                nodeArrayList.get(6).amountOfStones.setValue(
                        nodeArrayList.get(6).amountOfStones.intValue() + node.amountOfStones.intValue());
                node.amountOfStones.setValue(0);
            }
            else if (node.ID > 7 && node.ID < 14){
                nodeArrayList.get(13).amountOfStones.setValue(
                        nodeArrayList.get(13).amountOfStones.intValue() + node.amountOfStones.intValue());
                node.amountOfStones.setValue(0);
            }
        }

    }

public void showMenu(){
        newGameButton.setVisible(false);
        rematchButton.setVisible(false);
        newGamePane.setVisible(true);
}
public void rematch(){
        newGame();
}


    public void generateNewPlayers() {
        player1 = new Player(true, userOne.getText());
        player2 = new Player(false, userTwo.getText());
    }

    public void generateNewCups() {
        Node node1 = new Node(4, 1);
        Node node2 = new Node(4, 2);
        Node node3 = new Node(4, 3);
        Node node4 = new Node(4, 4);
        Node node5 = new Node(4, 5);
        Node node6 = new Node(4, 6);
        Node node7 = new Node(0, 7);
        Node node8 = new Node(4, 8);
        Node node9 = new Node(4, 9);
        Node node10 = new Node(4, 10);
        Node node11 = new Node(4, 11);
        Node node12 = new Node(4, 12);
        Node node13 = new Node(4, 13);
        Node node14 = new Node(0, 14);
        ArrayList<Node> nodes = new ArrayList<Node>() {{
            add(node1);
            add(node2);
            add(node3);
            add(node4);
            add(node5);
            add(node6);
            add(node7);
            add(node8);
            add(node9);
            add(node10);
            add(node11);
            add(node12);
            add(node13);
            add(node14);
        }};
        nodeArrayList = nodes;
    }

    public void addCupsAsNodes() {
        for (Node node : nodeArrayList) {
            if (head == null) {
                head = node;
            }
            else {
                tail.nextNode = node;
            }

            tail = node;
            tail.nextNode = head;
        }
    }

    public void resetImageViews() {
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
    }

    public void bindCupsToProperties() {
        for (Node node : nodeArrayList) {
            switch (node.ID) {
                case 1: {
                    label1_1.textProperty().bind(node.amountOfStones.asString());
                    node.amountOfStones.addListener((observable, oldValue, newValue) -> cup1_1.imageProperty().bind(
                            imageArrayList.get(Integer.parseInt(label1_1.getText()))));
                }
                case 2: {
                    label1_2.textProperty().bind(node.amountOfStones.asString());
                    node.amountOfStones.addListener((observable, oldValue, newValue) -> cup1_2.imageProperty().bind(
                            imageArrayList.get(Integer.parseInt(label1_2.getText()))));
                }
                case 3: {
                    label1_3.textProperty().bind(node.amountOfStones.asString());
                    node.amountOfStones.addListener((observable, oldValue, newValue) -> cup1_3.imageProperty().bind(
                            imageArrayList.get(Integer.parseInt(label1_3.getText()))));
                }
                case 4: {
                    label1_4.textProperty().bind(node.amountOfStones.asString());
                    node.amountOfStones.addListener((observable, oldValue, newValue) -> cup1_4.imageProperty().bind(
                            imageArrayList.get(Integer.parseInt(label1_4.getText()))));
                }
                case 5: {
                    label1_5.textProperty().bind(node.amountOfStones.asString());
                    node.amountOfStones.addListener((observable, oldValue, newValue) -> cup1_5.imageProperty().bind(
                            imageArrayList.get(Integer.parseInt(label1_5.getText()))));
                }
                case 6: {
                    label1_6.textProperty().bind(node.amountOfStones.asString());
                    node.amountOfStones.addListener((observable, oldValue, newValue) -> cup1_6.imageProperty().bind(
                            imageArrayList.get(Integer.parseInt(label1_6.getText()))));
                }
                case 7: {
                    label1_7.textProperty().bind(node.amountOfStones.asString());
                    //no listener here since mancala's dont need to update the image
                }
                case 8: {
                    label2_1.textProperty().bind(node.amountOfStones.asString());
                    node.amountOfStones.addListener(
                            (observable, oldValue, newValue) -> cup2_1.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(label2_1.getText()))));
                }
                case 9: {
                    label2_2.textProperty().bind(node.amountOfStones.asString());
                    node.amountOfStones.addListener(
                            (observable, oldValue, newValue) -> cup2_2.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(label2_2.getText()))));
                }
                case 10: {
                    label2_3.textProperty().bind(node.amountOfStones.asString());
                    node.amountOfStones.addListener(
                            (observable, oldValue, newValue) -> cup2_3.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(label2_3.getText()))));
                }
                case 11: {
                    label2_4.textProperty().bind(node.amountOfStones.asString());
                    node.amountOfStones.addListener(
                            (observable, oldValue, newValue) -> cup2_4.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(label2_4.getText()))));
                }
                case 12: {
                    label2_5.textProperty().bind(node.amountOfStones.asString());
                    node.amountOfStones.addListener(
                            (observable, oldValue, newValue) -> cup2_5.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(label2_5.getText()))));
                }
                case 13: {
                    label2_6.textProperty().bind(node.amountOfStones.asString());
                    node.amountOfStones.addListener(
                            (observable, oldValue, newValue) -> cup2_6.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(label2_6.getText()))));
                }
                case 14: {
                    label2_7.textProperty().bind(node.amountOfStones.asString());
                    //no listener here since mancala's dont need to update the image
                }
            }
        }
    }

    public void hideNewGameMenu() {
        newGamePane.setVisible(false);
    }

    public void newGame() {
        generateNewCups();
        generateNewPlayers();
        addCupsAsNodes();
        resetImageViews();
        bindCupsToProperties();
        hideNewGameMenu();
    }
}
