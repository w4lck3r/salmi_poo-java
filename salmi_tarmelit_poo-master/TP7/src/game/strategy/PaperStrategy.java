package game.strategy;
import game.strategy.Strategy ;
import game.Shape;
/**
 * A class which represent the strategy which play only PAPER Shape.
 * @author SALMI Badr-Eddine / TARMELIT Lydia
 * @version v1.0
 */
public class PaperStrategy implements Strategy{

  /**
    * Gives the shape to play with this strategy.
    * @return The Shape to play.
    */
  public Shape getShape(){
    return Shape.PAPER;
  }

}
