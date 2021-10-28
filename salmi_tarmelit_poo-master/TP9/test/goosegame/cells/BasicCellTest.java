package goosegame.cells;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import goosegame.cells.*;
import goosegame.Player;
/**
  * A test class for the BasicCell in the package goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class BasicCellTest{
	//Instance variables :
	/*A BasicCell used for tests.*/
	private BasicCell basicCell;
	/*A player used for tests.*/
	private Player player;

	//Executed before each test :
	@Before
	public void before() {
		this.basicCell = new BasicCell(7);
		this.player = new Player("Timoléon");
		this.basicCell.setPlayer(this.player);
		this.player.setCell(this.basicCell);
	}

	//Test setter and getter for a player : This method is independant of before method.
	@Test
	public void setAndGetPlayerBasicCellTest() {
		BasicCell localCell = new BasicCell(5);
		Player localPlayer = new Player("Frodon");
		assertEquals(null,localCell.getPlayer());
		localCell.setPlayer(localPlayer);
		assertEquals(localPlayer,localCell.getPlayer());
	}

	//Test the exception of the setPlayer method.
	@Test(expected = IllegalArgumentException.class)
	public void setPlayerExceptionBasicCellTest(){
			this.basicCell.setPlayer(null);
	}

	//Test for getter on the cell index.
	@Test
	public void getIndexBasicCellTest(){
		assertEquals(7,this.basicCell.getIndex());
	}


	//Test for removing the player in the cell.
	@Test
	public void removePlayerBasicCellTest() {
		assertEquals(this.player,this.basicCell.getPlayer());
		this.basicCell.removePlayer();
		assertEquals(this.basicCell.getPlayer(),null);
	}

	//Test to know if the cell is busy.
	@Test
	public void isBusyBasicCellTest(){
		assertTrue(this.basicCell.isBusy());
		this.basicCell.removePlayer();
		assertFalse(this.basicCell.isBusy());
	}

	//Test for canLeave :
	@Test
	public void canLeaveBasicCellTest() {
		assertTrue(this.basicCell.canLeave());
	}

	//Test of the BasicCell action :
	@Test
	public void actionTestBasicCell() {
		assertEquals(7,this.basicCell.action(this.player.twoDiceThrow()));
		this.basicCell = new BasicCell(3);
		assertEquals(3,this.basicCell.action(this.player.twoDiceThrow()));
	}

	//Test to check the good string representation of the BasicCell with the toString method :
	@Test
	public void testToStringBasicCell(){
		assertEquals("7",this.basicCell.toString());
	}

	//Test for the equality between cells :
	@Test
	public void testEquals() {
		StartCell localStartCell =new StartCell();
		BasicCell localBasicCell =new BasicCell(8);
		WaitCell localWaitCell =new WaitCell(7,2);
		TrapCell localTrapCell = new TrapCell(7);
		JumpCell localJumpCell = new JumpCell(7,1);
		GooseCell localGooseCell = new GooseCell(7);
		assertTrue(this.basicCell.equals(new BasicCell(7)));
		assertFalse(localStartCell.equals(this.basicCell));
		assertFalse(localBasicCell.equals(this.basicCell));
		assertFalse(localWaitCell.equals(this.basicCell));
		assertFalse(localTrapCell.equals(this.basicCell));
		assertFalse(localJumpCell.equals(this.basicCell));
		assertFalse(localGooseCell.equals(this.basicCell));
	}

	// ---For test execution----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(BasicCellTest.class);
	}
}
