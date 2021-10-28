package goosegame;
import goosegame.cells.*;
/**
  * An Abstract class to manage Board for goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public abstract class Board{
  //Instances variables :
  /*Number of Cell in the board.*/
  protected int nbOfCells;
  /*Array which contains cells in the board.*/
  protected Cell []theCells;

  /**
    * Constructor for Board.
    * Creates a game board.
    * @param nbCells Number of Cells on the board.
    */
  public Board(int nbCells){
    this.theCells=new Cell[nbCells];
    this.nbOfCells = nbCells;
    this.initBoard();
    this.theCells[0]= new StartCell();
  }

  /**
    * Initializes the Board.
    * Side effect : Affect cells to the board.
    */
  protected abstract void initBoard();

  /**
    * Gives the cell which is in a specific index in the board.
    * @param index The index of the target cell.
    * @return The cell at the position index on the board.
    */
  public Cell getCell(int index){
    return this.theCells[index];
  }

  /**
    * Gives the number of cell in the board.
    * @return The number cell of cell in the board.
    */
  public int getNumberOfCells(){
    return this.nbOfCells;
  }
}
