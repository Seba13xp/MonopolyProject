import java.io.File;
import java.util.Scanner;

// TODO: 12/23/2016 need a fix for the input Scanner
/**
 * @author Sebastian Obacz  on 11/13/2016.
 * @version 1.0
 */
public class Board {
    private GameboardSquare[] monopolyBoard;
    private Player player1;
    private Player player2;
    public Board(GameboardSquare[] monopolyBoard) {
        this.monopolyBoard = monopolyBoard;
    }
    public Board(){
//        monopolyBoard = new GameboardSquare[40];
    }

    public void setupGameBoard(File propertySquares) throws Exception{
    	Scanner input1 = new Scanner(System.in);
        GameboardSquare a;
        while (input1.hasNextLine()){
            int index = 0;
            String property = input1.nextLine();
            String[] propertySqaure = property.split(",");
            // TODO: 11/15/2016 add other sqaure file some how
            switch (index){
                case 0:
                    a = new GameboardSquare("Go",0,0,0,0,0,0,0,0,0,200,0,0,0,null,false);
                    monopolyBoard[index++] = a;
                    break;
                case 2:
                    //community chest
                    a = new GameboardSquare("Community Chest",0,0,0,0,0,0,0,0,0,0,0,0,0,null,false);
                    monopolyBoard[index++] = a;
                    break;
                case 4:
                    //income tax
                    break;
                case 7:
                    //chance
                    a = new GameboardSquare("Chance",0,0,0,0,0,0,0,0,0,0,0,0,0,null,false);
                    monopolyBoard[index++] = a;
                    break;
                case 10:
                    //visit jail
                    a = new GameboardSquare("Just Visiting Jail",0,0,0,0,0,0,0,0,0,0,0,0,0,null,false);
                    monopolyBoard[index++] = a;
                    break;
                case 17:
                    //community chest
                    a = new GameboardSquare("Community Chest",0,0,0,0,0,0,0,0,0,0,0,0,0,null,false);
                    monopolyBoard[index++] = a;
                    break;
                case 20:
                    //free parking
                    a = new GameboardSquare("Free Parking",0,0,0,0,0,0,0,0,0,0,0,0,0,null,false);
                    monopolyBoard[index++] = a;
                    break;
                case 22:
                    //chance
                    a = new GameboardSquare("Chance",0,0,0,0,0,0,0,0,0,0,0,0,0,null,false);
                    monopolyBoard[index++] = a;
                    break;
                case 40:
                    //go to jail
                    a = new GameboardSquare("Go To Jail",0,0,0,0,0,0,0,0,0,0,0,0,0,null,false);
                    monopolyBoard[index++] = a;
                    break;
                case 43:
                    //community chest
                    a = new GameboardSquare("Community Chest",0,0,0,0,0,0,0,0,0,0,0,0,0,null,false);
                    monopolyBoard[index++] = a;
                    break;
                case 46:
                    ///chance
                    a = new GameboardSquare("Chance",0,0,0,0,0,0,0,0,0,0,0,0,0,null,false);
                    monopolyBoard[index++] = a;
                    break;
                case 48:
                    //luxury tax
                    break;
                default:
                    a = parseMethod(propertySqaure);
                    monopolyBoard[index++] = a;
                    break;
            }
        }
    }

    public GameboardSquare parseMethod(String[] propertySqaure) {
        String propertyName = propertySqaure[0];
        int value = Integer.parseInt(propertySqaure[1]);
        int rent = Integer.parseInt(propertySqaure[3]);
        int rent1 = Integer.parseInt(propertySqaure[4]);
        int rent2 = Integer.parseInt(propertySqaure[5]);
        int rent3 = Integer.parseInt(propertySqaure[6]);
        int rent4 = Integer.parseInt(propertySqaure[7]);
        int hotel = Integer.parseInt(propertySqaure[8]);
        int mortgage = Integer.parseInt(propertySqaure[9]);
        int houseCost = Integer.parseInt(propertySqaure[2]);
//        int hotelCost = Integer.parseInt(propertySqaure[2]);
        int moneyGive = Integer.parseInt(propertySqaure[10]);
        Player owner = null;
        GameboardSquare a = new GameboardSquare(propertyName,value,houseCost,rent,rent1,rent2,rent3,rent4,hotel,mortgage, moneyGive,0,0,0,owner, false);
        return a;
    }

    public GameboardSquare[] getMonopolyBoard() {
        return monopolyBoard;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player) {
        this.player1 = player;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setMonopolyBoard(GameboardSquare[] monopolyBoard) {
        this.monopolyBoard = monopolyBoard;
    }
}
