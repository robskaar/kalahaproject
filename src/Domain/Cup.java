package Domain;


import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author Robert Skaar
 * @Project Kalaha  -  https://github.com/robskaar
 * @Date 25-03-2020
 **/


public class Cup {
    private int amountOfStones;
    private static Cup nextCup;
    private static Cup temp;
    private static Cup head = null;
    private static Cup tail = null;


    public static void addNode(int amountOfStones) {
        Cup cup = new Cup(amountOfStones);

        if (head == null) {
            head = cup;
        } else {
            tail.nextCup = cup;
        }

        tail = cup;
        tail.nextCup = head;
    }


    public Cup(int amountOfStones) {
        this.amountOfStones = amountOfStones;
    }

    // Function to insert at the end
    public static void moveStones(Cup cup) {
        temp.amountOfStones = cup.amountOfStones;
        moveStones(cup, 1);
        cup.amountOfStones = temp.amountOfStones;

    }

    public void traverseList() {
        Cup currentCup = head;

        if (head != null) {
            do {
                currentCup = nextCup;
            } while (currentCup != head);
        }
    }

    private static void moveStones(Cup cup, int j) {
         while (temp.amountOfStones > 0) {
              temp.amountOfStones--;
        cup.nextCup.amountOfStones++;
        moveStones(cup.nextCup, 1);
           }
    }


    public static void main(String[] args) {

        addNode(4);
        addNode(4);
        addNode(4);
        addNode(4);
        addNode(4);
        addNode(4);
        addNode(0);
        addNode(4);
        addNode(4);
        addNode(4);
        addNode(4);
        addNode(4);
        addNode(4);
        addNode(0);

       // moveStones(cup2_3);

    }


}
