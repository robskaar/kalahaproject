package Domain;

/**
 * @Author Robert Skaar
 * @Project Kalaha  -  https://github.com/robskaar
 * @Date 26-03-2020
 **/

public class Cup {

        final int ID;
        int amountOfStones;
        Cup nextCup;

        public Cup(int amountOfStones, int ID) {
            this.amountOfStones = amountOfStones;
            this.ID = ID;
        }
}
