package game.strategy;
import game.Shape;
/**
 * An interface class to create Strategy to play shifumi game.
 * @author SALMI Badr-Eddine / TARMELIT Lydia
 * @version v1.0
 */
public interface Strategy{

  /**
    * Obtains the shape to play in function of the strategy which call this interface.
    * @return The shape to play in function of the strategy which call this interface.
    */
  public Shape getShape();
}
