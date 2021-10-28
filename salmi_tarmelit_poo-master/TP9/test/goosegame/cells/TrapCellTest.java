package goosegame.cells;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import goosegame.cells.*;
import goosegame.Player;
/**
  * A test class for the TrapCell in the package goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class TrapCellTest{
	//Instance variables :
	/*A TrapCell used for tests.*/
	private TrapCell trapCell;
	/*A player used for tests.*/
	private Player player;

	//Executed before each test :
	@Before
	public void before(){
		this.trapCell =new TrapCell(7);
		this.player = new Player("Timoléon");
		this.trapCell.setPlayer(this.player);
		this.player.setCell(this.trapCell);
	}

	//Test setter and getter for a player : This method is independant of before method.
	@Test
	public void setAndGetPlayerTrapCellTest() {
		TrapCell localCell = new TrapCell(5);
		Player localPlayer = new Player("Frodon");
		assertEquals(null,localCell.getPlayer());
		localCell.setPlayer(localPlayer);
		assertEquals(localPlayer,localCell.getPlayer());
	}

	//Test the exception of the setPlayer method.
	@Test(expected = IllegalArgumentException.class)
	public void setPlayerExceptionTrapCellTest(){
			this.trapCell.setPlayer(null);
	}

	//Test for getter on the cell index.
	@Test
	public void getIndexTrapCellTest(){
		assertEquals(7,this.trapCell.getIndex());
	}


	//Test for removing the player in the cell.
	@Test
	public void removePlayerTrapCellTest() {
		assertEquals(this.player,this.trapCell.getPlayer());
		this.trapCell.removePlayer();
		assertEquals(this.trapCell.getPlayer(),null);
	}

	//Test to know if the cell is busy.
	@Test
	public void isBusyTrapCellTest(){
		assertTrue(this.trapCell.isBusy());
		this.trapCell.removePlayer();
		assertFalse(this.trapCell.isBusy());
	}

	//Test for canLeave :
	@Test
	public void canLeaveTrapCellTest() {
		assertFalse(this.trapCell.canLeave());
	}

	//Test to check the good string representation of the TrapCell with the toString method :
	@Test
	public void testToStringTrapCell(){
		assertEquals("7 (trap) ",this.trapCell.toString());
	}

	//Test of the TrapCell action :
	@Test
	public void actionTestTrapCell() {
		assertEquals(7,this.trapCell.action(this.player.twoDiceThrow()));
	}

	//Test for the equality between cells :
	@Test
	public void testEquals() {
		StartCell localStartCell =new StartCell();
		BasicCell localBasicCell =new BasicCell(7);
		WaitCell localWaitCell =new WaitCell(7,2);
		TrapCell localTrapCell = new TrapCell(8);
		JumpCell localJumpCell = new JumpCell(7,1);
		GooseCell localGooseCell = new GooseCell(7);
		assertTrue(this.trapCell.equals(new TrapCell(7)));
		assertFalse(localStartCell.equals(this.trapCell));
		assertFalse(this.trapCell.equals(localBasicCell));
		assertFalse(localWaitCell.equals(this.trapCell));
		assertFalse(localTrapCell.equals(this.trapCell));
		assertFalse(localJumpCell.equals(this.trapCell));
		assertFalse(localGooseCell.equals(this.trapCell));
	}

	// ---For test execution----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(TrapCellTest.class);
	}

}
