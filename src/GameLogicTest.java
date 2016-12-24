import junit.framework.TestCase;

/**
 * @author Sebastian Obacz on 12/23/2016.
 * @version 1.0
 */
public class GameLogicTest extends TestCase {
    public void testBuyHouse() throws Exception {
        Player player = new Player(1000,0);
        GameboardSquare property = new GameboardSquare("Seb", 100,50,50,100,150,200,250,300,200,0,3,0,player,false);
        GameboardSquare[] gameboard = new GameboardSquare[1];
        gameboard[0] = property;
        Board board = new Board(gameboard);
        GameLogic game = new GameLogic(gameboard);
        game.buyHouse(player,0);
    }

}