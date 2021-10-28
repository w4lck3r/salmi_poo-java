package goosegame.cells;
import goosegame.Cell;
/**
  * An class to manage StartCell for goosegame.
  * StartCell is the start cell of a goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class StartCell extends Cell{

  //Instances variables :
  private static final int STARTCELL_ALWAYS_FIRST_CELL = 0;

  /**
    * Constructor for StartCell.
    * Creates a StartCell without player.
    */
  public StartCell(){
    super(STARTCELL_ALWAYS_FIRST_CELL);
  }

  /**
    * Gives the arrival cell index after a dice throw.
    * Side effect : StartCell action is to return his index (always 0).
    * @param diceThrow The player's dice throw.
    * @return The index of the arrival cell.
    */
  public int action(int diceThrow){
    return STARTCELL_ALWAYS_FIRST_CELL;
  }

  /**
    * This StartCell is equals to another if they have the same index.
    * @param o The object to test the equality with this cell.
    * @return <code>true</code> if other is the same cell than this cell, otherwise <code>false</code>.
    * @see java.lang.Object#equals(java.lang.Object)
    */
  public boolean equals(Object o) {
    if (o instanceof StartCell) {
      StartCell theOther = ((StartCell) o);
      return this.getIndex()==theOther.getIndex();
    } else {
      return false;
    }
  }
}
