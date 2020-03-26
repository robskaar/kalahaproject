package Domain;

/**
 * @Author Robert Skaar
 * @Project Kalaha  -  https://github.com/robskaar
 * @Date 26-03-2020
 **/

/**
 * this class Game is actually a circular linked list, and cup's are like the nodes
 */
public class Game {

    private static Cup temp = new Cup(0,0);
    private Cup head = null;
    private Cup tail = null;
    private static Game currentGame;


    /**
     * this method add a node 'Cup' to the circular linked list.
     * @param amountOfStones - this is the amount of stones initially in a cup
     * @param ID - this is the id of the cup, to be used when traversing through the cups
     *           layout is like below, mancala1 = cup7 and mancala2 = cup14
     *           the number after cup is also equal to the ID.
     *
     *          mancala2    cup13  cup12   cup11   cup10   cup9    cup8
     *                      cup1   cup2    cup3    cup4    cup5    cup6    mancala1
     */
    public void addCup(int amountOfStones,int ID) {
        Cup newCup = new Cup(amountOfStones,ID);

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
     * @param ID - this is the ID of the cup we want to move stones from, which is parsed into a method that return that cup when found.
     */
    public static void moveStones(int ID){
        moveStonesHelper(currentGame.containsCup(1));
    }

    /**
     * this method is a helper for the moveStones method. it initializes the temp cup
     * that is used in the recursive method, then it sets the start cup = temp cup, which is after recursion 0.
     * @param cup this is the cup sent from moveStones method, the first cup we move the stones from
     */
    private static void moveStonesHelper(Cup cup) {
        temp.amountOfStones = cup.amountOfStones;
        moveStonesRecursion(cup);
        cup.amountOfStones = temp.amountOfStones;
    }

    /**
     * this method does the recursive movements of stones until 0 stones in the first cup
     * @param cup this is the cup sent from moveStonesHelper method, the first cup we move the stones from
     */
    private static void moveStonesRecursion(Cup cup) {
        while (temp.amountOfStones > 0) {
            temp.amountOfStones--;
            cup.nextCup.amountOfStones++;
            System.out.println("cup: "+cup.nextCup + " amount: "+cup.nextCup.amountOfStones);
            moveStonesRecursion(cup.nextCup);
        }
    }

    /**
     * this methods creates a new object Game, adds cups and sets initial amount of stones in each cup.
     * also gives each cup an ID and updates currentgame to this game
     */
   public static void newGame(){
        Game game = new Game();
       game.addCup(4,1);
       game.addCup(4,2);
       game.addCup(4,3);
       game.addCup(4,4);
       game.addCup(4,5);
       game.addCup(4,6);
       game.addCup(0,7);
       game.addCup(4,8);
       game.addCup(4,9);
       game.addCup(4,10);
       game.addCup(4,11);
       game.addCup(4,12);
       game.addCup(4,13);
       game.addCup(0,14);
       currentGame = game;

    }

    public static void main(String[] args) {
        newGame();
        moveStones(1);
    }

}
