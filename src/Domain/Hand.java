package Domain;


import javafx.scene.image.Image;


public class Hand {

    public static Image selected = new Image("Resources/Pictures/selected_hand.png");
    public static Image selecting = new Image("Resources/Pictures/selecting_hand.png");
    public static Image handState = selecting;


    public static Image changeHand(){
        if (handState == selecting){
            handState = selected;
        }
        else {
            handState = selecting;
        }
        return handState;
    }
}
