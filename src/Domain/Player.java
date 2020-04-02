package Domain;

/**
 * @Author Robert Skaar
 * @Project Kalaha  -  https://github.com/robskaar
 * @Date 01-04-2020
 **/

public class Player {

    private String username;
    private Boolean myTurn;

    public Player(Boolean myTurn, String username){
        this.myTurn = myTurn;
        this.username = username;
    }

    public boolean getMyTurn(){
        return this.myTurn;
    }

    public void setMyTurn(Boolean MyTurn){
        this.myTurn = MyTurn;
    }

    public String getUserName(){
        return this.username;
    }
}
