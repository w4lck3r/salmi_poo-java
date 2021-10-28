package goosegame.cells;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import goosegame.cells.*;
import goosegame.Player;
/**
  * A test class for the JumpCell in the package goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class JumpCellTest{
	//Instance variables :
	/*A JumpCell used for tests.*/
	private JumpCell jumpCell;
	/*A player used for tests.*/
	private Player player;

	//Executed before each test :
	@Before
	public void before(){
		this.jumpCell =new JumpCell(7,23);
		this.player = new Player("Timoléon");
		this.jumpCell.setPlayer(this.player);
		this.player.setCell(this.jumpCell);
	}

	//Test setter and getter for a player : This method is independant of before method.
	@Test
	public void setAndGetPlayerJumpCellTest() {
		JumpCell localCell = new JumpCell(7,23);
		Player localPlayer = new Player("Frodon");
		assertEquals(null,localCell.getPlayer());
		localCell.setPlayer(localPlayer);
		assertEquals(localPlayer,localCell.getPlayer());
	}

	//Test the exception of the setPlayer method.
	@Test(expected = IllegalArgumentException.class)
	public void setPlayerExceptionJumpCellTest(){
			this.jumpCell.setPlayer(null);
	}

	//Test for getter on the cell index.
	@Test
	public void getIndexJumpCellTest(){
		assertEquals(7,this.jumpCell.getIndex());
	}


	//Test for removing the player in the cell.
	@Test
	public void removePlayerJumpCellTest() {
		assertEquals(this.player,this.jumpCell.getPlayer());
		this.jumpCell.removePlayer();
		assertEquals(this.jumpCell.getPlayer(),null);
	}

	//Test to know if the cell is busy.
	@Test
	public void isBusyJumpCellTest(){
		assertTrue(this.jumpCell.isBusy());
		this.jumpCell.removePlayer();
		assertFalse(this.jumpCell.isBusy());
	}

	//Test for canLeave :
	@Test
	public void canLeaveJumpCellTest() {
		assertTrue(this.jumpCell.canLeave());
	}

	//Test to check the good string representation of the JumpCell with the toString method :
	@Test
	public void testToStringJumpCell(){
		assertEquals("7 (teleport to 23) and jumps to ",this.jumpCell.toString());
	}

	//Test of the JumpCell action :
	@Test
	public void actionTestJumpCell() {
		assertEquals(23,this.jumpCell.action(this.player.twoDiceThrow()));
	}

	//Test for the equality between cells :
	@Test
	public void testEquals() {
		StartCell localStartCell =new StartCell();
		BasicCell localBasicCell =new BasicCell(7);
		WaitCell localWaitCell =new WaitCell(7,2);
		TrapCell localTrapCell = new TrapCell(7);
		GooseCell localGooseCell = new GooseCell(7);
		JumpCell localJumpCell = new JumpCell(8,2);
		assertTrue(this.jumpCell.equals(new JumpCell(7,23)));
		assertFalse(localStartCell.equals(this.jumpCell));
		assertFalse(this.jumpCell.equals(localBasicCell));
		assertFalse(localWaitCell.equals(this.jumpCell));
		assertFalse(localTrapCell.equals(this.jumpCell));
		assertFalse(localGooseCell.equals(this.jumpCell));
		assertFalse(localJumpCell.equals(this.jumpCell));
	}

	// ---For test execution----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(JumpCellTest.class);
	}

}
