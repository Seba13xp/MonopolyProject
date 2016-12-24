import java.util.Random;

/**
 * @author Sebastian Obacz  on 11/15/2016.
 * @version 1.0
 */
public class Player extends GameLogic {
    private int currentMoney;
    private int moveIndex;

    public Player(int currentMoney, int moveIndex) {
        this.moveIndex = moveIndex;
        this.currentMoney = currentMoney;
    }


    public void moves(Player player, int moves) {
        int a = player.getMoveIndex() + moves;
        if (a > 41) {
            int b = a - 40;
            player.setMoveIndex(b);
            if (player.getMoveIndex() != 0) {
                player.setcurrentMoney(player.getcurrentMoney() + 200);
            }
        } else {
            player.setMoveIndex(a);
        }
    }

    public void rollsDie(Dice die1, Dice die2) {
        int max = 6;
        int min = 1;
        //rolls the diecs and set the die resules
        //returnes the dies reslues //idk
        Random rand = new Random();
        int value = rand.nextInt(50);
//        This will give value from 0 to 49.
//        For 1 to 50: 
        die1.setDie(rand.nextInt((max - min) + 1) + min);
        die2.setDie(rand.nextInt((max - min) + 1) + min);
    }

    public int getcurrentMoney() {
        return currentMoney;
    }

    public void setcurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public int getMoveIndex() {
        return moveIndex;
    }

    public void setMoveIndex(int moveIndex) {
        this.moveIndex = moveIndex;
    }
}
