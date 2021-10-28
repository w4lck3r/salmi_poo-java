package game;
import game.strategy.*;
import game.util.io.*;
/**
 * A class for user to play a game of shifumi versus a computer.
 * @author SALMI Badr-Eddine / TARMELIT Lydia
 * @version v1.0
 */
public class ShifumiMain{

  /**
    * Main function to interact with a computer to play a game  by a control terminal.
    * @param args Arguments given by the user in the control terminal.
    * @exception NumberFormatException Only integer are authorized otherwise that exception is triggered.
    */
  public static void main(String[] args){
    String StrategiesArray[] = {"Plays a random shape.","Only plays the paper shape.","Plays alternately rock shape then paper shape.",
    "Plays interactive shape (for 2 players)."};
    if (args.length <=0){
      System.out.println("Please pass as argument the strategy used by the computer.\n(For help type: java -jar rps.jar help)");
    }
    else{
      int numberStrats=4;
      if(args[0].equals("help")){
        for(int i = 0; i < StrategiesArray.length; i++){
          System.out.println("The strategy " + i +" is : " + StrategiesArray[i]);
        }
        System.out.println("To choose the computer strategy's give the number of the strategy as argument.\nFor example, run: java -jar rps.jar 0");
      }
      else{
        try{
          //Tries to convert the argument to an integer because the strategies are represented by integers.
          int choosenStrat = Integer.parseInt(args[0]);
          Player computer;
          Player player1;
          String playerName;
          String COMPUTER_NAME="DEEP BLUE";
          //Tries to find the chosen strategy.
          switch (choosenStrat){
            case 0:
              computer = new Player(COMPUTER_NAME,new RandomStrategy());
              break;
            case 1:
              computer = new Player(COMPUTER_NAME,new PaperStrategy());
              break;
            case 2:
              computer = new Player(COMPUTER_NAME,new RockPaperStrategy());
              break;
            case 3:
              computer = new Player(COMPUTER_NAME,new InteractiveStrategy());
              break;
            default:
              throw new IllegalArgumentException();
          }
          System.out.println("I'm the computer, my name is "+COMPUTER_NAME+".\nGive me your name.");
          playerName = io.Input.readString();
          if(playerName.equals("Timoléon"))
            System.out.println("Timoléon ? I like this name !");
          else
            System.out.println("It's a particular name...\nI would have preferred that your name is Timoléon but it suits me.");
          System.out.println("My strategy will be : " + StrategiesArray[choosenStrat]);
          player1 =new Player(playerName,new InteractiveStrategy());
          System.out.println("The game will start, I decide to play 10 rounds. Good Luck!\n\n");
          Game shifumi = new Game(player1,computer,10);
          shifumi.play();
        }
        //If we can't get an integer, we need to catch the exception.(float, long int ... are prohibited we only need an int)
        catch(NumberFormatException e){
          System.out.println("The strategy of the computer must be a positive integer <2147483648.\nFor example, run: java -jar rps.jar 0");
        }
        //We only need an int between 0 and 3.
        catch(IllegalArgumentException e){
          System.out.println("The strategy you entered is not appropriate, computer's Strategies start at 0.\n(For help type: java -jar rps.jar help)");
        }
      }
    }
  }
}
