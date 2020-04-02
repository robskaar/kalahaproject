package Domain;


import javafx.beans.property.SimpleIntegerProperty;


/**
 * @Author Robert Skaar
 * @Project Kalaha  -  https://github.com/robskaar
 * @Date 26-03-2020
 **/

public class Node {

     public final int ID;
        public SimpleIntegerProperty amountOfStones;
        public Node nextNode;

        public Node(int amountOfStones, int ID) {
            this.amountOfStones = new SimpleIntegerProperty(amountOfStones);
            this.ID = ID;
        }




}
