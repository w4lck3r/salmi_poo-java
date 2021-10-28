package goosegame.cells;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import goosegame.cells.*;
import goosegame.Player;
/**
  * A test class for the GooseCell in the package goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class GooseCellTest{
	//Instance variables :
	/*A GooseCell used for tests.*/
	private GooseCell gooseCell;
	/*A player used for tests.*/
	private Player player;

	//Executed before each test :
	@Before
	public void before() {
		this.gooseCell =new GooseCell(7);
		this.player = new Player("Timoléon");
		this.gooseCell.setPlayer(this.player);
		this.player.setCell(this.gooseCell);
	}

	//Test setter and getter for a player : This method is independant of before method.
	@Test
	public void setAndGetPlayerGooseCellTest() {
		GooseCell localCell = new GooseCell(5);
		Player localPlayer = new Player("Frodon");
		assertEquals(null,localCell.getPlayer());
		localCell.setPlayer(localPlayer);
		assertEquals(localPlayer,localCell.getPlayer());
	}

	//Test the exception of the setPlayer method.
	@Test(expected = IllegalArgumentException.class)
	public void setPlayerExceptionGooseCellTest(){
			this.gooseCell.setPlayer(null);
	}

	//Test for getter on the cell index.
	@Test
	public void getIndexGooseCellTest(){
		assertEquals(7,this.gooseCell.getIndex());
	}


	//Test for removing the player in the cell.
	@Test
	public void removePlayerGooseCellTest() {
		assertEquals(this.player,this.gooseCell.getPlayer());
		this.gooseCell.removePlayer();
		assertEquals(this.gooseCell.getPlayer(),null);
	}

	//Test to know if the cell is busy.
	@Test
	public void isBusyGooseCellTest(){
		assertTrue(this.gooseCell.isBusy());
		this.gooseCell.removePlayer();
		assertFalse(this.gooseCell.isBusy());
	}

	//Test for canLeave :
	@Test
	public void canLeaveGooseCellTest() {
		assertTrue(this.gooseCell.canLeave());
	}

	//Test to check the good string representation of the GooseCell with the toString method :
	@Test
	public void testToStringGooseCell(){
		assertEquals("7 (goose) and jumps to ",this.gooseCell.toString());
	}

	//Test of the GooseCell action :
	@Test
	public void actionTestGooseCell() {
		int diceThrow =this.player.twoDiceThrow();
		assertEquals(this.gooseCell.getIndex()+diceThrow,this.gooseCell.action(diceThrow));
	}

	//Test for the equality between cells :
	@Test
	public void testEquals() {
		StartCell localStartCell =new StartCell();
		BasicCell localBasicCell =new BasicCell(7);
		WaitCell localWaitCell =new WaitCell(7,2);
		TrapCell localTrapCell = new TrapCell(8);
		JumpCell localJumpCell = new JumpCell(7,1);
		GooseCell localGooseCell = new GooseCell(8);
		assertTrue(this.gooseCell.equals(new GooseCell(7)));
		assertFalse(localStartCell.equals(this.gooseCell));
		assertFalse(this.gooseCell.equals(localBasicCell));
		assertFalse(localWaitCell.equals(this.gooseCell));
		assertFalse(localTrapCell.equals(this.gooseCell));
		assertFalse(localJumpCell.equals(this.gooseCell));
		assertFalse(localGooseCell.equals(this.gooseCell));
	}

	// ---For test execution----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(GooseCellTest.class);
	}

}
