package goosegame.cells;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import goosegame.cells.*;
import goosegame.Player;
/**
  * A test class for the WaitCell in the package goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020  */
public class WaitCellTest{
	//Instance variables :
	/*A waitCell used for tests.*/
	private WaitCell waitCell;
	/*A player used for tests.*/
	private Player player;

	//Executed before each test :
	@Before
	public void before() {
		this.waitCell =new WaitCell(7,3);
		this.player = new Player("Timoléon");
		this.waitCell.setPlayer(this.player);
		this.player.setCell(this.waitCell);
	}

	//Test setter and getter for a player : This method is independant of before method.
	@Test
	public void setAndGetPlayerWaitCellTest() {
		WaitCell localCell = new WaitCell(5,2);
		Player localPlayer = new Player("Frodon");
		assertEquals(null,localCell.getPlayer());
		localCell.setPlayer(localPlayer);
		assertEquals(localPlayer,localCell.getPlayer());
	}

	//Test the exception of the setPlayer method.
	@Test(expected = IllegalArgumentException.class)
	public void setPlayerExceptionWaitCellTest(){
			this.waitCell.setPlayer(null);
	}

	//Test for getter on the cell index.
	@Test
	public void getIndexWaitCellTest(){
		assertEquals(7,this.waitCell.getIndex());
	}


	//Test for removing the player in the cell.
	@Test
	public void removePlayerWaitCellTest() {
		assertEquals(this.player,this.waitCell.getPlayer());
		this.waitCell.removePlayer();
		assertEquals(this.waitCell.getPlayer(),null);
	}

	//Test to know if the cell is busy.
	@Test
	public void isBusyWaitCellTest(){
		assertTrue(this.waitCell.isBusy());
		this.waitCell.removePlayer();
		assertFalse(this.waitCell.isBusy());
	}

	//Test for canLeave : Here the player must wait 2 rounds.
	@Test
	public void canLeaveWaitCellTest() {
		assertFalse(this.waitCell.canLeave());
		assertFalse(this.waitCell.canLeave());
		assertFalse(this.waitCell.canLeave());
		assertTrue(this.waitCell.canLeave());
	}

	//Test to check the good string representation of the WaitCell with the toString method :
	@Test
	public void testToStringWaitCell(){
		assertEquals("7 (waiting for 3 turns)",this.waitCell.toString());
	}

	//Test for the equality between cells :
	@Test
	public void testEquals() {
		StartCell localStartCell =new StartCell();
		BasicCell localBasicCell =new BasicCell(7);
		WaitCell localWaitCell =new WaitCell(3,3);
		TrapCell localTrapCell = new TrapCell(7);
		JumpCell localJumpCell = new JumpCell(7,1);
		GooseCell localGooseCell = new GooseCell(7);
		assertTrue(this.waitCell.equals(new WaitCell(7,3)));
		assertFalse(localWaitCell.equals(this.waitCell));
		assertFalse(this.waitCell.equals(localBasicCell));
		assertFalse(localStartCell.equals(this.waitCell));
		assertFalse(localTrapCell.equals(this.waitCell));
		assertFalse(localGooseCell.equals(this.waitCell));
		assertFalse(localJumpCell.equals(this.waitCell));
	}

	// ---For test execution----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(WaitCellTest.class);
	}

}
