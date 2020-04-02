package GUI;

/**
 * @Author Robert Skaar
 * @Project Kalaha  -  https://github.com/robskaar
 * @Date 02-04-2020
 **/

public class GameController {

    CircularLinkedList circularLinkedList;

    public void moveStones(){
        circularLinkedList.moveStones();
    }

    public void newGame(){
        circularLinkedList = new CircularLinkedList();
    }
}
