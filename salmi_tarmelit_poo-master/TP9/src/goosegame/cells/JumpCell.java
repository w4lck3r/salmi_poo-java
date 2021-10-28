package goosegame.cells;
/**
  * A class to manage a JumpCell for goosegame.
  * JumpCell jump the player's to an another cell.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class JumpCell extends BasicCell{

  //Instances variables :
  /*The target Cell linked with this JumpCell.*/
  private final int targetCellIndex;

  /**
    * Constructor for JumpCell.
    * Creates a JumpCell without player.
    * @param index Index of the Cell on the board.
    * @param targetIndex Index of the target Cell of this JumpCell on the board.
    */
  public JumpCell(int index,int targetIndex){
    super(index);
    this.targetCellIndex=targetIndex;
  }

  /**
    * Gives the arrival cell index after a dice throw.
    * Side effect : JumpCell jump the player's to an another cell.
    * @param diceThrow The player's dice throw.
    * @return The index of the arrival cell.
    */
  public int action(int diceThrow){
    return this.targetCellIndex;
  }

  /**
		* Displays informations about the jump cell.
		* @return The representation of a JumpCell.
		* @see java.lang.Object#toString()
		*/
  public String toString(){
    return super.toString()+" (teleport to "+this.targetCellIndex+") and jumps to ";
  }

  /**
    * This GooseCell is equals to another if they have the same index.
    * @param o The object to test the equality with this cell.
    * @return <code>true</code> if other is the same cell than this cell, otherwise <code>false</code>.
    * @see java.lang.Object#equals(java.lang.Object)
    */
  public boolean equals(Object o) {
    if (o instanceof JumpCell) {
      JumpCell theOther = ((JumpCell) o);
      return this.getIndex()==theOther.getIndex();
    } else {
      return false;
    }
  }
}
