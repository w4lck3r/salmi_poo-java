package goosegame.boards;
import goosegame.Board;
import goosegame.cells.*;
/**
  * A class to manage a classical Board for goosegame.
  * @author SALMI Badr-eddine / TARMELIT Lydia
  * @version 22/12/2020
  */
public class ClassicalBoard extends Board{

  private static final int CLASSICAL_NUMBER_OF_CELL=64;

  /**
    * Constructor for ClassicalBoard.
    * Creates a classical game board :
    * -64 cells.
    * -Cells 9,18,27,36,45,54 are goose cells.
    * -Cells 31 and 52 are trap cells.
    * -Cell 19 is wait cell.
    * -Cells 6 is jump cell to cell 12.
    * -Cells 42 is jump cell to cell 30.
    * -Cells 58 is jump cell to cell 1.
    */
  public ClassicalBoard(){
    super(CLASSICAL_NUMBER_OF_CELL);
  }

  /**
    * Initializes the Board of a goose game.
    * Side effect : Affect cells to the board.
    */
  protected void initBoard(){
    for (int i=0; i<this.theCells.length; i++){
      switch(i) {
        case 9:case 18:case 27:case 36:case 45:case 54:
          this.theCells[i]= new GooseCell(i);
          break;
        case 31:case 52:
          this.theCells[i]= new TrapCell(i);
          break;
        case 19:
          this.theCells[i]= new WaitCell(i,2);
          break;
        case 6:
          this.theCells[i]= new JumpCell(i,12);
          break;
        case 42:
          this.theCells[i]= new JumpCell(i,30);
          break;
        case 58:
          this.theCells[i]= new JumpCell(i,1);
          break;
        default:
          this.theCells[i] = new BasicCell(i);
      }
    }
  }

}
