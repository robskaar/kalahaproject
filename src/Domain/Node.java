package Domain;


import javafx.beans.property.SimpleIntegerProperty;


/**
 * @Author Robert Skaar
 * @Project Kalaha  -  https://github.com/robskaar
 * @Date 26-03-2020
 **/


/**
 * this is a node in the circular linked list / a cup in the game
 */
public class Node {

     public final int ID;
        public SimpleIntegerProperty numOfBeans;
        public Node nextNode;

        public Node(int numOfBeans, int ID) {
            this.numOfBeans = new SimpleIntegerProperty(numOfBeans);
            this.ID = ID;
        }




}
