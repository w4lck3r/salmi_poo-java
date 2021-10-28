package goosegame;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import goosegame.cells.BasicCell;
import goosegame.Player;
/**
  * A test class for the Player in the package goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class PlayerTest{
	//Instance variables :
	/*A Cell used for tests.*/
	private BasicCell cell;
	/*First player used for tests.*/
	private Player player1;
	/*Second player used for tests.*/
	private Player player2;

	//Executed before each test :
	@Before
	public void before() {
		this.cell = new BasicCell(7);
		this.player1 = new Player("Timoléon");
		this.player2 = new Player("Frodon");
	}

	//Test setter and getter methods.
	@Test
	public void getAndSetPlayerTest() {
		assertEquals(null,player1.getCell());
		this.player1.setCell(this.cell);
		assertEquals(this.cell,this.player1.getCell());
	}

	//Test the second Player constructor :
	@Test
	public void secondConstructorTest(){
		Cell localCell = new BasicCell(7);
		Player playerC = new Player("Gandalf",localCell);
		assertEquals(localCell,playerC.getCell());
	}

	//Test for TwoDiceThrow method : A dice has 6 faces then 2 dice equal 36 possibilities, it our pattern test
	@Test
	public void TwoDiceThrowTest() {
		int i=0;
		while(i<36){
			int diceThrow = this.player1.twoDiceThrow();
			assertTrue(2<=diceThrow && diceThrow<=12);
			i++;
		}
	}

	//Test to check the good string representation of the Player with the toString method :
	@Test
	public void testToStringPlayer(){
		assertEquals(this.player1.toString(),"Timoléon");
		assertEquals(this.player2.toString(),"Frodon");
	}

	// ---For test execution----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(PlayerTest.class);
	}
}
