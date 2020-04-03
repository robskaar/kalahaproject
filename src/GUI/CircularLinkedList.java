package GUI;

/**
 * @Author Robert Skaar
 * @Project Kalaha  -  https://github.com/robskaar
 * @Date 26-03-2020
 **/

import Domain.Node;
import Domain.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * this class Game is actually a circular linked list, and cup's are like the nodes, this class is also assigned as the controller.
 */
public class CircularLinkedList {

/*
 Open the below to see fields - i hate scrolling 100 lines of fields :)
 */

    //region Region of Fields

    //region FXML Fields
    @FXML private ImageView player1_ImageView1;
    @FXML private ImageView player1_ImageView2;
    @FXML private ImageView player1_ImageView3;
    @FXML private ImageView player1_ImageView4;
    @FXML private ImageView player1_ImageView5;
    @FXML private ImageView player1_ImageView6;
    @FXML private ImageView player1_ImageView7;
    @FXML private ImageView player2_ImageView1;
    @FXML private ImageView player2_ImageView2;
    @FXML private ImageView player2_ImageView3;
    @FXML private ImageView player2_ImageView4;
    @FXML private ImageView player2_ImageView5;
    @FXML private ImageView player2_ImageView6;
    @FXML private ImageView player2_ImageView7;

    @FXML private Label player1_Label1;
    @FXML private Label player1_Label2;
    @FXML private Label player1_Label3;
    @FXML private Label player1_Label4;
    @FXML private Label player1_Label5;
    @FXML private Label player1_Label6;
    @FXML private Label player1_Label7;
    @FXML private Label player2_Label1;
    @FXML private Label player2_Label2;
    @FXML private Label player2_Label3;
    @FXML private Label player2_Label4;
    @FXML private Label player2_Label5;
    @FXML private Label player2_Label6;
    @FXML private Label player2_Label7;
    @FXML private Label statusMessage;

    @FXML private TextField player1_NameField;
    @FXML private TextField player2_NameField;

    @FXML private BorderPane menuPane;

    @FXML private Button newGameButton;
    @FXML private Button rematchButton;
    //endregion

    //region IMAGE Fields
    private Image startCup = new Image("Resources/Pictures/cupstart.png");
    private Image mancalaImage = new Image("Resources/Pictures/mancala.png");
    //endregion

    //region GENERAL Fields
    private Node head = null;
    private Node tail = null;
    private Node nodeClicked;
    private Node currentNode;
    private ArrayList<Node> nodeArrayList = new ArrayList<>();
    private ArrayList<ImageView> imageViewArrayList = new ArrayList<ImageView>();
    private ArrayList<SimpleObjectProperty<Image>> imageArrayList = new ArrayList<>();
    private Player player1;
    private Player player2;
    //endregion

    //endregion


