package goosegame.boards;

import goosegame.Board;
import goosegame.cells.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
  * A test class for the ClassicalBoard in the package goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class ClassicalBoardTest{

  //Test for getting number of cells on the ClassicalBoard.
  @Test
  public void getNumberOfCellsOnlyBasicBoardTest(){
    Board classicalBoard=new ClassicalBoard();
    assertEquals(64,classicalBoard.getNumberOfCells());
  }

  //Test for getting a specific cells on the ClassicalBoard.
  @Test
  public void getCellClassicalBoardTest(){
    Board classicalBoard=new ClassicalBoard();
    assertEquals(new StartCell(),classicalBoard.getCell(0));
    BasicCell localBasicCell=new BasicCell(1);
    for(int i= 1;i<classicalBoard.getNumberOfCells();i++){
      switch(i) {
        case 9:case 18:case 27:case 36:case 45:case 54:
          localBasicCell = new GooseCell(i);
          break;
        case 31:case 52:
          localBasicCell = new TrapCell(i);
          break;
        case 19:
          localBasicCell = new WaitCell(i,2);
          break;
        case 6:
          localBasicCell = new JumpCell(i,12);
          break;
        case 42:
          localBasicCell = new JumpCell(i,30);
          break;
        case 58:
          localBasicCell = new JumpCell(i,1);
          break;
        default:
          localBasicCell = new BasicCell(i);
      }
      assertEquals(localBasicCell,classicalBoard.getCell(i));
    }
  }

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(ClassicalBoardTest.class);
  }
}
