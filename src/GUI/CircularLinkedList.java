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
    private Image mancalaImage_1 = new Image("Resources/Pictures/unavngivet1.png");
    private Image mancalaImage_2 = new Image("Resources/Pictures/unavngivet1.png");
    //endregion

    //region GENERAL Fields
    private int noStones = 0;
    private Node tempNode = new Node(0, 0);
    private Node head = null;
    private Node tail = null;
    private Node nodeClicked;
    private ArrayList<Node> nodeArrayList = new ArrayList<>();
    private ArrayList<ImageView> imageViewArrayList = new ArrayList<ImageView>();
    private ArrayList<SimpleObjectProperty<Image>> imageArrayList = new ArrayList<>();
    private ArrayList<Label> labelArrayList = new ArrayList<>();
    private Player player1;
    private Player player2;
    //endregion

    //endregion


    @FXML
    public void initialize() {
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
        labelArrayList.add(player1_Label1);
        labelArrayList.add(player1_Label2);
        labelArrayList.add(player1_Label3);
        labelArrayList.add(player1_Label4);
        labelArrayList.add(player1_Label5);
        labelArrayList.add(player1_Label6);
        labelArrayList.add(player1_Label7);
        labelArrayList.add(player2_Label1);
        labelArrayList.add(player2_Label2);
        labelArrayList.add(player2_Label3);
        labelArrayList.add(player2_Label4);
        labelArrayList.add(player2_Label5);
        labelArrayList.add(player2_Label6);
        labelArrayList.add(player2_Label7);

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


        generateNewCups();
        addCupsAsNodes();
        resetImageViews();
        bindCupsToProperties();
    }


    /**
     * this methods finds a cup by its given ID
     *
     * @param findID - the id to search for
     * @return - returns the cup of the id searched for
     */
    public Node findNode(int findID) {
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
    public void moveStones() {
        Node node = nodeClicked;
        tempNode.numOfBeans = node.numOfBeans;
        moveStonesRecursion(node);
        node.numOfBeans = tempNode.numOfBeans;
    }

    /**
     * this method does the recursive movements of stones until 0 stones in the first cup
     * TODO fix the next turn bullshit
     *
     * @param node this is the cup sent from moveStonesHelper method, the first cup we move the stones from
     */
    private void moveStonesRecursion(Node node) {
        didGameEnd();
        while (tempNode.numOfBeans.getValue() > noStones) {
            if (player1.getMyTurn()) {
                if (nodeClicked.ID > 0 && nodeClicked.ID < 7) {
                    if (node.nextNode.ID == 14) {
                        tempNode.numOfBeans.set(tempNode.numOfBeans.getValue() - 1);
                        node.nextNode.nextNode.numOfBeans.setValue(node.nextNode.nextNode.numOfBeans.getValue() + 1);
                        moveStonesRecursion(node.nextNode.nextNode);
                    }
                    else {
                        tempNode.numOfBeans.set(tempNode.numOfBeans.getValue() - 1);
                        node.nextNode.numOfBeans.setValue(node.nextNode.numOfBeans.getValue() + 1);
                        moveStonesRecursion(node.nextNode);
                    }
                }
                else {
                    statusMessage.setText("It's " + player1.getUserName() + " Playing ");
                    break;
                }
                nextPlayersTurn(node);
            }
            else if (player2.getMyTurn()) {
                    if (nodeClicked.ID > 7 && nodeClicked.ID < 14) {
                        if (node.nextNode.ID == 7) {
                            tempNode.numOfBeans.set(tempNode.numOfBeans.getValue() - 1);
                            node.nextNode.nextNode.numOfBeans.setValue(node.nextNode.nextNode.numOfBeans.getValue() + 1);
                            moveStonesRecursion(node.nextNode.nextNode);
                        }
                        else {
                            tempNode.numOfBeans.set(tempNode.numOfBeans.getValue() - 1);
                            node.nextNode.numOfBeans.setValue(node.nextNode.numOfBeans.getValue() + 1);
                            moveStonesRecursion(node.nextNode);
                        }
                    }
                }
                else{

                    statusMessage.setText("It's " + player2.getUserName() + " Playing ");
                    break;
                }
            nextPlayersTurn(node);
            }
        }

    public void didGameEnd() {

        if (nodeArrayList.get(0).numOfBeans.intValue() == 0 && nodeArrayList.get(
                1).numOfBeans.intValue() == 0 && nodeArrayList.get(
                2).numOfBeans.intValue() == 0 && nodeArrayList.get(
                3).numOfBeans.intValue() == 0 && nodeArrayList.get(
                4).numOfBeans.intValue() == 0 && nodeArrayList.get(
                5).numOfBeans.intValue() == 0) {
            endGameScreen();
        }
        else if (nodeArrayList.get(7).numOfBeans.intValue() == 0 && nodeArrayList.get(
                8).numOfBeans.intValue() == 0 && nodeArrayList.get(
                9).numOfBeans.intValue() == 0 && nodeArrayList.get(
                10).numOfBeans.intValue() == 0 && nodeArrayList.get(
                11).numOfBeans.intValue() == 0 && nodeArrayList.get(
                12).numOfBeans.intValue() == 0) {
            endGameScreen();
        }


    }

    private void endGameScreen() {
        movetoMancala();
        if (nodeArrayList.get(6).numOfBeans.intValue() < nodeArrayList.get(13).numOfBeans.intValue()) {
            statusMessage.setText(player2.getUserName() + " has Won");
        }
        else {
            statusMessage.setText(player1.getUserName() + " has Won");
        }
        rematchButton.setVisible(true);
        newGameButton.setVisible(true);
    }

    public void movetoMancala() {
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

    }

    public void showMenu() {
        newGameButton.setVisible(false);
        rematchButton.setVisible(false);
        menuPane.setVisible(true);
    }

    public void startMatch() {
        for (Node node : nodeArrayList) {
            if (nodeArrayList.indexOf(node) == 6 || nodeArrayList.indexOf(node) == 13) {
                node.numOfBeans.setValue(0);
            }
            else {
                node.numOfBeans.setValue(6);
            }
        }
        generateNewPlayers();
        menuPane.setVisible(false);
        statusMessage.setText(null);
        newGameButton.setVisible(false);
        rematchButton.setVisible(false);
    }


    public void generateNewPlayers() {
        player1 = new Player(true, player1_NameField.getText());
        player2 = new Player(false, player2_NameField.getText());
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
            if (imageView.equals(player1_ImageView7)) {
                imageView.setImage(mancalaImage_1);
            }
            else if (imageView.equals(player2_ImageView7)) {
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
