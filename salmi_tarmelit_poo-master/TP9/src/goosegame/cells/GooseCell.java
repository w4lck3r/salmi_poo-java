package goosegame.cells;
/**
  * A class to manage a GooseCell for goosegame.
  * GooseCell double the player's dice throw then the player move 2 times further.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class GooseCell extends BasicCell{

  /**
    * Constructor for GooseCell.
    * Creates a GooseCell without player.
    * @param index Index of the Cell on the board.
    */
  public GooseCell(int index){
    super(index);
  }

  /**
    * Gives the arrival cell index after a dice throw.
    * Side effect : GooseCell double the player's dice throw.
    * @param diceThrow The player's dice throw.
    * @return The index of the arrival cell.
    */
  public int action(int diceThrow){
    return this.getIndex()+diceThrow;
  }

  /**
		* Displays informations about the goose cell.
		* @return The representation of a GooseCell.
		* @see java.lang.Object#toString()
		*/
  public String toString(){
    return super.toString()+" (goose) and jumps to ";
  }

  /**
    * This GooseCell is equals to another if they have the same index.
    * @param o The object to test the equality with this cell.
    * @return <code>true</code> if other is the same cell than this cell, otherwise <code>false</code>.
    * @see java.lang.Object#equals(java.lang.Object)
    */
  public boolean equals(Object o) {
    if (o instanceof GooseCell) {
      GooseCell theOther = ((GooseCell) o);
      return this.getIndex()==theOther.getIndex();
    } else {
      return false;
    }
  }
}
