package goosegame.cells;
import goosegame.Cell;
/**
  * A class to manage a BasicCell for goosegame.
  * BasicCell have no specific behavior on the player.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class BasicCell extends Cell{

  /**
    * Constructor for BasicCell.
    * Creates a BasicCell without player.
    * @param index Index of the Cell on the board.
    */
  public BasicCell(int index){
    super(index);
  }

  /**
    * Gives the arrival cell index after a dice throw.
    * Side effect : BasicCell action is to return his index.
    * @param diceThrow The player's dice throw.
    * @return The index of the arrival cell.
    */
  public int action(int diceThrow){
    return this.getIndex();
  }

  /**
    * This BasicCell is equals to another if they have the same index.
    * @param o The object to test the equality with this cell.
    * @return <code>true</code> if other is the same cell than this cell, otherwise <code>false</code>.
    * @see java.lang.Object#equals(java.lang.Object)
    */
  public boolean equals(Object o) {
    if (o instanceof BasicCell) {
      BasicCell theOther = ((BasicCell) o);
      return this.getIndex()==theOther.getIndex();
    } else {
      return false;
    }
  }

  public int getIndex() {
    return this.index;
  }
}
