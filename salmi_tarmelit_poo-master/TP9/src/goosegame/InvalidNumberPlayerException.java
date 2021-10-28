package goosegame;
/**
  * An exception class for invalid number of player of the goosegame package.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class InvalidNumberPlayerException extends Exception{
  /**
    * Constructor for InvalidNumberPlayerException
    * Used if there are no players on a game of goosegame.
    * @param message The explicit message when this error occurs.
    */
  public InvalidNumberPlayerException(String message){
    super(message);
  }
}
