package goosegame.cells;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import goosegame.cells.*;
import goosegame.Player;
/**
  * A test class for the StartCell in the package goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class StartCellTest{
	//Instance variables :
	/*A StartCell used for tests.*/
	private StartCell startCell;
	/*A player used for tests.*/
	private Player player;
	/*Start cell is always the cell in the index 0 of a board.*/
	private static final int ALWAYS_ZERO_BOARD_INDEX=0;

	//Executed before each test :
	@Before
	public void before() {
		this.startCell =new StartCell();
		this.player = new Player("Timoléon");
		this.startCell.setPlayer(this.player);
		this.player.setCell(this.startCell);
	}

	//Test setter and getter for a player : This method is independant of before method.
	@Test
	public void setAndGetPlayerStartCellTest() {
		StartCell localCell = new StartCell();
		Player localPlayer = new Player("Frodon");
		assertEquals(null,localCell.getPlayer());
		localCell.setPlayer(localPlayer);
		assertEquals(localPlayer,localCell.getPlayer());
	}

	//Test the exception of the setPlayer method.
	@Test(expected = IllegalArgumentException.class)
	public void setPlayerExceptionStartCellTest(){
			this.startCell.setPlayer(null);
	}

	//Test for getter on the cell index.
	@Test
	public void getIndexStartCellTest(){
		assertEquals(ALWAYS_ZERO_BOARD_INDEX,this.startCell.getIndex());
	}


	//Test for removing the player in the cell.
	@Test
	public void removePlayerStartCellTest() {
		assertEquals(this.player,this.startCell.getPlayer());
		this.startCell.removePlayer();
		assertEquals(this.startCell.getPlayer(),null);
	}

	//Test to know if the cell is busy.
	@Test
	public void isBusyStartCellTest(){
		assertTrue(this.startCell.isBusy());
		this.startCell.removePlayer();
		assertFalse(this.startCell.isBusy());
	}

	//Test for canLeave :
	@Test
	public void canLeaveStartCellTest() {
		assertTrue(this.startCell.canLeave());
	}

	//Test to check the good string representation of the StartCell with the toString method :
	@Test
	public void testToStringStartCell(){
		assertEquals(""+ALWAYS_ZERO_BOARD_INDEX,this.startCell.toString());
	}

	//Test of the StartCell action :
	@Test
	public void actionTestStartCell() {
		assertEquals(ALWAYS_ZERO_BOARD_INDEX,this.startCell.action(this.player.twoDiceThrow()));
	}

	//Test for the equality between cells :
	@Test
	public void testEquals() {
		StartCell localStartCell =new StartCell();
		BasicCell localBasicCell =new BasicCell(0);
		WaitCell localWaitCell =new WaitCell(0,2);
		TrapCell localTrapCell = new TrapCell(0);
		JumpCell localJumpCell = new JumpCell(0,1);
		GooseCell localGooseCell = new GooseCell(0);
		assertTrue(localStartCell.equals(this.startCell));
		assertFalse(localBasicCell.equals(this.startCell));
		assertFalse(localWaitCell.equals(this.startCell));
		assertFalse(localTrapCell.equals(this.startCell));
		assertFalse(localJumpCell.equals(this.startCell));
		assertFalse(localGooseCell.equals(this.startCell));
	}

	// ---For test execution----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(StartCellTest.class);
	}

}
