package goosegame;

/**
  * An Abstract class to manage a Cell for goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public abstract class Cell{

  //Instances variables :
  /*Player on the Cell.*/
  protected Player player;
  /*Index of the Cell on the board.*/
  protected int index;

  /**
    * Constructor for Cell.
    * Creates a Cell without player.
    * @param index Index of the Cell on the board.
    */
  public Cell(int index){
    this.index=index;
    this.player= null;
  }

  /**
    * Gives the index of the cell on the board.
    * @return The index of the cell.
    */
  public int getIndex(){
    return this.index;
  }

  /**
    * Gives the player on the cell.
    * @return The player on the cell.
    */
  public Player getPlayer(){
    return this.player;
  }

  /**
    * Gives if the cell is busy.
    * @return <code>true</code> if the cell is busy otherwise <code>false</code>.
    */
  public boolean isBusy(){
    return this.getPlayer()!=null;
  }

  /**
    * Sets the player on the Cell.
    * @param player The player to set.
    * @throws IllegalArgumentException If player is null.
    */
  public void setPlayer(Player player) throws IllegalArgumentException{
    if(player == null)
      throw new IllegalArgumentException("Player can't be null.");
    else {
      this.player = player;
    }
  }

  /**
    * Indicates if the player can leave the cell.
    * @return <code>true</code> if the player can leave otherwise <code>false</code>
    */
  public boolean canLeave(){
    return true;
  }

  /**
    * Removes the player on the cell.
    * Side effect : The cell has no player.
    */
  public void removePlayer(){
      this.player = null;
  }

  /**
    * Displays informations about the cell.
    * @return The representation of a Cell.
    * @see java.lang.Object#toString()
    */
  public String toString(){
    return ""+this.getIndex();
  }

  /**
    * Gives the arrival cell index after a dice throw.
    * Side effect : Each type of cell has a side effect that affect the arrival cell index.
    * @param diceThrow The player's dice throw.
    * @return The index of the arrival cell.
    */
  public abstract int action(int diceThrow);

  /**
    * A cell equals to another if they have the same index and type.
    * @param o The object to test the equality with a cell.
    * @return <code>true</code> if other is the same cell than this cell, otherwise <code>false</code>.
    * @see java.lang.Object#equals(java.lang.Object)
    */
  public abstract boolean equals(Object o);
}
