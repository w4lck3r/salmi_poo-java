package goosegame.cells;
/**
  * A class to manage a WaitCell for goosegame.
  * WaitCell force the player's to wait before leaving the cell.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class WaitCell extends BasicCell{

  //Instances variables :
  /*The wait time when we land on the cell.*/
  private final int cellWaitRound;
  /*The current wait time of the player on the cell.*/
  private int playerWaitRound;

  /**
    * Constructor for WaitCell.
    * Creates a WaitCell without player.
    * @param index Index of the Cell on the board.
    * @param nbRoundOfWaiting The wait time when we land on the cell.
    */
  public WaitCell(int index,int nbRoundOfWaiting){
    super(index);
    this.cellWaitRound=nbRoundOfWaiting;
    this.playerWaitRound=nbRoundOfWaiting;
  }

  /**
    * Indicates if the player can leave the cell.
    * @return <code>true</code> if the player can leave otherwise <code>false</code>
    */
  public boolean canLeave(){
    if (playerWaitRound>0){
      this.playerWaitRound--;
      return false;
    }
    else{
      this.playerWaitRound=cellWaitRound;
      return true;
    }
  }

  /**
		* Displays informations about the waiting time cell.
		* @return The representation of a WaitCell.
		* @see java.lang.Object#toString()
		*/
  public String toString(){
    return super.toString()+" (waiting for "+this.cellWaitRound+" turns)";
  }

  /**
    * This WaitCell is equals to another if they have the same index.
    * @param o The object to test the equality with this cell.
    * @return <code>true</code> if other is the same cell than this cell, otherwise <code>false</code>.
    * @see java.lang.Object#equals(java.lang.Object)
    */
  public boolean equals(Object o) {
    if (o instanceof WaitCell) {
      WaitCell theOther = ((WaitCell) o);
      return this.getIndex()==theOther.getIndex();
    } else {
      return false;
    }
  }
}
