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
    private int ID;
    private static Cup nextCup;
    private static Cup temp;
    private static Cup head = null;
    private static Cup tail = null;


    public static void addNode(int amountOfStones,int ID) {
        Cup cup = new Cup(amountOfStones, ID);

        if (head == null) {
            head = cup;
        } else {
            tail.nextCup = cup;
        }

        tail = cup;
        tail.nextCup = head;
    }


    public Cup(int amountOfStones, int ID) {
        this.amountOfStones = amountOfStones;
        this.ID = ID;
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

        addNode(4,1);
        addNode(4,2);
        addNode(4,3);
        addNode(4,4);
        addNode(4,5);
        addNode(4,6);
        addNode(0,7);
        addNode(4,8);
        addNode(4,9);
        addNode(4,10);
        addNode(4,11);
        addNode(4,12);
        addNode(4,13);
        addNode(0,14);

       // moveStones(cup2_3);

    }


}
