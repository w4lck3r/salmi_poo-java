package game.strategy;
import game.Shape;
import game.util.io.*;
/**
 * A class which represent the interactive strategy where the player choose the Shape he play.
 * @author SALMI Badr-Eddine / TARMELIT Lydia
 * @version v1.0
 */

public class InteractiveStrategy implements Strategy {

  /**
    * Gives the shape to play with this strategy.
    * @return The Shape to play.
    */
  public Shape getShape(){
    System.out.println("Please write the name of the shape you want to play.(ROCK/rock, PAPER/paper OR SCISSORS/scissors)");
    //The toUpperCase method allows the user to write the name of a shape in lower case
    String playerInput = io.Input.readString().toUpperCase();
    while(!Shape.contains(playerInput)){
      System.out.println("Please write the name of the shape you want to play.(ROCK/rock, PAPER/paper OR SCISSORS/scissors)");
      playerInput = io.Input.readString().toUpperCase();
    }
    System.out.println("\n");
    return Shape.valueOf(playerInput);
  }

}
