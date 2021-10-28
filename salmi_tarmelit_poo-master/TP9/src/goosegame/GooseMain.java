package goosegame;
import goosegame.boards.*;
import java.util.Map;
import java.util.HashMap;
/**
  * A class to show an example of use of the package goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class GooseMain{

  //Instances variables :
  /*Contains playable boards.*/
  private static Map<String,Board> boardChoices;
  /*The minimum number of arguments.*/
  private static final int ARGS_REQUIRED_LENGTH = 2;
  /*The args index of board selection.*/
  private static final int SELECT_BOARD_INDEX = 0;

  /**
    * Initializes the Map which contain playable board(s).
    * Other information : Susceptible to evolve with the addition of boards.
    */
  private static void createBoardChoice(){
    boardChoices = new HashMap<String,Board>();
    boardChoices.put("classical",new ClassicalBoard());
    boardChoices.put("25basics",new OnlyBasicBoard(25));
  }

  /**
    * Main function which display differents behavior of classical goose game.
    * @param args Arguments given by the user in the control terminal.
    */
  public static void main(String[] args){
    //Initializes playable board(s).
    createBoardChoice();
    if (args.length >=ARGS_REQUIRED_LENGTH){
      if(!boardChoices.containsKey(args[SELECT_BOARD_INDEX])){
        System.out.println("The name of the goose game board must be a choice between :");
        for (String mapKey : boardChoices.keySet()) {
          System.out.println(mapKey);
        }
      }
      else{
        Board board =boardChoices.get(args[SELECT_BOARD_INDEX]);
        Game goosegame = new Game(board);
        for (int i= 1;i<args.length;i++){
          goosegame.addPlayer(new Player(args[i]));
        }
        try{
          goosegame.play();
        }
        catch(InvalidNumberPlayerException e){
          System.out.println(e);
        }
      }
    }
    else{
      System.out.println("Please give "+ARGS_REQUIRED_LENGTH+" arguments at least.\nFirst Name of the goose game board between :");
      for (String mapKey : boardChoices.keySet()) {
        System.out.println(mapKey);
      }
      System.out.println("After give players names.");
      System.out.println("For example : java classicalMain classical frodo sam");
    }
	}
}
