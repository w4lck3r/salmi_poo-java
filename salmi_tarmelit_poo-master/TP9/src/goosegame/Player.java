package goosegame;
import java.util.Random;
/**
  * A player in the goosegame aka "jeu de l'oie" game
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class Player {
	//Instances variables :
	/*A random number instance to simulate dice throws.*/
	private static final Random ALEA = new Random();
  /* Current player's cell. */
  private Cell cell;
  /*Player's name.*/
  private final String name;

  /**
		* Constructor for Player with setting the cell at the build.
   	* @param name The name of this player.
   	* @param cell The starting cell of this player.
  	*/
  public Player (String name, Cell cell){
      this.name = name;
      this.cell = cell;
  }

	/**
		* Constructor for Player without setting the cell at the build.
		* @param name The name of this player.
		*/
  public Player (String name){
      this(name, null);
  }

	/**
		* Displays informations about the player.
		* @return The player's name.
		* @see java.lang.Object#toString()
		*/
  public String toString(){
		 return name;
	 }

  /**
		* Gives the current cell of the player.
    * @return The current cell of the player.
    */
  public Cell getCell() {
     return this.cell;
  }

  /**
		*Sets or Changes the cell of the player.
   	* @param newCell The new cell to set.
  	*/
  public void setCell(Cell newCell) {
     this.cell = newCell;
  }

  /**
		* Throw a 6 faces dice.
   	* @return Random result of a dice throw.
  	*/
  private int oneDieThrow() {
     return ALEA.nextInt(6)+ 1;
  }
	/**
		* Throw two 6 faces dice.
   	* @return Random result of a two dices throw.
  	*/
  public int twoDiceThrow() {
      return oneDieThrow() + oneDieThrow();
  }
}
