package game.strategy;
import game.Shape;
/**
 * A class to use a random Shape as a strategy.
 * @author BONVOISIN Alexandre SELMANI Katia
 * @version v1.0 | 22/03/2019
 */
public class RandomStrategy implements Strategy{

  /**
    * Gives the shape to play with this strategy.
    * @return The Shape to play.
    */
  public Shape getShape(){
    return Shape.randomShape();
  }

}
