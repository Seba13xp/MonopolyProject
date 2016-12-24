import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author Sebastian Obacz  on 11/15/2016.
 * @version 1.0
 */
public class PlayerTest extends TestCase {
    public void testMoves() throws Exception {
        Player player = new Player(10,38);
        Dice die1 = new Dice();
        Dice die2 = new Dice();
        player.rollsDie(die1, die2);
        int a = die1.getDie();
        int b = die2.getDie();
        System.out.println(a);
        System.out.println(b);
        player.moves(player, a + b);
        System.out.println(player.getcurrentMoney());
    }

    @Test
    public void testRollsDie() throws Exception {
        Player player = new Player(10,0);
        Dice die1 = new Dice();
        Dice die2 = new Dice();
        player.rollsDie(die1, die2);
        int a = die1.getDie();
        int b = die2.getDie();
        System.out.println(a);
        System.out.println(b);

    }

}