package game;
import game.strategy.Strategy;
import game.Shape;
/**
 * A class to create and manage a Player in the shifumi game.
 * @author SALMI Badr-Eddine / TARMELIT Lydia
 * @version v1.0
 */
public class Player{
  //Instance variables :
  /*Player's name*/
  private String name;
  /*Player's number of points*/
  private int nbPoints;
  /*Player's strategy*/
  private Strategy strategy;
  /*Last Shape played*/
  private Shape lastShape;

 /**
   * Constructor of Player
   * @param name  the name of the player
   * @param strategy the strategy choosed by the player
   */
 public Player(String name,Strategy strategy){
   this.name = name;
   this.strategy = strategy;
   this.lastShape=null;
 }

  /**
    * Gives the name of the Player.
    * @return The name of the player.
    */
  public String getName(){
    return this.name;
  }

  /**
    * Gives points number of the player.
    * @return The number of points of the player.
    */
  public int getPoints(){
    return this.nbPoints;
  }

  /**
    * Adds points to the player.
    * @param points The number of added points.
    * @throws IllegalArgumentException If given points are negative.
    */
  public void addPoints(int points)throws IllegalArgumentException{
    if(points>=0)
      this.nbPoints +=points;
    else
      throw new IllegalArgumentException("Given points must be 0 or positive integer.");
  }

  /**
    * Gives the last Shape played by the Player.
    * @return The last Shape played by the Player.
    */
  public Shape getShape(){
    return this.lastShape;
  }

  /**
    * Plays a round of the chosen strategy.
    * @return The new Shape played by the Player.
    */
  public Shape play(){
    this.lastShape =this.strategy.getShape();
    return this.lastShape;
  }

  /**
    * Displays the name of the Player and the Shape played.
    * @return The representation of player and what Shape he plays.
    */
  public String toString(){
    if(this.getShape()==null)
      return this.getName()+" has not played yet.";
    else
      return this.getName()+" played " + this.getShape();
  }

}
