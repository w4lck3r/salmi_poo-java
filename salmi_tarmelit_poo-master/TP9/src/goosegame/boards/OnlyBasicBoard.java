package goosegame.boards;
import goosegame.Board;
import goosegame.cells.*;
/**
  * An class to manage a Board for goosegame which have only basic cells.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class OnlyBasicBoard extends Board{

  /**
    * Constructor for OnlyBasicBoard.
    * Creates a board which have only basic cells.
    * @param nbCells Number of Cells on the board.
    */
  public OnlyBasicBoard(int nbCells){
    super(nbCells);
  }

  /**
    * Initializes the Board of a goose game.
    * Side effect : Affect cells to the board.
    */
  protected void initBoard(){
    for (int i=0; i<this.theCells.length; i++){
          this.theCells[i] = new BasicCell(i);
    }
  }

}
