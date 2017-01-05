import student.TestCase;

/**
 * @author Sebastian Obacz on 12/23/2016.
 * @version 1.0
 */
public class GameLogicTest extends TestCase {
    public void testBuyHotel() throws Exception {
        Player player = new Player(1000, 0);
        GameboardSquare property = new GameboardSquare("Seb", 100, 50, 50, 100, 150, 200, 250, 300, 200, 300, 4, 4, 0, player, false);
        GameboardSquare[] gameboard = new GameboardSquare[1];
        gameboard[0] = property;
        GameLogic game = new GameLogic(gameboard);
        Board board = new Board(gameboard);
        board.setMonopolyBoard(gameboard);
        setSystemIn("1\n"); //user input
        boolean result = game.buyHotel(player, 0);
        boolean expected = true;
        assertEquals(expected, result);
    }

    public void testBuyHouse() throws Exception {
        Player player = new Player(1000, 0);
        GameboardSquare property = new GameboardSquare("Seb", 100, 50, 50, 100, 150, 200, 250, 300, 200, 0, 3, 0, 0, player, false);
        GameboardSquare[] gameboard = new GameboardSquare[1];
        gameboard[0] = property;
        GameLogic game = new GameLogic(gameboard);
        Board board = new Board(gameboard);
        board.setMonopolyBoard(gameboard);
        setSystemIn("10\n" + "4\n" + "4\n" + "3\n" + "2\n" + "1\n"); //user input
        boolean result = game.buyHouse(player, 0);
        boolean expected = true;
        assertEquals(expected, result);
    }

}