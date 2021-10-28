package goosegame.boards;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import goosegame.Board;
import goosegame.cells.BasicCell;
import goosegame.cells.StartCell;
/**
  * A test class for the OnlyBasicBoard in the package goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class OnlyBasicBoardTest{

  //Test for getting number of cells on the OnlyBasicBoard.
  @Test
  public void getNumberOfCellsOnlyBasicBoardTest(){
    Board basicBoard=new OnlyBasicBoard(25);
    assertEquals(25,basicBoard.getNumberOfCells());
  }

  //Test for getting a specific cells on the OnlyBasicBoard.
  @Test
  public void getCellOnlyBasicBoardTest(){
    Board basicShortBoard=new OnlyBasicBoard(10);
    assertEquals(new StartCell(),basicShortBoard.getCell(0));
    BasicCell localBasicCell=new BasicCell(1);
    for(int i= 1;i<basicShortBoard.getNumberOfCells();i++){
      localBasicCell = new BasicCell(i);
      assertEquals(localBasicCell,basicShortBoard.getCell(i));
    }
  }

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(OnlyBasicBoardTest.class);
  }
}