    @FXML
    public void initialize() {


        initializeImageArrayList();
        initializeImageViews();
        initializeNodes();
        initializeImageViews();
        bindNodesToProperties();

        for (int i = 1; i < 15; i++) {
            int ID = i;
            if (imageViewArrayList.get(i - 1).equals(imageViewArrayList.get(13)) || imageViewArrayList.get(i).equals(
                    imageViewArrayList.get(7))) {
                imageViewArrayList.get(i - 1).addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    nodeClicked = findNode(ID);
                    statusMessage.setText("Why would you empty the Mancala?");
                });
            }
            else {
                imageViewArrayList.get(i - 1).addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    nodeClicked = findNode(ID);
                    statusMessage.setText(null);
                    moveStones();
                });
            }
        }


    }

    //creates the players
    private void initializePlayers() {
        player1 = new Player(true, player1_NameField.getText());
        player2 = new Player(false, player2_NameField.getText());
    }


    //creates and adds nodes to the circular linked list
    private void initializeNodes() {
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
        nodeArrayList = new ArrayList<Node>() {{
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


    //adds images to image array
    private void initializeImageArrayList() {
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
    }

    //adds images to array, and sets the starting image
    private void initializeImageViews() {
        imageViewArrayList.add(player1_ImageView1);
        imageViewArrayList.add(player1_ImageView2);
        imageViewArrayList.add(player1_ImageView3);
        imageViewArrayList.add(player1_ImageView4);
        imageViewArrayList.add(player1_ImageView5);
        imageViewArrayList.add(player1_ImageView6);
        imageViewArrayList.add(player1_ImageView7);
        imageViewArrayList.add(player2_ImageView1);
        imageViewArrayList.add(player2_ImageView2);
        imageViewArrayList.add(player2_ImageView3);
        imageViewArrayList.add(player2_ImageView4);
        imageViewArrayList.add(player2_ImageView5);
        imageViewArrayList.add(player2_ImageView6);
        imageViewArrayList.add(player2_ImageView7);

        for (ImageView imageView : imageViewArrayList) {
            if (imageView.equals(player1_ImageView7) || imageView.equals(player2_ImageView7)) {
                imageView.setImage(mancalaImage);
            }
            else {
                imageView.imageProperty().setValue(startCup);
            }
        }
    }


    /**
     * Find a node based upon the ID it
     *
     * @param findID - the id of the node to find
     * @return - returns the node with the given ID
     */
    private Node findNode(int findID) {
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

    /**
     * moves the stones
     */
    private void moveStones() {

        currentNode = nodeClicked; // set the first node

        Timeline timeline = new Timeline();   // slows down so you see movement of game, also works as "recursion"
        timeline.setCycleCount(nodeClicked.numOfBeans.intValue());
        timeline.setAutoReverse(false);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(350), e -> {
            currentNode = currentNode.nextNode; // set next node for each cycle
            if (player1.getMyTurn()) {
                if (nodeClicked.ID > 0 && nodeClicked.ID < 7) { // if node clicked is player 1's nodes
                    if (currentNode.ID == 14) { // if node is mancala of opposite player
                        currentNode = currentNode.nextNode; // go to next
                    }
                    nodeClicked.numOfBeans.set(
                            nodeClicked.numOfBeans.getValue() - 1); // decrease value of selected node
                    currentNode.numOfBeans.setValue(
                            currentNode.numOfBeans.getValue() + 1); // increase value of next nodes
                }
            }
            else if (player2.getMyTurn()) {
                if (nodeClicked.ID > 7 && nodeClicked.ID < 14) {// if node clicked is player 2's nodes
                    System.out.println("2");
                    if (currentNode.ID == 7) { // if node is mancala of opposite player
                        currentNode = currentNode.nextNode; // go to next
                    }
                    nodeClicked.numOfBeans.set(nodeClicked.numOfBeans.getValue() - 1);// decrease value of selected node
                    currentNode.numOfBeans.setValue(
                            currentNode.numOfBeans.getValue() + 1);// increase value of next nodes
                }
            }
        }));
        timeline.play();
        timeline.setOnFinished(e -> {
            evaluateWhoPlay();
            endGame(didGameEnd());
        });
    }

    /**
     * evaluates what player should play next
     */
    private void evaluateWhoPlay() {
        if (player1.getMyTurn()) {
            if (currentNode.ID != 7) { //if last stone not placed in current players mancala
                statusMessage.setText("It's " + player2.getUserName() + "'s turn ");
                player1.setMyTurn(false);
                player2.setMyTurn(true);
                enableCups(); // disable and enables cups depending on who's turn it is
            }
            else {
                statusMessage.setText("Good Job " + player1.getUserName() + " - go again!");
            }
        }
        else if (player2.getMyTurn()) {
            if (currentNode.ID != 14) { //if last stone not placed in current players mancala
                statusMessage.setText("It's " + player1.getUserName() + "'s turn ");
                player1.setMyTurn(true);
                player2.setMyTurn(false);
                enableCups(); // disable and enables cups depending on who's turn it is
            }
            else {
                statusMessage.setText("Good Job " + player2.getUserName() + " - go again!");
            }
        }
    }

    /**
     * disable and enables cups depending on who's turn it is
     */
    private void enableCups() {
        if (player1.getMyTurn()) { // if player 1, disable player 2 and enable its own
            imageViewArrayList.get(0).setDisable(false);
            imageViewArrayList.get(1).setDisable(false);
            imageViewArrayList.get(2).setDisable(false);
            imageViewArrayList.get(3).setDisable(false);
            imageViewArrayList.get(4).setDisable(false);
            imageViewArrayList.get(5).setDisable(false);
            imageViewArrayList.get(7).setDisable(true);
            imageViewArrayList.get(8).setDisable(true);
            imageViewArrayList.get(9).setDisable(true);
            imageViewArrayList.get(10).setDisable(true);
            imageViewArrayList.get(11).setDisable(true);
            imageViewArrayList.get(12).setDisable(true);
        }
        else if (player2.getMyTurn()) { // if player 2, disable player 1 and enable its own
            imageViewArrayList.get(0).setDisable(true);
            imageViewArrayList.get(1).setDisable(true);
            imageViewArrayList.get(2).setDisable(true);
            imageViewArrayList.get(3).setDisable(true);
            imageViewArrayList.get(4).setDisable(true);
            imageViewArrayList.get(5).setDisable(true);
            imageViewArrayList.get(7).setDisable(false);
            imageViewArrayList.get(8).setDisable(false);
            imageViewArrayList.get(9).setDisable(false);
            imageViewArrayList.get(10).setDisable(false);
            imageViewArrayList.get(11).setDisable(false);
            imageViewArrayList.get(12).setDisable(false);
        }
    }

    /**
     * check if game is ended
     *
     * @return - returns true if game has ended, else false
     */
    private boolean didGameEnd() {
        if (nodeArrayList.get(0).numOfBeans.intValue() == 0 && nodeArrayList.get(
                1).numOfBeans.intValue() == 0 && nodeArrayList.get(
                2).numOfBeans.intValue() == 0 && nodeArrayList.get(
                3).numOfBeans.intValue() == 0 && nodeArrayList.get(
                4).numOfBeans.intValue() == 0 && nodeArrayList.get(
                5).numOfBeans.intValue() == 0) {
            return true;
        }
        else if (nodeArrayList.get(7).numOfBeans.intValue() == 0 && nodeArrayList.get(
                8).numOfBeans.intValue() == 0 && nodeArrayList.get(
                9).numOfBeans.intValue() == 0 && nodeArrayList.get(
                10).numOfBeans.intValue() == 0 && nodeArrayList.get(
                11).numOfBeans.intValue() == 0 && nodeArrayList.get(
                12).numOfBeans.intValue() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * this executes the game play ending, set status message to who win and let them play again
     *
     * @param didGameEnd - should know if game is ended or not to execute its content
     */
    private void endGame(Boolean didGameEnd) {
        if (didGameEnd) {
            for (Node node : nodeArrayList) {
                if (node.ID >= 0 && node.ID < 7) {
                    nodeArrayList.get(6).numOfBeans.setValue(
                            nodeArrayList.get(6).numOfBeans.intValue() + node.numOfBeans.intValue());
                    node.numOfBeans.setValue(0);
                }
                else if (node.ID > 7 && node.ID < 14) {
                    nodeArrayList.get(13).numOfBeans.setValue(
                            nodeArrayList.get(13).numOfBeans.intValue() + node.numOfBeans.intValue());
                    node.numOfBeans.setValue(0);
                }
            }
            if (nodeArrayList.get(6).numOfBeans.intValue() < nodeArrayList.get(13).numOfBeans.intValue()) {
                statusMessage.setText(player2.getUserName() + " has Won");
            }
            else {
                statusMessage.setText(player1.getUserName() + " has Won");
            }
            rematchButton.setVisible(true);
            newGameButton.setVisible(true);
        }
    }

    /**
     * if new game is clicked after an ended game, this is invoked
     */
    public void showNewGameMenu() {
        newGameButton.setVisible(false);
        rematchButton.setVisible(false);
        menuPane.setVisible(true);
    }

    /**
     * if you enter usernames (or not dont have to) you start a match with this method
     */
    public void startMatch() {
        for (Node node : nodeArrayList) {
            if (nodeArrayList.indexOf(node) == 6 || nodeArrayList.indexOf(node) == 13) {
                node.numOfBeans.setValue(0);
            }
            else {
                node.numOfBeans.setValue(6);
            }
        }
        initializePlayers();
        menuPane.setVisible(false);
        statusMessage.setText(null);
        newGameButton.setVisible(false);
        rematchButton.setVisible(false);
    }

    /**
     * adds listener and bindings too the nodes, so textfields, images, etc. update upon new score in a node
     */
    private void bindNodesToProperties() {
        for (Node node : nodeArrayList) {
            switch (node.ID) {
                case 1: {
                    player1_Label1.textProperty().bind(node.numOfBeans.asString());
                    node.numOfBeans.addListener(
                            (observable, oldValue, newValue) -> player1_ImageView1.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(player1_Label1.getText()))));
                }
                case 2: {
                    player1_Label2.textProperty().bind(node.numOfBeans.asString());
                    node.numOfBeans.addListener(
                            (observable, oldValue, newValue) -> player1_ImageView2.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(player1_Label2.getText()))));
                }
                case 3: {
                    player1_Label3.textProperty().bind(node.numOfBeans.asString());
                    node.numOfBeans.addListener(
                            (observable, oldValue, newValue) -> player1_ImageView3.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(player1_Label3.getText()))));
                }
                case 4: {
                    player1_Label4.textProperty().bind(node.numOfBeans.asString());
                    node.numOfBeans.addListener(
                            (observable, oldValue, newValue) -> player1_ImageView4.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(player1_Label4.getText()))));
                }
                case 5: {
                    player1_Label5.textProperty().bind(node.numOfBeans.asString());
                    node.numOfBeans.addListener(
                            (observable, oldValue, newValue) -> player1_ImageView5.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(player1_Label5.getText()))));
                }
                case 6: {
                    player1_Label6.textProperty().bind(node.numOfBeans.asString());
                    node.numOfBeans.addListener(
                            (observable, oldValue, newValue) -> player1_ImageView6.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(player1_Label6.getText()))));
                }
                case 7: {
                    player1_Label7.textProperty().bind(node.numOfBeans.asString());
                    //no listener here since mancala's dont need to update the image
                }
                case 8: {
                    player2_Label1.textProperty().bind(node.numOfBeans.asString());
                    node.numOfBeans.addListener(
                            (observable, oldValue, newValue) -> player2_ImageView1.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(player2_Label1.getText()))));
                }
                case 9: {
                    player2_Label2.textProperty().bind(node.numOfBeans.asString());
                    node.numOfBeans.addListener(
                            (observable, oldValue, newValue) -> player2_ImageView2.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(player2_Label2.getText()))));
                }
                case 10: {
                    player2_Label3.textProperty().bind(node.numOfBeans.asString());
                    node.numOfBeans.addListener(
                            (observable, oldValue, newValue) -> player2_ImageView3.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(player2_Label3.getText()))));
                }
                case 11: {
                    player2_Label4.textProperty().bind(node.numOfBeans.asString());
                    node.numOfBeans.addListener(
                            (observable, oldValue, newValue) -> player2_ImageView4.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(player2_Label4.getText()))));
                }
                case 12: {
                    player2_Label5.textProperty().bind(node.numOfBeans.asString());
                    node.numOfBeans.addListener(
                            (observable, oldValue, newValue) -> player2_ImageView5.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(player2_Label5.getText()))));
                }
                case 13: {
                    player2_Label6.textProperty().bind(node.numOfBeans.asString());
                    node.numOfBeans.addListener(
                            (observable, oldValue, newValue) -> player2_ImageView6.imageProperty().bind(
                                    imageArrayList.get(Integer.parseInt(player2_Label6.getText()))));
                }
                case 14: {
                    player2_Label7.textProperty().bind(node.numOfBeans.asString());
                    //no listener here since mancala's dont need to update the image
                }
            }
        }
    }

}
