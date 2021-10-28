package game.strategy;
import game.Shape;
/**
 * A class which represent the strategy : ROCK Shape at pair round and PAPER Shape at odd round.
 * @author SALMI Badr-Eddine / TARMELIT Lydia
 * @version v1.0
 */
public class RockPaperStrategy implements Strategy{

  //Instance variables :
  /*The Shape*/
  private Shape s;
  /*Indicates if the round is pair or odd*/
  private boolean pair=true;

  /**
    * Gives the shape to play with this strategy.
    * @return The Shape to play.
    */
  public Shape getShape(){
    if(pair)
      s=Shape.ROCK;
    else
      s= Shape.PAPER;
    this.pair=!(this.pair);
    return s;
  }

}
