package goosegame.cells;
/**
  * A class to manage a TrapCell for goosegame.
  * TrapCell forbid the player to leaving the cell.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class TrapCell extends BasicCell{

  /**
    * Constructor for TrapCell.
    * Creates a TrapCell without player.
    * @param index Index of the Cell on the board.
    */
  public TrapCell(int index){
    super(index);
  }

  /**
    * Indicates if the player can leave the cell.
    * @return <code>true</code> if the player can leave otherwise <code>false</code>
    */
  public boolean canLeave(){
    return false;
  }

  /**
		* Displays informations about the trap cell.
		* @return The representation of a TrapCell.
		* @see java.lang.Object#toString()
		*/
  public String toString(){
    return super.toString()+" (trap) ";
  }

  /**
    * This TrapCell is equals to another if they have the same index.
    * @param o The object to test the equality with this cell.
    * @return <code>true</code> if other is the same cell than this cell, otherwise <code>false</code>.
    * @see java.lang.Object#equals(java.lang.Object)
    */
  public boolean equals(Object o) {
    if (o instanceof TrapCell) {
      TrapCell theOther = ((TrapCell) o);
      return this.getIndex()==theOther.getIndex();
    } else {
      return false;
    }
  }
}
