package goosegame;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import goosegame.boards.ClassicalBoard;
import goosegame.Board;
import goosegame.Player;
/**
  * A test class for Game in the package goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class GameTest{
	//Instance variables :
	/*A board used for tests.*/
	private Board gameBoard;
	/*A game for tests.*/
	private Game goosegame;
	/*First player used for tests.*/
	private Player player1;
	/*Second player used for tests.*/
	private Player player2;

	//Executed before each test :
	@Before
	public void before() {
		this.gameBoard = new ClassicalBoard();
		this.goosegame=new Game(this.gameBoard);
		this.player1 = new Player("Timoléon");
		this.player2 = new Player("Frodon");
	}

	//We can test the play method because we cannot know the player who will win the game.

	//Test the exception of the play method.
	@Test(expected = goosegame.InvalidNumberPlayerException.class)
	public void playTestKO()throws InvalidNumberPlayerException{
			this.goosegame.play();
	}

	@Test
	public void addPlayerTestOK(){
		this.goosegame.addPlayer(player1);
		this.goosegame.addPlayer(player2);
	}

	//Test the exception of the addPlayer method.
	@Test(expected = IllegalArgumentException.class)
	public void addPlayerTestKO()throws IllegalArgumentException{
		this.goosegame.addPlayer(null);
	}

	// ---For test execution----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(GameTest.class);
	}
}
