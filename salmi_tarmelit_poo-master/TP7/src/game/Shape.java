package game;
import java.util.Random;
/**
 * An enumerate class to create and manage Shape for the shifumi game.
 * @author SALMI Badr-Eddine / TARMELIT Lydia
 * @version v1.0
 */
public enum Shape{
  SCISSORS,
  PAPER,
  ROCK;

  /**
    * Pick a random value of the Shape enum.
    * @return a random Shape.
    */
  public static Shape randomShape(){
    Random tirage = new Random();
    return Shape.values()[tirage.nextInt(Shape.values().length)];
  }

  /**
    * Compare 2 Shape .
    * @param otherShape The Shape to compare.
    * @return (0 if Shape are the same, -1 if the other Shape is stronger otherwise 1 if the other Shape is weaker)
    */
  public int compareShape(Shape otherShape){
      if (this==otherShape)
        return 0;
      else{
        if (this==Shape.ROCK){
          if (otherShape==Shape.PAPER)
              return -1;
          else
              return 1;
        }
        else if (this==Shape.PAPER){
          if (otherShape==Shape.ROCK)
            return 1;
          else
            return -1;
        }
        else{
          if (otherShape==Shape.ROCK)
            return -1;
          else
            return 1;
        }
      }
  }

  /**
    * Indicates if the Shape enum contains a value like the string given in argument.
    * @param str The value to test in the enumerate.
    * @return <code>true</code> if the Shape enum contains a value like the string value otherwise <code>false</code>
    */
  public static boolean contains(String str){
    for(int i=0;i<Shape.values().length;i++){
      if(str.equals(Shape.values()[i].toString()))
        return true;
    }
    return false;
  }

}
