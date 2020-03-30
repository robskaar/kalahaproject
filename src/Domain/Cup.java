package Domain;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @Author Robert Skaar
 * @Project Kalaha  -  https://github.com/robskaar
 * @Date 26-03-2020
 **/

public class Cup {

     public final int ID;
        public SimpleIntegerProperty amountOfStones;
        public Cup nextCup;

        public Cup(int amountOfStones, int ID) {
            this.amountOfStones = new SimpleIntegerProperty(amountOfStones);
            this.ID = ID;
        }
}
